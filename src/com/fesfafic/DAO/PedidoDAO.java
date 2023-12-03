package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Pedido;

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

    @Override
    public ArrayList<Pedido> listarTodos() {
        return new ArrayList<>(pedidos);
    }

    @Override
    public boolean adicionar(Pedido pedido) {
        return pedidos.add(pedido);
    }

    @Override
    public boolean remover(Pedido pedido) {
        return pedidos.remove(pedido);
    }
}
