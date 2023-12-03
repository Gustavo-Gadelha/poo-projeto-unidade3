package com.fesfafic.Model;

import com.fesfafic.Contract.IUtilizador;

public class Avaliacao {
    private IUtilizador autor;
    private String conteudo;
    private int nota;

    public Avaliacao(IUtilizador autor, String conteudo, int nota) {
        this.autor = autor;
        this.conteudo = conteudo;
        this.nota = nota;
    }
}
