package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.PedidoDAO;
import com.fesfafic.DAO.ProdutoDAO;
import com.fesfafic.Model.Pedido;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.UUID;

public class ProdutoController implements IController<Produto> {
    private ProdutoDAO dao;

    public ProdutoController() {
        this.dao = new ProdutoDAO();
    }

    @Override
    public Produto get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Produto> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Produto pedido) {
        return dao.adicionar(pedido);
    }

    @Override
    public boolean remover(Produto pedido) {
        return dao.remover(pedido);
    }
}
