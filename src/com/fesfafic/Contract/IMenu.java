package com.fesfafic.Contract;

public interface IMenu {

    void menuInicial();

    void menuAdministrador();

    void menuCliente(ICliente cliente);

    void menuCarrinho(ICliente cliente);

    void menuVendedor(ICliente cliente);

    void menuPedido(ICliente cliente);
}
