package com.projetoCatalago.Filmes.entity;


import jakarta.persistence.*;

import java.io.Serializable;



@Entity
public class Filme implements Serializable {
    public static long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;
    private String nomefilme;
    private String ano;
    private String duracao;



    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "genero_id", nullable = false)

    private Genero genero;

    public Filme(){

    }

    public Filme(Long id, String nomefilme, String ano, String duracao, Genero genero) {
        this.id = id;
        this.nomefilme = nomefilme;
        this.ano = ano;
        this.duracao = duracao;
        this.genero = genero;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        Filme.serialVersionUID = serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomefilme() {
        return nomefilme;
    }

    public void setNomefilme(String nomefilme) {
        this.nomefilme = nomefilme;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }



    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
}



