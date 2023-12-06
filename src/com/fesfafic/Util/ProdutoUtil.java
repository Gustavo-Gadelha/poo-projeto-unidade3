package com.fesfafic.Util;

import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Exception.ProdutoException;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoUtil {
    private static final Scanner lineScanner = new Scanner(System.in);

    public static int pedirIndice(int limite) throws IndexOutOfBoundsException, NumberFormatException {
        int indice;
        System.out.print("Digite o índice do produto: ");
        try {
            indice = Integer.parseInt(lineScanner.nextLine());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Valor do índice dever ser um número inteiro");
        }

        if (indice < 0) {
            throw new IndexOutOfBoundsException("Índice deve ser maior ou igual a 0");
        } else if (indice >= limite) {
            throw new IndexOutOfBoundsException("Índice maior do que possível");
        }

        return indice;
    }

    public static String pedirNome() throws AtributoVazioException {
        // Nome do produto, não pode estar em branco
        System.out.print("Digite o nome do produto: ");
        String nome = lineScanner.nextLine().strip();
        if (nome.isBlank()) {
            throw new AtributoVazioException("Nome do produto não pode estar em branco");
        }
        return nome;
    }

    public static double pedirValor() throws ProdutoException, NumberFormatException {
        // Valor do produto, deve ser um número decimal e maior que zero
        System.out.print("Digite o valor do produto: ");
        double valor;
        try {
            valor = Double.parseDouble(lineScanner.nextLine());
            if (valor <= 0) {
                throw new ProdutoException("Valor do produto deve ser maior que zero");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Valor do produto deve ser ser um número decimal");
        }
        return valor;
    }

    public static int pedirQuantidade() throws ProdutoException, NumberFormatException {
        // Quantidade do produto, deve ser um número inteiro e maior que zero
        System.out.print("Digite a quantidade do produto: ");
        int quantidade;
        try {
            quantidade = Integer.parseInt(lineScanner.nextLine());
            if (quantidade <= 0) {
                throw new ProdutoException("Quantidade do produto deve ser maior que zero");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Quantidade do produto deve ser um número inteiro");
        }
        return quantidade;
    }

    public static void exibirProdutos(ArrayList<Produto> produtos, boolean mostrarProdutos) {
        // Se mostrarProdutos for falso, retorne sem exibir
        if (!mostrarProdutos) {
            return;
        }

        System.out.println("\n========== Lista de produtos ==========\n");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado");
        } else {
            System.out.printf("%3s | %-20s | %10s | %3s\n","IND", "Produto", "Valor", "QTD");
            for (Produto produto : produtos) {
                System.out.printf("%03d | %-20s | R$%8.2f | %03d\n",
                        produtos.indexOf(produto),
                        produto.getNome(),
                        produto.getValor(),
                        produto.getQuantidade()
                );
            }
        }
    }
}
