package com.fesfafic.Model;

import com.fesfafic.Contract.IProduto;
import com.fesfafic.Contract.IVendedor;

import java.util.UUID;

public class Produto implements IProduto {
    private UUID id;
    private IVendedor vendedor;
    private String nome;
    private double valor;
    private int quantidade;
    private String descricao;

    public Produto(IVendedor vendedor, String nome, double valor, int quantidade, String descricao) {
        this.id = UUID.randomUUID();
        this.vendedor = vendedor;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public Produto(IVendedor vendedor, String nome, double valor, int quantidade) {
        this.id = UUID.randomUUID();
        this.vendedor = vendedor;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.descricao = "Produto sem descrição";
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public IVendedor getVendedor() {
        return vendedor;
    }

    @Override
    public String getNome() {
        return this.nome;
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

    @Override
    public String getDescricao() {
        return this.descricao;
    }

    @Override
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
