package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Exception.VendedorException;
import com.fesfafic.Model.Avaliacao;

import java.util.ArrayList;
import java.util.Scanner;

public class AvaliacaoUtil {
    public static Avaliacao pedirAvaliacao(Scanner lineScanner, ICliente cliente, IProduto produto) throws VendedorException, AtributoVazioException {
        if (produto.getVendedor() == cliente) {
            throw new VendedorException("Vendedores não podem avaliar seus próprios produtos");
        }

        System.out.print("Digite o conteúdo da sua avaliação: ");
        String conteudo = lineScanner.nextLine().strip();

        // checa se o conteúdo da avaliação é vazio
        if (conteudo.isBlank()) {
            throw new AtributoVazioException("O conteúdo da avaliação não pode estar em branco");
        }

        return new Avaliacao(cliente, produto, conteudo);
    }

    public static void exibirAvaliacoes(ArrayList<Avaliacao> avaliacoes) {
        System.out.println("\n========== Lista de Avaliações ==========\n");
        if (avaliacoes.isEmpty()) {
            System.out.println("Nenhuma avaliação registrada para este produto");
        } else {
            for (Avaliacao avaliacao : avaliacoes) {
                System.out.println("Autor: " + avaliacao.getCliente().getEmail());
                System.out.println("\"" + avaliacao.getConteudo() + "\"\n");
                // Resultado:
                // Autor: (Email do autor)
                // "(conteúdo da avaliação)"(quebra de linha)
            }
        }
    }
}
