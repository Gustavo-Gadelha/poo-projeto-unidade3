package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.CouponsDAO;
import com.fesfafic.Model.Coupon;

import java.util.ArrayList;
import java.util.UUID;

public class CouponsController implements IController<Coupon> {
    private final CouponsDAO dao;

    public CouponsController() {
        this.dao = new CouponsDAO();
    }

    @Override
    public Coupon get(UUID id) {
        return dao.get(id);
    }

    @Override
    public ArrayList<Coupon> listarTodos() {
        return dao.listarTodos();
    }

    @Override
    public boolean adicionar(Coupon coupon) {
        return dao.adicionar(coupon);
    }

    @Override
    public boolean remover(Coupon coupon) {
        return dao.remover(coupon);
    }
}
