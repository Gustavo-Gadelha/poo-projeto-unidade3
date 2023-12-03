package com.fesfafic.Contract;

import com.fesfafic.Model.Avaliacao;

public interface ICliente {
    Avaliacao deixarAvaliacao(String avaliacao, int nota);
}
