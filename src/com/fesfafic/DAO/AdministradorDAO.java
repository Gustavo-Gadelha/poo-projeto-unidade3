package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Administrador;

import java.util.ArrayList;
import java.util.UUID;

public class AdministradorDAO implements IDao<Administrador> {
    private ArrayList<Administrador> administradores;

    public AdministradorDAO() {
        this.administradores = new ArrayList<>();
    }

    @Override
    public Administrador get(UUID id) {
        for (Administrador administrador : administradores) {
            if (administrador.getId() == id) {
                return administrador;
            }
        }
        return null;
    }

    public Administrador get(String codigoDeAcesso) {
        for (Administrador administrador : administradores) {
            if (administrador.getCodigoDeAcesso().equalsIgnoreCase(codigoDeAcesso)) {
                return administrador;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Administrador> listarTodos() {
        return new ArrayList<>(administradores);
    }

    @Override
    public boolean adicionar(Administrador administrador) {
        return administradores.add(administrador);
    }

    @Override
    public boolean remover(Administrador administrador) {
        return administradores.remove(administrador);
    }
}
