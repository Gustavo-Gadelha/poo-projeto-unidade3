package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Produto;

import java.util.ArrayList;
import java.util.UUID;

public class ProdutoDAO implements IDao<Produto> {
    private ArrayList<Produto> produtos;

    public ProdutoDAO() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public Produto get(UUID id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Produto> listarTodos() {
        return new ArrayList<>(produtos);
    }

    @Override
    public boolean adicionar(Produto produto) {
        return produtos.add(produto);
    }

    @Override
    public boolean remover(Produto produto) {
        return produtos.remove(produto);
    }
}
