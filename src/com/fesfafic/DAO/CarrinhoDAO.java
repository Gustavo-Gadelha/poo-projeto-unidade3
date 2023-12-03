package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Model.Carrinho;

import java.util.ArrayList;
import java.util.UUID;

public class CarrinhoDAO implements IDao<Carrinho> {
    private ArrayList<Carrinho> carrinhos;

    public CarrinhoDAO() {
        this.carrinhos = new ArrayList<>();
    }

    @Override
    public Carrinho get(UUID id) {
        for (Carrinho carrinho : carrinhos) {
            if (carrinho.getId() == id) {
                return carrinho;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Carrinho> listarTodos() {
        return new ArrayList<>(carrinhos);
    }

    @Override
    public boolean adicionar(Carrinho carrinho) {
        return carrinhos.add(carrinho);
    }

    @Override
    public boolean remover(Carrinho carrinho) {
        return carrinhos.remove(carrinho);
    }
}
