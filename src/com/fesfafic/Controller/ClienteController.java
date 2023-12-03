package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.ClienteDAO;
import com.fesfafic.Model.Cliente;

import java.util.ArrayList;
import java.util.UUID;

public class ClienteController implements IController<Cliente> {
    private ClienteDAO dao;

    public ClienteController() {
        this.dao = new ClienteDAO();
    }

    @Override
    public Cliente get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Cliente cliente) {
        return dao.adicionar(cliente);
    }

    @Override
    public boolean remover(Cliente cliente) {
        return dao.remover(cliente);
    }
}
