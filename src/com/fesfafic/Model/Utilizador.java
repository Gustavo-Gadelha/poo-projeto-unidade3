package com.fesfafic.Model;

import com.fesfafic.Contract.IUtilizador;

import java.util.ArrayList;

public abstract class Utilizador implements IUtilizador {
    private String email;
    private String senha;
    private double saldo;
    private ArrayList<String> historico;

    public Utilizador(String email, String senha, double saldo) {
        this.email = email;
        this.senha = senha;
        this.saldo = saldo;
        this.historico = new ArrayList<>();
    }

    @Override
    public boolean fazerLogin(String email, String senha) {
        return (email.equals(this.email) && senha.equals(this.senha));
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean transferePara(IUtilizador utilizador, double valor) {
        if (this.sacar(valor)) {
            utilizador.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean adicionarHistorico(String transferencia) {
        return this.historico.add(transferencia);
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getSenha() {
        return this.senha;
    }

    @Override
    public ArrayList<String> getHistorico() {
        return this.historico;
    }
}
