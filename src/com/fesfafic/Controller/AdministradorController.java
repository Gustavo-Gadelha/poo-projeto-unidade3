package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.AdministradorDAO;
import com.fesfafic.Model.Administrador;

import java.util.ArrayList;
import java.util.UUID;

public class AdministradorController implements IController<Administrador> {
    private AdministradorDAO dao;

    public AdministradorController() {
        this.dao = new AdministradorDAO();
    }

    @Override
    public Administrador get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Administrador administrador) {
        return dao.adicionar(administrador);
    }

    @Override
    public boolean remover(Administrador administrador) {
        return dao.remover(administrador);
    }
}
