package com.fesfafic.Contract;

import java.util.UUID;

public interface IAvaliacao {

    UUID getId();

    IUtilizador getCliente();

    String getConteudo();

    IProduto getProduto();
}
