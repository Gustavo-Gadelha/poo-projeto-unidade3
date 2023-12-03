package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.ICoupon;
import com.fesfafic.Contract.IPedido;
import com.fesfafic.Contract.IProduto;

import java.util.ArrayList;
import java.util.UUID;

public class Pedido implements IPedido {
    private UUID id;
    private ICliente recipiente;
    private ArrayList<IProduto> produtos;
    private ArrayList<ICoupon> coupons;
    private double valor;

    public Pedido(ICliente recipiente, ArrayList<IProduto> produtos) {
        this.id = UUID.randomUUID();
        this.recipiente = recipiente;
        this.produtos = produtos;
        this.coupons = new ArrayList<>();
        this.valor = calcularValor();
    }

    @Override
    public double calcularValor() {
        double valor = 0;
        for (IProduto produto : this.produtos) {
            valor += produto.getValor();
        }

        double desconto = 1;
        for (ICoupon coupon : this.coupons) {
            desconto -= coupon.getDesconto();
        }

        return valor*desconto;
    }

    @Override
    public boolean adicionarCoupon(ICoupon coupon) {
        return this.coupons.add(coupon);
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
    public ArrayList<IProduto> getProdutos() {
        return produtos;
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
