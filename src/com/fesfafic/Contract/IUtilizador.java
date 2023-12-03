package com.fesfafic.Contract;

import java.util.ArrayList;

public interface IUtilizador {
    boolean fazerLogin(String email, String senha);

    boolean sacar(double valor);
    void depositar(double valor);
    boolean transferePara(IUtilizador utilizador, double valor);
    boolean adicionarHistorico(String transferencia);
    String getEmail();
    String getSenha();;
    ArrayList<String> getHistorico();
}
