package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IRecibo;

import java.util.ArrayList;
import java.util.UUID;

public class Recibo implements IRecibo {
    private UUID id;
    private ICliente cliente;
    private ArrayList<Pedido> pedidos;
    private ArrayList<Coupon> coupons;
    private boolean emAberto;

    public Recibo(ICliente cliente) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.pedidos = new ArrayList<>();
        this.coupons = new ArrayList<>();
        this.emAberto = true;
    }

    @Override
    public boolean adicionarPedidos(ArrayList<Pedido> pedidos) {
        return this.pedidos.addAll(pedidos);
    }

    @Override
    public boolean adicionarCoupon(Coupon coupon) {
        return this.coupons.add(coupon);
    }

    @Override
    public boolean removerCoupon(Coupon coupon) {
        return this.coupons.remove(coupon);
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public ICliente getCliente() {
        return cliente;
    }

    @Override
    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    @Override
    public ArrayList<Coupon> getCoupons() {
        return coupons;
    }

    @Override
    public boolean isEmAberto() {
        return emAberto;
    }

    @Override
    public void setEmAberto(boolean emAberto) {
        this.emAberto = emAberto;
    }
}
