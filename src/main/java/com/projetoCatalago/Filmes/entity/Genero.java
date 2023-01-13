package com.projetoCatalago.Filmes.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Genero implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;
    private String categoria;

    @OneToMany(mappedBy = "genero", fetch = FetchType.EAGER)
    private List<Filme> filme;

    public Genero() {

    }

    public Genero(Long id, String categoria, List<Filme> filme) {
        this.id = id;
        this.categoria = categoria;
        this.filme = filme;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Filme> getFilme() {
        return filme;
    }

    public void setFilme(List<Filme> filme) {
        this.filme = filme;
    }
}
