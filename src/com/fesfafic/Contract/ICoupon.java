package com.fesfafic.Contract;

import java.util.UUID;

public interface ICoupon {

    UUID getId();

    String getCodigo();

    int getDesconto();
}
