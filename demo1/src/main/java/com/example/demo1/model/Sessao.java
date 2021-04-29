package com.example.demo1.model;

public class Sessao {
    private Long idSessao;
    private int numSala;
    private double preco;
    private Filme dadosdoFilme;

    public Sessao(){}

    public Sessao(Long idSessao, int numSala, double preco, Filme dadosdoFilme) {
        this.idSessao = idSessao;
        this.numSala = numSala;
        this.preco = preco;
        this.dadosdoFilme = dadosdoFilme;
    }

    public Long getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Long idSessao) {
        this.idSessao = idSessao;
    }

    public int getNumSala() {
        return numSala;
    }

    public void setNumSala(int numSala) {
        this.numSala = numSala;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Filme getDadosdoFilme() {
        return dadosdoFilme;
    }

    public void setDadosdoFilme(Filme dadosdoFilme) {
        this.dadosdoFilme = dadosdoFilme;
    }


}
