package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.ReciboDAO;
import com.fesfafic.Model.Recibo;

import java.util.ArrayList;
import java.util.UUID;

public class ReciboController implements IController<Recibo> {
    private ReciboDAO dao;

    public ReciboController() {
        this.dao = new ReciboDAO();
    }

    @Override
    public Recibo get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Recibo> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Recibo recibo) {
        return dao.adicionar(recibo);
    }

    @Override
    public boolean remover(Recibo recibo) {
        return dao.remover(recibo);
    }
}
