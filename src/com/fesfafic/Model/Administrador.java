package com.fesfafic.Model;

import com.fesfafic.Contract.IAdministrador;

public class Administrador extends Utilizador implements IAdministrador {
    private String codigoDeAcesso;

    public Administrador(String email, String senha, String codigoDeAcesso) {
        super(email, senha);
        this.codigoDeAcesso = codigoDeAcesso;
    }

    @Override
    public boolean fazerLogin(String email, String senha, String codigoDeAcesso) {
        return (super.fazerLogin(email, senha) && this.codigoDeAcesso.equalsIgnoreCase(codigoDeAcesso)) ;
    }

    @Override
    public String getCodigoDeAcesso() {
        return codigoDeAcesso;
    }
}
