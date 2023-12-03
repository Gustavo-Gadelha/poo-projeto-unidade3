package com.fesfafic.Model;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Exception.ProdutoException;

public class Cliente extends Utilizador implements ICliente {
    public Cliente(String email, String senha, double saldo) {
        super(email, senha, saldo);
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
}
