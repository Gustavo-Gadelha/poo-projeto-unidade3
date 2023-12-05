package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Exception.ProdutoException;
import com.fesfafic.Model.Produto;

import java.util.Scanner;

public class VendedorUtil {
    private static final Scanner lineScanner = new Scanner(System.in);

    public static Produto publicarProduto(ICliente cliente) throws ProdutoException, AtributoVazioException, NumberFormatException {
        System.out.println("\n========== Publicar Produto ==========\n");

        // Nome do produto, não pode estar em branco
        System.out.print("Digite o nome do produto: ");
        String nome = lineScanner.nextLine().strip();
        if (nome.isBlank()) {
            throw new AtributoVazioException("Nome do produto não pode estar em branco");
        }

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

        return new Produto(cliente, nome, valor, quantidade);
    }

    public static void atualizarProduto(Produto produto) throws ProdutoException, AtributoVazioException, NumberFormatException {
        String escolha;
        System.out.println(
                """
                
                ========== Atualizar Produto ==========
                
                1. Atualizar Nome
                2. Atualizar Valor
                3. Atualizar Quantidade
                """
        );

        System.out.print("Digite sua escolha: ");
        escolha = lineScanner.nextLine();

        switch (escolha) {
            // 1. Atualizar Nome
            case "1": {
                // Nome do produto, não pode estar em branco
                System.out.print("Digite o nome do produto: ");
                String nome = lineScanner.nextLine().strip();
                if (nome.isBlank()) {
                    throw new AtributoVazioException("Nome do produto não pode estar em branco");
                }

                produto.setNome(nome);
                break;
            }

            // 2. Atualizar Valor
            case "2": {
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

                produto.setValor(valor);
                break;
            }

            // 3. Atualizar Quantidade
            case "3": {
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

                produto.setQuantidade(quantidade);
                break;
            }

            default: {
                System.out.println("Entrada Invalida!");
                break;
            }
        }
    }
}
