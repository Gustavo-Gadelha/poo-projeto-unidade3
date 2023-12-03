package com.fesfafic.Model;

import com.fesfafic.Contract.IAdministrador;

import java.util.UUID;

public class Administrador implements IAdministrador {
    private UUID id;
    private String codigoDeAcesso;
    private String nome;
    private int nivel;

    public Administrador(String codigoDeAcesso, String nome, int nivel) {
        this.id = UUID.randomUUID();
        this.codigoDeAcesso = codigoDeAcesso;
        this.nome = nome;
        this.nivel = nivel;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getCodigoDeAcesso() {
        return codigoDeAcesso;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public int getNivel() {
        return nivel;
    }
}
