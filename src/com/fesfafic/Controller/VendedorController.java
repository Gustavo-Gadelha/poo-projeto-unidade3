package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.VendedorDAO;
import com.fesfafic.Model.Vendedor;

import java.util.ArrayList;
import java.util.UUID;

public class VendedorController implements IController<Vendedor> {
    private VendedorDAO dao;

    public VendedorController() {
        this.dao = new VendedorDAO();
    }

    @Override
    public Vendedor get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Vendedor> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Vendedor vendedor) {
        return dao.adicionar(vendedor);
    }

    @Override
    public boolean remover(Vendedor vendedor) {
        return dao.remover(vendedor);
    }
}
