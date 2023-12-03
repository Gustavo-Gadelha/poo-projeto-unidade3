package com.fesfafic.Contract;

import java.util.ArrayList;
import java.util.UUID;

public interface IDao<T> {

    T get(UUID id);

    ArrayList<T> listarTodos();

    boolean adicionar(T t);

    boolean remover(T t);
}
