package com.array;

import java.util.Iterator;

public class IteradorArray<Type> implements Iterator<Type> {

    private Array<Type> lista;
    private int indice = 0;

    public IteradorArray(Array<Type> lista) {
        this.lista = lista;
    }

    @Override
    public boolean hasNext() {
        return indice <= lista.tamanho() - 1;
    }

    @Override
    public Type next() {
        return lista.obter(indice++);
    }

}
