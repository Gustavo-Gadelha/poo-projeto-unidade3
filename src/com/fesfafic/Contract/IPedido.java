package com.fesfafic.Contract;

import com.fesfafic.Model.Coupon;

public interface IPedido {
    double calcularValor();

    boolean adicionarCoupon(ICoupon coupon);
}
