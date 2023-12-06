package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Recibo;

import java.util.ArrayList;
import java.util.UUID;

public class ReciboDAO implements IDao<Recibo> {
    private ArrayList<Recibo> recibos;

    public ReciboDAO() {
        this.recibos = new ArrayList<>();
    }

    @Override
    public Recibo get(UUID id) {
        for (Recibo recibo : recibos) {
            if (recibo.getId() == id) {
                return recibo;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Recibo> listarTodos() {
        return new ArrayList<>(recibos);
    }

    @Override
    public boolean adicionar(Recibo recibo) {
        return recibos.add(recibo);
    }

    @Override
    public boolean remover(Recibo recibo) {
        return recibos.remove(recibo);
    }
}
