package com.fesfafic.Util;

import com.fesfafic.Contract.IAdministrador;
import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IMenu;
import com.fesfafic.Controller.*;
import com.fesfafic.Exception.*;
import com.fesfafic.Model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu implements IMenu {
    private static ClienteController clienteController;
    private static AdministradorController administradorController;
    private static ProdutoController produtoController;
    private static CouponController couponController;
    private static ReciboController reciboController;
    private static PedidoController pedidoController;
    private static AvaliacaoController avaliacaoController;
    private final static Scanner lineScanner = new Scanner(System.in);

    public Menu() {
        clienteController = new ClienteController();
        administradorController = new AdministradorController();
        produtoController = new ProdutoController();
        pedidoController = new PedidoController();
        couponController = new CouponController();
        reciboController = new ReciboController();
        avaliacaoController = new AvaliacaoController();

        // Administrador Padrão
        administradorController.adicionar(
                new Administrador("Exemplo@email.com", "admin@123", "@POO21")
        );
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
                    4. Acessar Menu do Administrador
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine().strip();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    System.out.println("Adeus, volte novamente");
                    break;
                }

                // 1. Fazer Cadastro
                case "1": {
                    // Possíveis erros: E-mail ou Senha em branco
                    // Possível erro: E-mail já cadastrado
                    try {
                        Cliente cliente = AcessoUtil.pedirCadastro(clienteController.listarTodos());
                        if (clienteController.adicionar(cliente)) {
                            System.out.println("Cadastro realizado com sucesso!");
                        } else {
                            System.out.println("Falha no Cadastro!");
                        }
                    } catch (CadastroException | AtributoVazioException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 2. Acessar Menu do Cliente
                case "2": {
                    try {
                        // Possíveis erros: E-mail ou Senha em branco
                        Cliente cliente = AcessoUtil.pedirLogin(clienteController.listarTodos());
                        if (cliente != null) {
                            menuCliente(cliente);
                        }
                    } catch (AtributoVazioException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Acessar Menu do Vendedor
                case "3": {
                    // Possíveis erros: E-mail ou Senha em branco
                    try {
                        Cliente cliente = AcessoUtil.pedirLogin(clienteController.listarTodos());
                        if (cliente != null) {
                            menuVendedor(cliente);
                        }
                    } catch (AtributoVazioException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 4. Acessar Menu do Administrador
                case "4": {
                    // Possíveis erros: E-mail ou Senha em branco
                    try {
                        Administrador administrador = AcessoUtil.pedirAdmnistrador(administradorController.listarTodos());
                        if (administrador != null) {
                            menuAdministrador(administrador);
                        }
                    } catch (AtributoVazioException e) {
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
    public void menuAdministrador(IAdministrador administrador) {
        String escolha;
        do {
            System.out.println(
                    """
                    
                    ================ Menu do Administrador ================
                    
                    0. Sair
                    1. Criar Coupon
                    2. Remover Coupon
                    3. Cadastrar Administrador
                    4. Remover Administrador
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine().strip();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    break;
                }

                // 1. Criar Coupon
                case "1": {
                    // Possível erro: Código não possui exatamente 8 caracteres
                    // Possível erro: Desconto maior que 100
                    // Possível erro: Desconto menor ou igual a 0
                    try {
                        Coupon coupon = CouponUtil.criarCoupon();
                        couponController.adicionar(coupon);
                    } catch (CouponException | NumberFormatException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 2. Remover Coupon
                case "2": {
                    // Possível erro: Código não possui exatamente 8 caracteres
                    try {
                        Coupon coupon = couponController.get(CouponUtil.pedirCodigo());
                        couponController.remover(coupon);
                    } catch (CouponException | NumberFormatException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Cadastrar Administrador
                case "3": {
                    // Possíveis erros: E-mail, Senha ou Código de Acesso em branco
                    // Possível erro: E-mail já registrado
                    // Possível erro: Código de acesso já registrado
                    try {
                        Administrador admin = AcessoUtil.cadastrarAdministrador(administradorController.listarTodos());
                        administradorController.adicionar(admin);
                    } catch (CadastroException | AtributoVazioException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 4. Remover Administrador
                case "4": {
                    // Possíveis erros: E-mail, Senha ou Código de Acesso em branco
                    try {
                        String codigoDeAcesso = AcessoUtil.pedirCodigoDeAcesso();
                        Administrador admin = administradorController.get(codigoDeAcesso);
                        administradorController.remover(admin);
                    } catch (AtributoVazioException e) {
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
    public void menuCliente(ICliente cliente) {
        String escolha;
        boolean mostrarProdutos = false;
        do {
            // Lista de produtos
            ArrayList<Produto> produtos = produtoController.listarTodos();

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
                    2. Fazer Pedido
                    3. Avaliar Produto
                    4. Ver Avaliações de um Produto
                    5. Ver Pedidos
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine().strip();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    break;
                }

                // 1. Mostrar/Ocultar Produtos
                case "1": {
                    // Novo valor = Inverso do Valor Atual
                    mostrarProdutos = !mostrarProdutos;
                    break;
                }

                // 2. Fazer Pedido
                case "2": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    // Possível erro: Quantidade menor ou igual a 0
                    // Possível erro: Quantidade maior que quantidade do produto
                    // Possível Erro: Vendedor fazendo um pedido do próprio produto
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        Pedido pedido = PedidoUtil.fazerPedido(cliente, produtoController.get(indice));
                        pedidoController.adicionar(pedido);
                    } catch (IndexOutOfBoundsException | NumberFormatException |
                             PedidoException | VendedorException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Avaliar Produto
                case "3": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    // Possível Erro: Conteúdo da avaliação vazío
                    // Possível Erro: Vendedor avaliando o próprio produto
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        Avaliacao avaliacao = AvaliacaoUtil.pedirAvaliacao(cliente, produtoController.get(indice));
                        avaliacaoController.adicionar(avaliacao);
                    } catch (IndexOutOfBoundsException | NumberFormatException |
                             AtributoVazioException | VendedorException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 4. Ver Avaliações de um Produto
                case "4": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        Produto produto = produtoController.get(indice);
                        AvaliacaoUtil.exibirAvaliacoes(avaliacaoController.listarPorProduto(produto));
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 5. Ver Pedidos
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
        String escolha;
        boolean mostrarProdutos = false;
        do {
            // Lista de produtos publicados pelo vendedor
            // Tendo em vista que cada cliente só tem acesso a seus próprios produtos
            // Não é preciso checar permissões e proprietários na hora de remover produtos
            // ENTRETANTO, É MELHOR IMPLEMENTAR ISSO POSTERIORMENTE
            ArrayList<Produto> produtos = produtoController.listarPorCliente(cliente);

            // Logica para mostrar lista de produtos
            // Só é exibida se: a lista nãp estiver vazia E mostrarProdutos for verdadeiro
            // Caso a lista esteja vazia, não é exibida independente do valor de mostrarProdutos
            ProdutoUtil.exibirProdutos(produtos, mostrarProdutos);

            // Menu do Cliente
            System.out.println(
                    """
                    
                    ================ Menu do Vendedor ================
                    
                    0. Sair
                    1. Mostrar/Ocultar Produtos
                    2. Publicar produto
                    3. Remover produto
                    4. Atualizar produto
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine().strip();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    break;
                }

                // 1. Mostrar/Ocultar Produtos
                case "1": {
                    // Novo valor = Inverso do Valor Atual
                    mostrarProdutos = !mostrarProdutos;
                    break;
                }

                // 2. Publicar produto
                case "2": {
                    // Possível erro: Nome do produto em branco
                    // Possível erro: Valor/Quantidade menor ou igual a 0
                    try {
                        Produto produto = VendedorUtil.publicarProduto(cliente);
                        produtoController.adicionar(produto);
                    } catch (ProdutoException | NumberFormatException |
                             AtributoVazioException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Remover produto
                case "3": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        Produto produto = produtoController.get(indice);
                        pedidoController.removerPorProduto(produto);
                        produtoController.remover(produto);
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 4. Atualizar produto
                case "4": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    // Possível erro: Nome do produto em branco
                    // Possível erro: Valor/Quantidade menor ou igual a 0
                    try {
                        int indice = ProdutoUtil.pedirIndice(produtos.size());
                        VendedorUtil.atualizarProduto(produtoController.get(indice));
                    } catch (IndexOutOfBoundsException | NumberFormatException |
                             ProdutoException | AtributoVazioException e) {
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
        String escolha;
        boolean mostrarPedidos = true;
        do {
            // Lista de pedidos
            ArrayList<Pedido> pedidos = pedidoController.listarPorCliente(cliente);

            // Logica para mostrar lista de pedidos
            // Só é exibida se: a lista não estiver vazia E mostrarPedidos for verdadeiro
            // Caso a lista esteja vazia, não é exibida independente do valor de mostrarPedidos
            PedidoUtil.exibirPedidos(pedidos, mostrarPedidos);

            // Menu de pedidos
            System.out.println(
                    """
                    
                    ================ Menu de Pedidos ================
                    
                    0. Sair
                    1. Mostrar/Ocultar Pedidos
                    2. Remover Pedido
                    3. Finalizar Compra
                    """
            );

            System.out.print("Digite sua escolha: ");
            escolha = lineScanner.nextLine().strip();

            switch (escolha) {
                // 0. Sair
                case "0": {
                    break;
                }

                // 1. Mostrar/Ocultar Pedidos
                case "1": {
                    // Novo valor = Inverso do Valor Atual
                    mostrarPedidos = !mostrarPedidos;
                    break;
                }

                // 2. Remover Pedido
                case "2": {
                    // Possíveis erros: Índice menor que 0, Índice maior que tamanho da lista
                    try {
                        int indice = ProdutoUtil.pedirIndice(pedidos.size());
                        pedidoController.remover(pedidoController.get(indice));
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.err.println("ERRO: " + e);
                        System.err.println("Abortando...\n");
                    }
                    break;
                }

                // 3. Finalizar Compra
                case "3": {
                    System.out.println("WIP");
                    break;
                }

                default: {
                    System.out.println("Entrada inválida! Digite novamente");
                    break;
                }
            }

        } while (!escolha.equals("0"));
    }
}
