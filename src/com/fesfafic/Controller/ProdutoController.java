package com.fesfafic.Controller;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.ProdutoDAO;
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

    public Produto get(int indice) {
        return dao.get(indice);
    }

    @Override
    public ArrayList<Produto> listarTodos() {
        return dao.listarTodos();
    }

    public ArrayList<Produto> listarPorCliente(ICliente cliente) {
        return dao.listarPorCliente(cliente);
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
