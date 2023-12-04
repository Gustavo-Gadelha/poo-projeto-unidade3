package com.fesfafic.Util;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IMenu;
import com.fesfafic.Controller.*;
import com.fesfafic.Exception.AvaliacaoException;
import com.fesfafic.Exception.CadastroException;
import com.fesfafic.Exception.LoginException;
import com.fesfafic.Model.Avaliacao;
import com.fesfafic.Model.Carrinho;
import com.fesfafic.Model.Cliente;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu implements IMenu {
    private static ClienteController clienteController;
    private static AdministradorController administradorController;
    private static ProdutoController produtoController;
    private static CouponsController couponsController;
    private static PedidoController pedidoController;
    private static CarrinhoController carrinhoController;
    private static AvaliacaoController avaliacaoController;
    private final static Scanner lineScanner = new Scanner(System.in);
    private final static Scanner numberScanner = new Scanner(System.in);

    public Menu() {
        clienteController = new ClienteController();
        administradorController = new AdministradorController();
        produtoController = new ProdutoController();
        couponsController = new CouponsController();
        pedidoController = new PedidoController();
        carrinhoController = new CarrinhoController();
        avaliacaoController = new AvaliacaoController();
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
                    2. Acessar Menu do Cliente
                    3. Acessar Menu do Vendedor
                    4. Acessar como Administrador
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    System.out.println("Adeus, volte novamente");
                    break;
                }

                // 1. Fazer Cadastro
                case "1": {
                    try {
                        Cliente cliente = AcessoUtil.pedirCadastro(clienteController.listarTodos());
                        if (clienteController.adicionar(cliente)) {
                            System.out.println("Cadastro realizado com sucesso!");
                        } else {
                            System.out.println("Falha no Cadastro!");
                        }
                    } catch (CadastroException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 2. Acessar Menu do Cliente
                case "2": {
                    try {
                        Cliente cliente = AcessoUtil.pedirLogin(clienteController.listarTodos());
                        if (cliente != null) {
                            menuCliente(cliente);
                        } else {
                            System.out.println("Email ou senha não encontrados");
                        }
                    } catch (LoginException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Acessar Menu do Vendedor
                case "3": {
                    try {
                        Cliente cliente = AcessoUtil.pedirLogin(clienteController.listarTodos());
                        if (cliente != null) {
                            menuVendedor(cliente);
                        } else {
                            System.out.println("Email ou senha não encontrados");
                        }
                    } catch (LoginException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 4. Acessar como Administrador
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
    public void menuAdministrador() {
    }

    @Override
    public void menuCliente(ICliente cliente) {
        String escolha;
        boolean mostrarProdutos = false;
        do {
            // Lista de produtos
            ArrayList<Produto> produtos = produtoController.listarTodos();

            // Busca carrinho de compras do Cliente
            // Caso não exista, um novo carrinho é criado
            Carrinho carrinho = carrinhoController.get(cliente);
            if (carrinho == null) {
                carrinho = new Carrinho(cliente);
                carrinhoController.adicionar(carrinho);
            }

            // Logica para mostrar lista de produtos
            // Só é exibida se: a lista nãp estiver vazia E mostrarProdutos for verdadeiro
            // Caso a lista esteja vazia, não é exibida independente do valor de mostrarProdutos
            ProdutoUtil.exibirProdutos(produtos, mostrarProdutos);

            // Menu do Cliente
            System.out.println(
                    """
                    
                    ================ Menu do Cliente ================
                    
                    0. Sair
                    1. Mostrar/Ocultar Produtos
                    2. Adicionar Produto ao carrinho
                    3. Avaliar Produto
                    4. Ver Carrinho
                    5. Verificar Pedido
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    break;
                }

                // 1. Mostrar/Ocultar Produtos
                case "1": {
                    // Novo valor = Inverso do Valor Original
                    mostrarProdutos = !mostrarProdutos;
                    break;
                }

                // 2. Adicionar Produto ao carrinho
                case "2": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        carrinho.adicionarProduto(produtoController.get(indice));
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Avaliar Produto
                case "3": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    // Possíveis erros: Conteúdo da avaliação vazio
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        Avaliacao avaliacao = ProdutoUtil.pedirAvaliacao(cliente, produtoController.get(indice));
                        avaliacaoController.adicionar(avaliacao);
                    } catch (IndexOutOfBoundsException | InputMismatchException | AvaliacaoException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 4. Ver Carrinho
                case "4": {
                    menuCarrinho(cliente);
                    break;
                }

                // 5. Verificar Pedido
                case "5": {
                    menuPedido(cliente);
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
    public void menuVendedor(ICliente cliente) {
    }

    @Override
    public void menuCarrinho(ICliente cliente) {
        String escolha;
        boolean mostrarCarrinho = true;
        do {
            // Carrinho do cliente
            Carrinho carrinho = carrinhoController.get(cliente);

            // Logica para mostrar lista de produtos do Carrinho
            // Só é exibida se: a lista nãp estiver vazia E mostrarCarrinho for verdadeiro
            // Caso a lista esteja vazia, não é exibida independente do valor de mostrarCarrinho
            CarrinhoUtil.exibirProdutos(carrinho.getProdutos(), mostrarCarrinho);

            // Menu do Carrinho
            System.out.println(
                    """
                    
                    ================ Carrinho de compras ================
                    
                    0. Sair
                    1. Mostrar/Ocultar Produtos
                    2. Remover Produto
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    break;
                }

                // 1. Mostrar/Ocultar Produtos
                case "1": {
                    // Novo valor = Inverso do Valor Original
                    mostrarCarrinho = !mostrarCarrinho;
                    break;
                }

                // 2. Remover Produto
                case "2": {
                    try {
                        int indice = ProdutoUtil.pedirIndice(carrinho.getProdutos().size());
                        carrinho.removerProduto(indice);
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
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
    public void menuPedido(ICliente cliente) {

    }
}
