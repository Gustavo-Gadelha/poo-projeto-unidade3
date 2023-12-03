package com.fesfafic.Model;

import com.fesfafic.Contract.ICoupon;

import java.util.UUID;

public class Coupon implements ICoupon {
    private UUID id;
    private String codigo;
    private int desconto;

    public Coupon(String codigo, int desconto) {
        this.id = UUID.randomUUID();
        this.codigo = codigo;
        this.desconto = desconto;
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public String getCodigo() {
        return this.codigo;
    }

    @Override
    public int getDesconto() {
        return this.desconto;
    }
}
