package com.fesfafic.Model;

import com.fesfafic.Contract.IAdministrador;

public class Administrador extends Utilizador implements IAdministrador {
    private String codigoDeAcesso;
    private int nivel;

    public Administrador(String email, String senha, String codigoDeAcesso, int nivel) {
        super(email, senha);
        this.codigoDeAcesso = codigoDeAcesso;
        this.nivel = nivel;
    }

    @Override
    public String getCodigoDeAcesso() {
        return codigoDeAcesso;
    }

    @Override
    public int getNivel() {
        return nivel;
    }
}
