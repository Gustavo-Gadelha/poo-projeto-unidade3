package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;

import java.util.UUID;

public class Produto implements IProduto {
    private UUID id;
    private ICliente vendedor;
    private String nome;
    private double valor;
    private int quantidade;

    public Produto(ICliente vendedor, String nome, double valor, int quantidade) {
        this.id = UUID.randomUUID();
        this.vendedor = vendedor;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public ICliente getVendedor() {
        return vendedor;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getValor() {
        return this.valor;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public int getQuantidade() {
        return this.quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
