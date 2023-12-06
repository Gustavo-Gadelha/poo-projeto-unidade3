package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.ICoupon;
import com.fesfafic.Contract.IPedido;
import com.fesfafic.Contract.IRecibo;

import java.util.ArrayList;
import java.util.UUID;

public class Recibo implements IRecibo {
    private UUID id;
    private ICliente cliente;
    private ArrayList<IPedido> pedidos;
    private ArrayList<ICoupon> coupons;
    private double valor;

    public Recibo(ICliente cliente, ArrayList<IPedido> pedidos, ArrayList<ICoupon> coupons, double valor) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.pedidos = pedidos;
        this.coupons = coupons;
        this.valor = valor;
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
    public ArrayList<IPedido> getPedidos() {
        return this.pedidos;
    }

    @Override
    public ArrayList<ICoupon> getCoupons() {
        return coupons;
    }

    @Override
    public double getValor() {
        return valor;
    }
}
