package com.fesfafic.DAO;

import com.fesfafic.Contract.IDao;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Model.Avaliacao;

import java.util.ArrayList;
import java.util.UUID;

public class AvaliacaoDAO implements IDao<Avaliacao> {
    private ArrayList<Avaliacao> avaliacoes;

    public AvaliacaoDAO() {
        this.avaliacoes = new ArrayList<>();
    }

    @Override
    public Avaliacao get(UUID id) {
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getId() == id) {
                return avaliacao;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Avaliacao> listarTodos() {
        return new ArrayList<>(avaliacoes);
    }

    public ArrayList<Avaliacao> listarPorProduto(IProduto produto) {
        ArrayList<Avaliacao> lista = new ArrayList<>();
        for (Avaliacao avaliacao : avaliacoes) {
            if (avaliacao.getProduto() == produto) {
                lista.add(avaliacao);
            }
        }

        return lista;
    }

    @Override
    public boolean adicionar(Avaliacao avaliacao) {
        return avaliacoes.add(avaliacao);
    }

    @Override
    public boolean remover(Avaliacao avaliacao) {
        return avaliacoes.remove(avaliacao);
    }
}
