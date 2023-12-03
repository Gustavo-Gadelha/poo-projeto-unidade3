package com.fesfafic.Contract;

import com.fesfafic.Model.Produto;

public interface ICarrinho {

    boolean adicionarProduto(IProduto produto);

    boolean removerProduto(IProduto produto);

    ICliente getCliente();
}
