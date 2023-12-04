package com.fesfafic.Contract;

import com.fesfafic.Model.Cliente;

public interface IMenu {

    void menuInicial();

    void menuAdministrador();

    void menuCliente(ICliente cliente);

    void menuCarrinho(ICliente cliente);

    void menuVendedor(ICliente cliente);

    void menuPedido(ICliente cliente);
}
