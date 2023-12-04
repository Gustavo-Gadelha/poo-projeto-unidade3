package com.fesfafic.Controller;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.CarrinhoDAO;
import com.fesfafic.Model.Carrinho;

import java.util.ArrayList;
import java.util.UUID;

public class CarrinhoController implements IController<Carrinho> {
    private CarrinhoDAO dao;

    public CarrinhoController() {
        this.dao = new CarrinhoDAO();
    }

    @Override
    public Carrinho get(UUID id) {
        return dao.get(id);
    }

    public Carrinho get(ICliente cliente) {
        return dao.get(cliente);
    }

    @Override
    public ArrayList<Carrinho> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Carrinho carrinho) {
        return dao.adicionar(carrinho);
    }

    @Override
    public boolean remover(Carrinho carrinho) {
        return dao.remover(carrinho);
    }
}
