package com.fesfafic.Controller;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.PedidoDAO;
import com.fesfafic.Model.Pedido;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.UUID;

public class PedidoController implements IController<Pedido> {
    private PedidoDAO dao;

    public PedidoController() {
        this.dao = new PedidoDAO();
    }

    @Override
    public Pedido get(UUID id) {
        return this.dao.get(id);
    }

    public Pedido get(int indice) {
        return dao.get(indice);
    }

    public Pedido get(Produto produto) {
        return dao.get(produto);
    }

    @Override
    public ArrayList<Pedido> listarTodos() {
        return this.dao.listarTodos();
    }

    public ArrayList<Pedido> listarPorCliente(ICliente cliente) {
        return this.dao.listarPorCliente(cliente);
    }

    @Override
    public boolean adicionar(Pedido pedido) {
        return this.dao.adicionar(pedido);
    }

    @Override
    public boolean remover(Pedido pedido) {
        return this.dao.remover(pedido);
    }

    public boolean removerPorProduto(Produto produto) {
        return this.dao.removerPorProduto(produto);
    }
}
