package com.fesfafic.Contract;

import java.util.ArrayList;
import java.util.UUID;

public interface ICarrinho {

    boolean adicionarProduto(IProduto produto);

    boolean removerProduto(IProduto produto);

    UUID getId();

    ICliente getCliente();

    ArrayList<IProduto> getProdutos();
}
