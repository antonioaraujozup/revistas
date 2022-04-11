package br.com.zup.edu.revistas.api.model;

import javax.persistence.*;

@Entity
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Tag() {
    }

    public Tag(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }
}
