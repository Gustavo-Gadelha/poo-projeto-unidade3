package com.fesfafic.Model;

import com.fesfafic.Contract.IMetodosDeAcesso;
import com.fesfafic.Contract.IUtilizador;

import java.util.UUID;

public abstract class Utilizador implements IUtilizador, IMetodosDeAcesso {
    private UUID id;
    private String email;
    private String senha;

    public Utilizador(String email, String senha) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.senha = senha;
    }

    @Override
    public boolean fazerLogin(String email, String senha) {
        return (email.equals(this.email) && senha.equals(this.senha));
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }
}
