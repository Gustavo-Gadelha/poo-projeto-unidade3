package com.fesfafic.Controller;

import com.fesfafic.Contract.IController;
import com.fesfafic.DAO.CouponDAO;
import com.fesfafic.Model.Coupon;

import java.util.ArrayList;
import java.util.UUID;

public class CouponController implements IController<Coupon> {
    private final CouponDAO dao;

    public CouponController() {
        this.dao = new CouponDAO();
    }

    @Override
    public Coupon get(UUID id) {
        return dao.get(id);
    }

    public Coupon get(String codigo) {
        return dao.get(codigo);
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
