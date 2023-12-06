package com.fesfafic.Util;

import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Exception.CadastroException;
import com.fesfafic.Model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class AcessoUtil {
    private static final Scanner lineScanner = new Scanner(System.in);

    public static Cliente pedirLogin(ArrayList<Cliente> clientes) throws AtributoVazioException {
        System.out.println("\n========== Realizar login ==========\n");

        System.out.print("Digite seu email: ");
        String email = lineScanner.nextLine().strip();
        System.out.print("Digite sua senha: ");
        String senha = lineScanner.nextLine().strip();

        // Checa se o e-mail ou a senha estão em branco
        // Caso verdadeiro, levanta um erro
        if (email.isBlank()) {
            throw new AtributoVazioException("E-mail está em branco");
        } else if (senha.isBlank()) {
            throw new AtributoVazioException("Senha está em branco");
        }

        for (Cliente cliente : clientes) {
            if (cliente.fazerLogin(email, senha)) {
                System.out.println("Login realizado com sucesso!");
                return cliente;
            }
        }

        System.out.println("Email ou senha não encontrados");
        return null;
    }

    public static Cliente pedirCadastro(ArrayList<Cliente> clientes) throws CadastroException, AtributoVazioException {
        System.out.println("\n========== Realizar Cadastro ==========\n");

        System.out.print("Digite seu e-mail: ");
        String email = lineScanner.nextLine().strip();
        System.out.print("Digite sua senha: ");
        String senha = lineScanner.nextLine().strip();

        // Checa se o e-mail ou a senha estão em branco
        // Caso verdadeiro, levanta um erro
        if (email.isBlank()) {
            throw new AtributoVazioException("E-mail não pode está em branco");
        } else if (senha.isBlank()) {
            throw new AtributoVazioException("Senha não pode está em branco");
        } else if (email.equalsIgnoreCase(senha)) {
            throw new CadastroException("E-mail e Senha não podem ser iguais");
        }

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                throw new CadastroException("E-mail já cadastrado");
            }
        }
        return new Cliente(email, senha);
    }
}
