package com.fesfafic.Contract;

public interface IVendedor extends IUtilizador {

    IProduto publicarProduto(String nome, double valor, int quantidade);

    IProduto publicarProduto(String nome, double valor, int quantidade, String descricao);
}
