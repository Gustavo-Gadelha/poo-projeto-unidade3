package com.fesfafic.Util;

import com.fesfafic.Exception.CouponException;
import com.fesfafic.Model.Coupon;

import java.util.Scanner;

public class CouponUtil {
    private static final Scanner lineScanner = new Scanner(System.in);

    public static Coupon criarCoupon() throws CouponException, NumberFormatException {
        String codigo = CouponUtil.pedirCodigo();
        int desconto = CouponUtil.pedirDesconto();
        return new Coupon(codigo, desconto);
    }

    public static String pedirCodigo() throws CouponException {
        System.out.print("Digite o código do coupon: ");
        String codigo = lineScanner.nextLine().strip();

        if (codigo.length() != 8) {
            throw new CouponException("Códigos do coupon devem ter exatamente 8 caracteres");
        }

        return codigo;
    }

    public static int pedirDesconto() throws CouponException, NumberFormatException {
        System.out.print("Digite a porcentagem de desconto do coupon: ");
        int codigo;
        try {
            codigo = Integer.parseInt(lineScanner.nextLine().strip());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Porcentagem de desconto deve ser um número inteiro de 1 a 100 ");
        }

        if (codigo > 100) {
            throw new CouponException("Porcentagem de desconto não pode ser maior que 100");
        } else if (codigo <= 0) {
            throw new CouponException("Porcentagem de desconto não pode ser menor ou igual a 0");
        }

        return codigo;
    }

}
