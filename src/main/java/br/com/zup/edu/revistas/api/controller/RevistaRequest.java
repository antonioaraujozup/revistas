package br.com.zup.edu.revistas.api.controller;

import br.com.zup.edu.revistas.api.model.Revista;
import br.com.zup.edu.revistas.api.repository.TagRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;
import java.util.stream.Collectors;

public class RevistaRequest {

    @NotBlank
    @Size(max = 120)
    private String titulo;

    @NotNull
    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataPublicacao;

    @NotNull
    @Size(min = 1)
    private Set<Long> tags;

    public RevistaRequest() {
    }

    public Revista paraRevista(TagRepository tagRepository) {
        Revista revista = new Revista(titulo,dataPublicacao);

        this.tags.stream()
                .map(idTag -> tagRepository.findById(idTag).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .collect(Collectors.toSet())
                .forEach(tag -> revista.adicionaTag(tag));

        return revista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public void setTags(Set<Long> tags) {
        this.tags = tags;
    }
}
