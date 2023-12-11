package com.fesfafic.Contract;

import java.util.UUID;

public interface IAvaliacao {

    UUID getId();

    IUtilizador getCliente();

    IProduto getProduto();

    String getConteudo();
}
