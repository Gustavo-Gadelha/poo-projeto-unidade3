package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IPedido;
import com.fesfafic.Contract.IProduto;

import java.util.UUID;

public class Pedido implements IPedido {
    private UUID id;
    private ICliente cliente;
    private IProduto produto;
    private int quantidade;

    public Pedido(ICliente cliente, IProduto produto, int quantidade) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        produto.setQuantidade(produto.getQuantidade() - this.quantidade);
    }

    @Override
    public double calcularValor() {
        return this.produto.getValor() * this.quantidade;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public ICliente getCliente() {
        return cliente;
    }

    @Override
    public IProduto getProduto() {
        return produto;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
