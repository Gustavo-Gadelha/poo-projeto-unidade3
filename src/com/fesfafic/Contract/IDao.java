package com.fesfafic.Contract;

import java.util.ArrayList;

public interface IDao<T> {
    T get(long id);
    ArrayList<T> listarTodos();
    boolean adicionar(T t);
    boolean remover(T t);
}
