package com.fesfafic.Contract;

public interface ICliente extends IUtilizador {

    boolean comprarProduto(IProduto produto);

    boolean comprarProduto(IProduto produto, int quantidade);

    void depositar(double valor);

    boolean transferirPara(ICliente utilizador, double valor);

    boolean sacar(double valor);

    double getSaldo();
}
