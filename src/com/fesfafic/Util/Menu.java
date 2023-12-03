package com.fesfafic.Util;

import com.fesfafic.Contract.IMenu;
import com.fesfafic.Controller.*;
import com.fesfafic.Model.Cliente;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements IMenu {
    private static ClienteController clienteController;
    private static AdministradorController administradorController;
    private static ProdutoController produtoController;
    private static CouponsController couponsController;
    private static PedidoController pedidoController;
    private static CarrinhoController carrinhoController;

    private static Scanner lineScanner;

    private static Scanner numberScanner;

    public Menu() {
        clienteController = new ClienteController();
        administradorController = new AdministradorController();
        produtoController = new ProdutoController();
        couponsController = new CouponsController();
        pedidoController = new PedidoController();
        carrinhoController = new CarrinhoController();
        lineScanner = new Scanner(System.in);
        numberScanner = new Scanner(System.in);
    }

    @Override
    public void menuInicial() {
        String escolha;
        do {
            System.out.println(
                    """
                    ================ Dadá Tec-Shop ================
                    0. Sair
                    1. Fazer Cadastro
                    2. Acessar como Cliente
                    3. Acessar como Vendedor
                    4. Acessar como Administrador
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine();

            switch (escolha) {
                case "0": {
                    System.out.println("Adeus, volte novamente");
                    break;
                }

                case "1": {
                    menuCadastro();
                    break;
                }

                case "2": {
                    Cliente login = menuLogin();
                    if (login != null) {
                        menuCliente(login);
                    } else {
                        System.out.println("Email ou senha não encontrados");
                    }
                    break;
                }

                case "3": {
                    Cliente login = menuLogin();
                    if (login != null) {
                        menuVendedor(login);
                    } else {
                        System.out.println("Email ou senha não encontrados");
                    }
                    break;
                }

                case "4": {
                    menuAdministrador();
                    break;
                }

                default: {
                    System.out.println("Entrada inválida! Digite novamente");
                    break;
                }
            }
        } while (!escolha.equals("0"));
    }

    @Override
    public void menuCadastro() {
        System.out.println("\n ===== Realizar Cadastro ===== \n");

        System.out.print("Digite seu email: ");
        String email = lineScanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = lineScanner.nextLine();

        if (clienteController.adicionar(new Cliente(email, senha))) {
            System.out.println("Cadastro realizado com sucesso!\n");
        } else {
            System.out.println("Falha no Cadastro!\n");
        }
    }

    public Cliente menuLogin() {
        System.out.println("\n ===== Acessar como cliente ===== \n");

        System.out.print("Digite seu email: ");
        String email = lineScanner.nextLine();
        System.out.print("Digite sua senha: ");
        String senha = lineScanner.nextLine();

        for (Cliente cliente : clienteController.listarTodos()) {
            if (cliente.fazerLogin(email, senha)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public void menuCliente(Cliente cliente) {
        String escolha;
        do {
            System.out.println(
                    """
                    ================ Dadá Tec-Shop ================
                    0. Sair
                    1. Ver Produtos
                    2. Avaliar Produto
                    3. Ver Carrinho
                    4. Finalizar Pedido
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine();

            switch (escolha) {
                case "0": {
                    break;
                }
                case "1": {
                    ArrayList<Produto> produtos = produtoController.listarTodos();
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto registrado");
                    } else {
                        int contador = 1;
                        System.out.printf("%3s - %20s - %8s - %3s\n","IND", "Produto", "Valor", "QTD");
                        for (Produto produto : produtos) {
                            System.out.printf("%03d - %20s - R$%6f - %03d\n",
                                    contador,
                                    produto.getNome(),
                                    produto.getValor(),
                                    produto.getQuantidade()
                            );
                            contador++;
                        }
                    }
                    break;
                }

                case "2": {

                    break;
                }

                case "3": {

                    break;
                }

                case "4": {

                    break;
                }

                default: {
                    System.out.println("Entrada inválida! Digite novamente");
                    break;
                }
            }
        } while (!escolha.equals("0"));
    }

    @Override
    public void menuVendedor(Cliente cliente) {
        String escolha;
        do {
            System.out.println(
                    """
                    ================ Dadá Tec-Shop ================
                    0. Sair
                    1. Ver Produtos deste Cliente
                    2. Publicar Produto
                    3. Remover Produto
                    4. Atualizar Produto
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine();

            switch (escolha) {
                case "0": {
                    break;
                }
                case "1": {

                    break;
                }

                case "2": {

                    break;
                }

                case "3": {

                    break;
                }

                case "4": {

                    break;
                }

                default: {
                    System.out.println("Entrada inválida! Digite novamente");
                    break;
                }
            }
        } while (!escolha.equals("0"));
    }

    @Override
    public void menuAdministrador() {
    }

    @Override
    public void menuPedido() {

    }
}
