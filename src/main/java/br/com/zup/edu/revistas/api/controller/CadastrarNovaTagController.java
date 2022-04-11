package br.com.zup.edu.revistas.api.controller;

import br.com.zup.edu.revistas.api.model.Tag;
import br.com.zup.edu.revistas.api.repository.TagRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastrarNovaTagController {

    private final TagRepository repository;

    public CadastrarNovaTagController(TagRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/tags")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TagRequest request, UriComponentsBuilder uriComponentsBuilder) {
        Tag novaTag = request.paraTag();

        repository.save(novaTag);

        URI location = uriComponentsBuilder.path("/tags/{id}")
                .buildAndExpand(novaTag.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
