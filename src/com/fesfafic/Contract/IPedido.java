package com.fesfafic.Contract;

import java.util.UUID;

public interface IPedido {

    double calcularValor();

    UUID getId();

    ICliente getCliente();

    IProduto getProduto();

    int getQuantidade();

    void setQuantidade(int quantidade);
}
