package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.PedidoDAO;
import com.fesfafic.Model.Pedido;

import java.util.ArrayList;
import java.util.UUID;

public class ProdutoController implements IController<Pedido> {
    private PedidoDAO dao;

    public ProdutoController() {
        this.dao = new PedidoDAO();
    }

    @Override
    public Pedido get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Pedido> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Pedido pedido) {
        return dao.adicionar(pedido);
    }

    @Override
    public boolean remover(Pedido pedido) {
        return dao.remover(pedido);
    }
}
