package com.fesfafic.Util;

import com.fesfafic.Model.Produto;

import java.util.ArrayList;

public class CarrinhoUtil {

    public static void exibirProdutos(ArrayList<Produto> produtos, boolean mostrarCarrinho) {
        // Se mostrarCarrinho for falso, retorne
        if (!mostrarCarrinho) {
            return;
        }

        System.out.println("\n========== Lista de produtos do carrinho ==========\n");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto no carrinho");
        } else {
            int contador = 0;
            System.out.printf("%3s - %20s - %8s - %3s\n","IND", "Produto", "Valor", "QTD");
            for (Produto produto : produtos) {
                System.out.printf("%03d | %20s | R$%6f | %03d\n",
                        contador,
                        produto.getNome(),
                        produto.getValor(),
                        produto.getQuantidade()
                );
                contador++;
            }
        }
    }
}
