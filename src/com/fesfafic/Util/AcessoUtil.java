package com.fesfafic.Util;

import com.fesfafic.Exception.CadastroException;
import com.fesfafic.Exception.LoginException;
import com.fesfafic.Model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class AcessoUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static Cliente pedirLogin(ArrayList<Cliente> clientes) throws LoginException {
        System.out.println("\n========== Realizar login ==========\n");

        System.out.print("Digite seu email: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Retira os espaços em branco e checa se o e-mail ou a senha estão em branco
        // Caso verdadeiro, levanta um erro
        if (email.strip().isBlank()) {
            throw new LoginException("E-mail está em branco");
        } else if (senha.strip().isBlank()) {
            throw new LoginException("Senha está em branco");
        }

        for (Cliente cliente : clientes) {
            if (cliente.fazerLogin(email, senha)) {
                return cliente;
            }
        }
        return null;
    }

    public static Cliente pedirCadastro(ArrayList<Cliente> clientes) throws CadastroException {
        System.out.println("\n========== Realizar Cadastro ==========\n");

        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = scanner.nextLine();

        // Retira os espaços em branco e checa se o e-mail ou a senha estão em branco
        // Caso verdadeiro, levanta um erro
        if (email.strip().isBlank()) {
            throw new CadastroException("E-mail não pode está em branco");
        } else if (senha.strip().isBlank()) {
            throw new CadastroException("Senha não pode está em branco");
        }

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                throw new CadastroException("E-mail já cadastrado");
            }
        }
        return new Cliente(email, senha);
    }
}
