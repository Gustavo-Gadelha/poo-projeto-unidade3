package com.fesfafic.Model;

import com.fesfafic.Contract.ICoupon;

public class Coupon implements ICoupon {
    private String codigo;
    private int desconto;

    public Coupon(String codigo, int desconto) {
        this.codigo = codigo;
        this.desconto = desconto;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public int getDesconto() {
        return desconto;
    }
}
