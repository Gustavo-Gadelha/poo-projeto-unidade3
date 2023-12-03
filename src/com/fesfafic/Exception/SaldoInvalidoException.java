package com.fesfafic.Exception;

public class SaldoInvalidoException extends RuntimeException {
    public SaldoInvalidoException() {
        super();
    }

    public SaldoInvalidoException(String message) {
        super(message);
    }
}
