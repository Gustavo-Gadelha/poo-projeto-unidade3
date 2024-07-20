package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Exception.ProdutoException;
import com.fesfafic.Model.Produto;

import java.util.Scanner;

public class VendedorUtil {
    public static Produto publicarProduto(Scanner lineScanner, ICliente cliente) throws ProdutoException, AtributoVazioException, NumberFormatException {
        System.out.println("\n========== Publicar Produto ==========\n");

        String nome = ProdutoUtil.pedirNome(lineScanner);
        double valor = ProdutoUtil.pedirValor(lineScanner);
        int quantidade = ProdutoUtil.pedirQuantidade(lineScanner);

        return new Produto(cliente, nome, valor, quantidade);
    }

    public static void atualizarProduto(Scanner lineScanner, Produto produto) throws ProdutoException, AtributoVazioException, NumberFormatException {
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

        // Como o método requer uma referência ao objeto, não é necessário um método "atualizar" dentro do DAO
        switch (escolha) {
            // 1. Atualizar Nome
            case "1": {
                String nome = ProdutoUtil.pedirNome(lineScanner);
                produto.setNome(nome);
                break;
            }

            // 2. Atualizar Valor
            case "2": {
                double valor = ProdutoUtil.pedirValor(lineScanner);
                produto.setValor(valor);
                break;
            }

            // 3. Atualizar Quantidade
            case "3": {
                int quantidade = ProdutoUtil.pedirQuantidade(lineScanner);
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
