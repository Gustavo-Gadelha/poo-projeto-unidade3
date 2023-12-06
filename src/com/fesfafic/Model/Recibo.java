package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.ICoupon;
import com.fesfafic.Contract.IPedido;
import com.fesfafic.Contract.IRecibo;

import java.util.ArrayList;
import java.util.UUID;

public class Recibo implements IRecibo {
    private UUID id;
    private ICliente recipiente;
    private ArrayList<IPedido> pedidos;
    private ArrayList<ICoupon> coupons;
    private double valor;

    public Recibo(ICliente recipiente, ArrayList<IPedido> pedidos, ArrayList<ICoupon> coupons, double valor) {
        this.id = UUID.randomUUID();
        this.recipiente = recipiente;
        this.pedidos = pedidos;
        this.coupons = coupons;
        this.valor = valor;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public ICliente getRecipiente() {
        return recipiente;
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
