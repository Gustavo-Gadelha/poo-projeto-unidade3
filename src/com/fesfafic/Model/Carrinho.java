package com.fesfafic.Model;

import com.fesfafic.Contract.ICarrinho;
import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;

import java.util.ArrayList;

public class Carrinho implements ICarrinho {
    private ICliente cliente;
    private ArrayList<IProduto> produtos;

    public Carrinho(ICliente cliente, ArrayList<IProduto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    @Override
    public boolean adicionarProduto(IProduto produto) {
        return this.produtos.add(produto);
    }

    @Override
    public boolean removerProduto(IProduto produto) {
        return this.produtos.remove(produto);
    }

    @Override
    public ICliente getCliente() {
        return this.cliente;
    }
}
