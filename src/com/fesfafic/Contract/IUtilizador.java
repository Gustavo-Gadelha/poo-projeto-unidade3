package com.fesfafic.Contract;

import java.util.ArrayList;
import java.util.UUID;

public interface IUtilizador {
    boolean fazerLogin(String email, String senha);

    boolean sacar(double valor);

    void depositar(double valor);

    boolean transferirPara(IUtilizador utilizador, double valor);

    boolean adicionarHistorico(String transferencia);

    UUID getId();

    String getEmail();

    String getSenha();

    double getSaldo();

    ArrayList<String> getHistorico();
}
