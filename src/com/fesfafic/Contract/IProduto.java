package com.fesfafic.Contract;

import java.util.UUID;

public interface IProduto {

    UUID getId();

    ICliente getVendedor();

    String getNome();

    void setNome(String nome);

    double getValor();

    void setValor(double valor);

    int getQuantidade();

    void setQuantidade(int quantidade);
}
