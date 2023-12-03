package com.fesfafic.Contract;

public interface ICliente extends IUtilizador {

    boolean comprarProduto(IProduto produto);

    boolean comprarProduto(IProduto produto, int quantidade);
}
