package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.DAO.AvaliacaoDAO;
import com.fesfafic.Model.Avaliacao;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.UUID;

public class AvaliacaoController implements IController<Avaliacao> {
    private AvaliacaoDAO dao;

    public AvaliacaoController() {
        this.dao = new AvaliacaoDAO();
    }

    @Override
    public Avaliacao get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Avaliacao> listarTodos() {
        return dao.listarTodos();
    }

    public ArrayList<Avaliacao> listarPorProduto(IProduto produto) {
        return dao.listarPorProduto(produto);
    }

    @Override
    public boolean adicionar(Avaliacao avaliacao) {
        return dao.adicionar(avaliacao);
    }

    @Override
    public boolean remover(Avaliacao avaliacao) {
        return dao.remover(avaliacao);
    }

    public boolean removerPorProduto(Produto produto) {
        return this.dao.removerPorProduto(produto);
    }
}
