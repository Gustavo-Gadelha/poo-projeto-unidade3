package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Exception.AvaliacaoException;
import com.fesfafic.Model.Avaliacao;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProdutoUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int pedirIndice(int limite) throws IndexOutOfBoundsException, InputMismatchException {
        System.out.print("Digite o índice do produto: ");
        int indice = scanner.nextInt();

        if (indice < 0) {
            throw new IndexOutOfBoundsException("Índice deve ser maior ou igual a 0");
        } else if (indice >= limite) {
            throw new IndexOutOfBoundsException("Índice maior do que possível");
        }

        return indice;
    }

    public static Avaliacao pedirAvaliacao(ICliente cliente, IProduto produto) throws AvaliacaoException {
        System.out.print("Digite o conteúdo da sua avaliação: ");
        String conteudo = scanner.nextLine();

        // remove qualquer espaço em branco e checa se o conteúdo da avaliação é vazio
        if (conteudo.strip().isBlank()) {
            throw new AvaliacaoException("O conteúdo da avaliação não pode estar em branco");
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
