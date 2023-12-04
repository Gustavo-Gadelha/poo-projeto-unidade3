package com.fesfafic.Contract;

import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.UUID;

public interface ICarrinho {

    boolean adicionarProduto(Produto produto);

    boolean removerProduto(Produto produto);

    boolean removerProduto(int indice);

    UUID getId();

    ICliente getCliente();

    ArrayList<Produto> getProdutos();
}
