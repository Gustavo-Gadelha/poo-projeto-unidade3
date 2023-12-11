package com.fesfafic.Model;

import com.fesfafic.Contract.IAvaliacao;
import com.fesfafic.Contract.ICliente;
import com.fesfafic.Contract.IProduto;
import com.fesfafic.Contract.IUtilizador;

import java.util.UUID;

public class Avaliacao implements IAvaliacao {
    private UUID id;
    private ICliente cliente;
    private IProduto produto;
    private String conteudo;

    public Avaliacao(ICliente cliente, IProduto produto, String conteudo) {
        this.id = UUID.randomUUID();
        this.cliente = cliente;
        this.produto = produto;
        this.conteudo = conteudo;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public IUtilizador getCliente() {
        return cliente;
    }

    @Override
    public IProduto getProduto() {
        return produto;
    }

    @Override
    public String getConteudo() {
        return conteudo;
    }

}
