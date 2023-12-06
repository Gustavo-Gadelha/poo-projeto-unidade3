package com.fesfafic.Contract;

import java.util.ArrayList;
import java.util.UUID;

public interface IRecibo {

    UUID getId();

    ICliente getRecipiente();

    ArrayList<IPedido> getPedidos();

    ArrayList<ICoupon> getCoupons();

    double getValor();
}
