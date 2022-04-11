package br.com.zup.edu.revistas.api.controller;

import br.com.zup.edu.revistas.api.model.Revista;
import br.com.zup.edu.revistas.api.repository.RevistaRepository;
import br.com.zup.edu.revistas.api.repository.TagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovaRevistaController {

    private final RevistaRepository repository;
    private final TagRepository tagRepository;

    public CadastrarNovaRevistaController(RevistaRepository repository, TagRepository tagRepository) {
        this.repository = repository;
        this.tagRepository = tagRepository;
    }

    @PostMapping("/revistas")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid RevistaRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Revista novaRevista = request.paraRevista(tagRepository);

        repository.save(novaRevista);

        URI location = uriComponentsBuilder.path("/revistas/{id}")
                .buildAndExpand(novaRevista.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
