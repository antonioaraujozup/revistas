package br.com.zup.edu.revistas.api.util;

import org.springframework.validation.FieldError;

public class MensagemDeErro {

    private String campo;
    private String mensagem;

    public MensagemDeErro(FieldError error) {
        this.campo = error.getField();
        this.mensagem = error.getDefaultMessage();
    }

    public String getCampo() {
        return campo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
