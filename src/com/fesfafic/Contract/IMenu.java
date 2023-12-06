package com.fesfafic.Contract;

import com.fesfafic.Model.Administrador;

public interface IMenu {

    void menuInicial();

    void menuAdministrador(IAdministrador administrador);

    void menuCliente(ICliente cliente);

    void menuPedido(ICliente cliente);

    void menuVendedor(ICliente cliente);
}
