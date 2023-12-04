package com.fesfafic.Model;

import com.fesfafic.Contract.ICarrinho;
import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;

import java.util.ArrayList;
import java.util.UUID;

public class Carrinho implements ICarrinho {
    private UUID id;
    private ICliente cliente;
    private ArrayList<Produto> produtos;

    public Carrinho(ICliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.produtos = new ArrayList<>();
    }

    @Override
    public boolean adicionarProduto(Produto produto) {
        return this.produtos.add(produto);
    }

    @Override
    public boolean removerProduto(Produto produto) {
        return this.produtos.remove(produto);
    }

    // Retorna true se o produto removido não estiver vazío
    @Override
    public boolean removerProduto(int indice) throws IndexOutOfBoundsException {
        IProduto produto = this.produtos.remove(indice);
        return (produto != null);
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public ICliente getCliente() {
        return this.cliente;
    }

    @Override
    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }
}
