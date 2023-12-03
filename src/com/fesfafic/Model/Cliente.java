package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Exception.ProdutoException;

public class Cliente extends Utilizador implements ICliente {
    private double saldo;

    public Cliente(String email, String senha) {
        super(email, senha);
        this.saldo = 0;
    }

    @Override
    public boolean comprarProduto(IProduto produto) {
        if (this.transferirPara(produto.getVendedor(), produto.getValor())) {
            produto.setQuantidade(produto.getQuantidade() - 1);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean comprarProduto(IProduto produto, int quantidade) {
        if (quantidade > produto.getQuantidade()) {
            throw new ProdutoException("Quantidade de compra maior que quantidade do produto em estoque");
        }

        if (this.transferirPara(produto.getVendedor(), produto.getValor())) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            produto.getVendedor();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void depositar(double valor) {
        this.saldo += valor;
    }

    @Override
    public boolean transferirPara(ICliente utilizador, double valor) {
        if (this.sacar(valor)) {
            utilizador.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double getSaldo() {
        return saldo;
    }
}
