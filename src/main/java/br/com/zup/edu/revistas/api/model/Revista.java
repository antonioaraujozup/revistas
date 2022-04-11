package br.com.zup.edu.revistas.api.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(nullable = false)
    private LocalDate dataPublicacao;

    @ManyToMany
    private Set<Tag> tags = new HashSet<>();

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Revista() {
    }

    public Revista(String titulo, LocalDate dataPublicacao) {
        this.titulo = titulo;
        this.dataPublicacao = dataPublicacao;
    }

    public void adicionaTag(Tag novaTag) {
        this.tags.add(novaTag);
    }

    public Long getId() {
        return id;
    }
}
