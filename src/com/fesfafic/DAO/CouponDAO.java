package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Coupon;

import java.util.ArrayList;
import java.util.UUID;

public class CouponDAO implements IDao<Coupon> {
    private ArrayList<Coupon> coupons;

    public CouponDAO() {
        this.coupons = new ArrayList<>();
    }

    @Override
    public Coupon get(UUID id) {
        for (Coupon coupon : coupons) {
            if (coupon.getId() == id) {
                return coupon;
            }
        }
        return null;
    }

    public Coupon get(String codigo) {
        for (Coupon coupon : coupons) {
            if (coupon.getCodigo().equalsIgnoreCase(codigo)) {
                return coupon;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Coupon> listarTodos() {
        return new ArrayList<>(coupons);
    }

    @Override
    public boolean adicionar(Coupon coupon) {
        return coupons.add(coupon);
    }

    @Override
    public boolean remover(Coupon coupon) {
        return coupons.remove(coupon);
    }
}
