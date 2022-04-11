package br.com.zup.edu.revistas.api.controller;

import br.com.zup.edu.revistas.api.model.Tag;

import javax.validation.constraints.NotBlank;

public class TagRequest {

    @NotBlank
    private String nome;

    public TagRequest() {
    }

    public Tag paraTag() {
        return new Tag(nome);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
