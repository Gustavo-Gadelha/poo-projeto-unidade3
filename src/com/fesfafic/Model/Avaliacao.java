package com.fesfafic.Model;

import com.fesfafic.Contract.IAvaliacao;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Contract.IUtilizador;

import java.util.UUID;

public class Avaliacao implements IAvaliacao {
    private UUID id;
    private IUtilizador autor;
    private String conteudo;
    private IProduto produto;
    private int nota;

    public Avaliacao(IUtilizador autor, IProduto produto, String conteudo, int nota) {
        this.id = UUID.randomUUID();
        this.autor = autor;
        this.produto = produto;
        this.conteudo = conteudo;
        this.nota = nota;
    }

    @Override
    public IUtilizador getAutor() {
        return autor;
    }

    @Override
    public String getConteudo() {
        return conteudo;
    }

    @Override
    public IProduto getProduto() {
        return produto;
    }

    @Override
    public int getNota() {
        return nota;
    }
}
