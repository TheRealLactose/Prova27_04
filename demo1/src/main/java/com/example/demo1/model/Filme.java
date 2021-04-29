package com.example.demo1.model;

public class Filme {
    private int idFilme;
    private String nomeFilme;
    private int idadeFilme;

    public Filme(){}

    public Filme(int idFilme, String nomeFilme, int idadeFilme) {
        this.idFilme = idFilme;
        this.nomeFilme = nomeFilme;
        this.idadeFilme = idadeFilme;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public int getIdadeFilme() {
        return idadeFilme;
    }

    public void setIdadeFilme(int idadeFilme) {
        this.idadeFilme = idadeFilme;
    }


}
