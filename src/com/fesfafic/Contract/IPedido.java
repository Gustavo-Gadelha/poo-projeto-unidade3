package com.fesfafic.Contract;

import java.util.ArrayList;
import java.util.UUID;

public interface IPedido {

    double calcularValor();

    boolean adicionarCoupon(ICoupon coupon);

    UUID getId();

    ICliente getRecipiente();

    ArrayList<IProduto> getProdutos();

    ArrayList<ICoupon> getCoupons();

    double getValor();
}
