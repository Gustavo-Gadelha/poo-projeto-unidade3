package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Contract.IUtilizador;

public class Cliente extends Utilizador implements ICliente {
    public Cliente(String email, String senha, double saldo) {
        super(email, senha, saldo);
    }

    @Override
    public Avaliacao deixarAvaliacao(String avaliacao, int nota) {
        return new Avaliacao(this, avaliacao, nota);
    }

    public boolean comprarProduto(IProduto produto) {
        if (this.transferePara((IUtilizador) produto.getVendedor(), produto.getValor())) {
            produto.setQuantidade(produto.getQuantidade() - 1);
            return true;
        } else {
            return false;
        }
    }

    public boolean comprarProduto(IProduto produto, int quantidade) {
        if (this.sacar(produto.getValor()) && produto.getQuantidade() <= quantidade) {
            produto.setQuantidade(produto.getQuantidade() - quantidade);
            produto.getVendedor();
            return true;
        } else {
            return false;
        }
    }
}
