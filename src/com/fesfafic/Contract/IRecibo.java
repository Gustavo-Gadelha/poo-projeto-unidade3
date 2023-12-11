package com.fesfafic.Contract;

import com.fesfafic.Model.Coupon;
import com.fesfafic.Model.Pedido;

import java.util.ArrayList;
import java.util.UUID;

public interface IRecibo {

    boolean adicionarPedidos(ArrayList<Pedido> pedidos);

    boolean adicionarCoupon(Coupon coupon);

    boolean removerCoupon(Coupon coupon);

    UUID getId();

    ICliente getCliente();

    ArrayList<Pedido> getPedidos();

    ArrayList<Coupon> getCoupons();

    boolean isEmAberto();

    void setEmAberto(boolean emAberto);
}
