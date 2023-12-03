package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Cliente;

import java.util.ArrayList;
import java.util.UUID;

public class ClienteDAO implements IDao<Cliente> {
    private ArrayList<Cliente> clientes;

    public ClienteDAO() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public Cliente get(UUID id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    @Override
    public boolean adicionar(Cliente cliente) {
        return clientes.add(cliente);
    }

    @Override
    public boolean remover(Cliente cliente) {
        return clientes.remove(cliente);
    }
}
