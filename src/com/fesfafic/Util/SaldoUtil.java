package com.fesfafic.Util;

import com.fesfafic.Exception.SaldoException;

import java.util.Scanner;

public class SaldoUtil {
    public static double pedirDeposito(Scanner lineScanner) throws NumberFormatException, SaldoException {
        // Valor do depósito, deve ser um número decimal e maior que zero
        System.out.print("Digite o valor do deposito: ");
        double deposito;
        try {
            deposito = Double.parseDouble(lineScanner.nextLine().strip());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Valor do deposito deve ser ser um número decimal");
        }

        if (deposito <= 0) {
            throw new SaldoException("Valor do deposito deve ser maior que zero");
        }

        return deposito;
    }
}
