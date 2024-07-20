package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Exception.PedidoException;
import com.fesfafic.Exception.ProdutoException;
import com.fesfafic.Exception.VendedorException;
import com.fesfafic.Model.Coupon;
import com.fesfafic.Model.Pedido;

import java.util.ArrayList;
import java.util.Scanner;

public class PedidoUtil {
    public static Pedido fazerPedido(Scanner lineScanner, ICliente cliente, IProduto produto) throws VendedorException, PedidoException, ProdutoException, NumberFormatException {
        if (produto.getVendedor() == cliente) {
            throw new VendedorException("Vendedores não podem avaliar seus próprios produtos");
        }

        // Quantidade do pedido deve ser menor ou igual à quantidade do produto
        int quantidade = ProdutoUtil.pedirQuantidade(lineScanner);

        if (quantidade > produto.getQuantidade()) {
            throw new PedidoException("Quantidade do pedido deve ser menor ou igual a quantidade do produto");
        }

        return new Pedido(cliente, produto, quantidade);
    }

    public static void exibirPedidos(ArrayList<Pedido> pedidos, boolean mostrarCarrinho) {
        // Se mostrarCarrinho for falso, retorne sem exibir
        if (!mostrarCarrinho) {
            return;
        }

        System.out.println("\n========== Lista de pedidos ==========\n");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido registrado");
        } else {
            double total = 0;
            System.out.printf("%3s | %-20s | %10s | %3s\n","IND", "Produto", "Valor", "QTD Reservada");
            for (com.fesfafic.Contract.IPedido pedido : pedidos) {
                System.out.printf("%03d | %-20s | R$%8.2f | %03d\n",
                        pedidos.indexOf(pedido),
                        pedido.getProduto().getNome(),
                        pedido.getProduto().getValor(),
                        pedido.getQuantidade()
                );
                // Soma o valor de Cada pedido
                total += pedido.calcularValor();
            }
            System.out.printf("\nTotal: R$%.2f\n", total);
        }
    }

    public static double calcularTotal(ArrayList<Pedido> pedidos) {
        double total = 0;
        for (Pedido pedido : pedidos) {
            total += pedido.calcularValor();
        }
        return total;
    }

    public static double calcularDesconto(ArrayList<Coupon> coupons) {
        double desconto = 1;
        for (Coupon coupon : coupons) {
            desconto -= coupon.getDesconto();
            if (desconto < 0) {
                desconto = 0;
                break;
            }
        }
        return desconto;
    }
}
