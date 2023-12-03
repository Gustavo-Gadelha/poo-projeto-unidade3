package com.fesfafic.Model;

import com.fesfafic.Contract.IProduto;
import com.fesfafic.Contract.IVendedor;

public class Vendedor extends Utilizador implements IVendedor {
    public Vendedor(String email, String senha, double saldo) {
        super(email, senha, saldo);
    }

    @Override
    public IProduto publicarProduto(String nome, double valor, int quantidade) {
        return new Produto(this, nome, valor, quantidade);
    }

    @Override
    public IProduto publicarProduto(String nome, double valor, int quantidade, String descricao) {
        return new Produto(this, nome, valor, quantidade, descricao);
    }
}
