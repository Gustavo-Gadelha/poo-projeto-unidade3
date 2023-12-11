package com.fesfafic.DAO;

import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Pedido;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.UUID;

public class PedidoDAO implements IDao<Pedido> {
    private ArrayList<Pedido> pedidos;

    public PedidoDAO() {
        this.pedidos = new ArrayList<>();
    }

    @Override
    public Pedido get(UUID id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }

        return null;
    }

    public Pedido get(int indice) {
        if (indice >= 0 && indice < pedidos.size()) {
            return pedidos.get(indice);
        } else {
            return null;
        }
    }


    public Pedido get(Produto produto) {
        for (Pedido pedido : pedidos) {
            if (pedido.getProduto() == produto) {
                return pedido;
            }
        }

        return null;
    }

    @Override
    public ArrayList<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }

    public ArrayList<Pedido> listarPorCliente(ICliente cliente) {
        ArrayList<Pedido> lista = new ArrayList<>();
        for (Pedido pedido : pedidos) {
            if (pedido.getCliente() == cliente) {
                lista.add(pedido);
            }
        }

        return lista;
    }

    @Override
    public boolean adicionar(Pedido pedido) {
        // Se já existe um pedido do mesmo produto registrado, adicione as quantidades
        for (Pedido pedido_registrado : pedidos) {
            if (pedido_registrado.getProduto() == pedido.getProduto()) {
                pedido_registrado.setQuantidade(pedido_registrado.getQuantidade() + pedido.getQuantidade());
                return true;
            }
        }
        return this.pedidos.add(pedido);
    }

    @Override
    public boolean remover(Pedido pedido) {
        return this.pedidos.remove(pedido);
    }

    public boolean removerPorProduto(Produto produto) {
        // Remove todos os pedidos de um certo produto
        return pedidos.removeIf(pedido -> pedido.getProduto() == produto);
    }
}
