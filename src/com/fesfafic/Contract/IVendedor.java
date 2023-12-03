package com.fesfafic.Contract;

public interface IVendedor {
    IProduto publicarProduto(String nome, double valor, int quantidade);
    IProduto publicarProduto(String nome, double valor, int quantidade, String descricao);
}
