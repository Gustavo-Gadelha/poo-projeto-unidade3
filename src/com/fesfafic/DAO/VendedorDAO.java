package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Vendedor;

import java.util.ArrayList;
import java.util.UUID;

public class VendedorDAO implements IDao<Vendedor> {
    private ArrayList<Vendedor> vendedores;

    public VendedorDAO() {
        this.vendedores = new ArrayList<>();
    }

    @Override
    public Vendedor get(UUID id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Vendedor> listarTodos() {
        return new ArrayList<>(vendedores);
    }

    @Override
    public boolean adicionar(Vendedor vendedor) {
        return vendedores.add(vendedor);
    }

    @Override
    public boolean remover(Vendedor vendedor) {
        return vendedores.remove(vendedor);
    }
}
