package com.fesfafic.Util;

import com.fesfafic.Exception.AtributoVazioException;
import com.fesfafic.Exception.CadastroException;
import com.fesfafic.Model.Administrador;
import com.fesfafic.Model.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class AcessoUtil {
    private static final Scanner lineScanner = new Scanner(System.in);

    public static Administrador pedirAdmnistrador(ArrayList<Administrador> administradores) throws AtributoVazioException {
        System.out.println("\n========== Realizar login ==========\n");

        String email = AcessoUtil.pedirEmail();
        String senha = AcessoUtil.pedirSenha();
        String codigoDeAcesso = AcessoUtil.pedirCodigoDeAcesso();

        for (Administrador administrador : administradores) {
            if (administrador.fazerLogin(email, senha, codigoDeAcesso)) {
                System.out.println("Login realizado com sucesso!");
                return administrador;
            }
        }

        System.out.println("Email ou senha não encontrados");
        return null;
    }

    public static Administrador cadastrarAdministrador(ArrayList<Administrador> administradores) throws AtributoVazioException, CadastroException {
        System.out.println("\n========== Criar Administrador ==========\n");

        String email = AcessoUtil.pedirEmail();
        String senha = AcessoUtil.pedirSenha();
        String codigoDeAcesso = AcessoUtil.pedirCodigoDeAcesso();

        // Checa se o e-mail e a senha são iguais, caso verdadeiro levanta um erro
        if (email.equalsIgnoreCase(senha)) {
            throw new CadastroException("E-mail e Senha não podem ser iguais");
        }

        for (Administrador administrador : administradores) {
            if (administrador.getEmail().equalsIgnoreCase(email)) {
                throw new CadastroException("E-mail já cadastrado");
            } else if (administrador.getCodigoDeAcesso().equalsIgnoreCase(codigoDeAcesso)) {
                throw new CadastroException("Código de acesso já cadastrado");
            }
        }

        return new Administrador(email, senha, codigoDeAcesso);
    }

    public static Cliente pedirLogin(ArrayList<Cliente> clientes) throws AtributoVazioException {
        System.out.println("\n========== Realizar login ==========\n");

        String email = AcessoUtil.pedirEmail();
        String senha = AcessoUtil.pedirSenha();

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

        String email = AcessoUtil.pedirEmail();
        String senha = AcessoUtil.pedirSenha();

        // Checa se o e-mail e a senha são iguais, caso verdadeiro levanta um erro
        if (email.equalsIgnoreCase(senha)) {
            throw new CadastroException("E-mail e Senha não podem ser iguais");
        }

        for (Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                throw new CadastroException("E-mail já cadastrado");
            }
        }
        return new Cliente(email, senha);
    }

    public static String pedirEmail() throws AtributoVazioException {
        System.out.print("Digite seu e-mail: ");
        String email = lineScanner.nextLine().strip();

        // Checa se o e-mail está em branco, caso verdadeiro levanta um erro
        if (email.isBlank()) {
            throw new AtributoVazioException("E-mail não pode está em branco");
        }

        return email;
    }

    public static String pedirSenha() throws AtributoVazioException {
        System.out.print("Digite sua senha: ");
        String senha = lineScanner.nextLine().strip();

        // Checa se a senha está em branco, caso verdadeiro levanta um erro
        if (senha.isBlank()) {
            throw new AtributoVazioException("Senha não pode está em branco");
        }

        return senha;
    }

    public static String pedirCodigoDeAcesso() throws AtributoVazioException {
        System.out.print("Digite seu código de acesso: ");
        String codigoDeAcesso = lineScanner.nextLine().strip();

        // Checa se o código de acesso está em branco, caso verdadeiro levanta um erro
        if (codigoDeAcesso.isBlank()) {
            throw new AtributoVazioException("Código de Acesso não pode está em branco");
        }

        return codigoDeAcesso;
    }
}
