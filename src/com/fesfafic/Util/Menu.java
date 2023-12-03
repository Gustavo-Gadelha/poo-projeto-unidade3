package com.fesfafic.Util;

import com.fesfafic.Contract.IMenu;
import com.fesfafic.Controller.*;

public class Menu implements IMenu {
    private VendedorController vendedorController;
    private ClienteController clienteController;
    private AdministradorController administradorController;
    private ProdutoController produtoController;
    private CouponsController couponsController;
    private PedidoController pedidoController;
    private CarrinhoController carrinhoController;

    public Menu() {
        this.vendedorController = new VendedorController();
        this.clienteController = new ClienteController();
        this.administradorController = new AdministradorController();
        this.produtoController = new ProdutoController();
        this.couponsController = new CouponsController();
        this.pedidoController = new PedidoController();
        this.carrinhoController = new CarrinhoController();
    }

    @Override
    public void menuInicial() {
    }

    @Override
    public void menuCliente() {

    }

    @Override
    public void menuVendedor() {

    }

    @Override
    public void menuPedido() {

    }
}
