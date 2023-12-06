package com.fesfafic.Contract;

public interface IAdministrador {

    boolean fazerLogin(String email, String senha, String codigoDeAcesso);

    String getCodigoDeAcesso();
}
