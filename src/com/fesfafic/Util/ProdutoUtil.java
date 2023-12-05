package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Model.Avaliacao;
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

    public static Avaliacao pedirAvaliacao(ICliente cliente, IProduto produto) throws AtributoVazioException {
        System.out.print("Digite o conteúdo da sua avaliação: ");
        String conteudo = lineScanner.nextLine().strip();

        // checa se o conteúdo da avaliação é vazio
        if (conteudo.isBlank()) {
            throw new AtributoVazioException("O conteúdo da avaliação não pode estar em branco");
        }

        return new Avaliacao(cliente, produto, conteudo);
    }

    public static void exibirProdutos(ArrayList<Produto> produtos, boolean mostrarProdutos) {
        // Se mostrarProdutos for falso, retorne
        if (!mostrarProdutos) {
            return;
        }

        System.out.println("\n========== Lista de produtos ==========\n");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado");
        } else {
            int contador = 0;
            System.out.printf("%3s | %-20s | %10s | %3s\n","IND", "Produto", "Valor", "QTD");
            for (Produto produto : produtos) {
                System.out.printf("%03d | %-20s | R$%8.2f | %03d\n",
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
