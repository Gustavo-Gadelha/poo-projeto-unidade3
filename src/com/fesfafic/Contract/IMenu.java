package com.fesfafic.Contract;

import com.fesfafic.Model.Administrador;
import com.fesfafic.Model.Cliente;

public interface IMenu {

    void menuInicial();

    void menuCadastro();

    void menuCliente(Cliente cliente);

    void menuVendedor(Cliente cliente);

    void menuAdministrador();

    void menuPedido();
}
