package com.fesfafic.Contract;

import java.util.UUID;

public interface IProduto {

    UUID getId();

    ICliente getVendedor();

    String getNome();

    double getValor();

    void setValor(double valor);

    int getQuantidade();

    void setQuantidade(int quantidade);

    String getDescricao();

    void setDescricao(String descricao);
}
