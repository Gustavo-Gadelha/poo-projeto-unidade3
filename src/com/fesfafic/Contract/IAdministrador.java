package com.fesfafic.Contract;

import java.util.UUID;

public interface IAdministrador {
    UUID getId();

    String getCodigoDeAcesso();

    String getNome();

    int getNivel();
}
