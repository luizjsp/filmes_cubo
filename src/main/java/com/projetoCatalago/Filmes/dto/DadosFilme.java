package com.projetoCatalago.Filmes.dto;

import com.projetoCatalago.Filmes.entity.Filme;

public class DadosFilme {

    private String titulo;
    private int ano;
    private String duracao;

    public DadosFilme() {

    }

    public DadosFilme(String titulo, int ano, String duracao) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
