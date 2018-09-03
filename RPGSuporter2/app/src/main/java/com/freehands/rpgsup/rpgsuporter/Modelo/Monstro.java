package com.freehands.rpgsup.rpgsuporter.Modelo;

import java.io.Serializable;

public class Monstro implements Serializable {

    private String nome;
    private String pontosDeVida;
    private Long id;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPontosDeVida() {
        return pontosDeVida;
    }

    public void setPontosDeVida(String pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    @Override
    public String toString() {
        return getId() + ". " + getNome() + " HP: " + getPontosDeVida();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
