package com.array;

import java.util.Iterator;

public class Array<Type> implements IArray<Type> {

    private Type[] array;
    private int size;

    public Array() {
        this(16);
    }

    public Array(int length) {
        array = (Type[]) new Object[length];
    }

    @Override
    public void adicionar(Type element) {
        increaseSize();
        array[size++] = element;
    }

    @Override
    public void adicionar(int indice, Type element) {
        increaseSize();
        for (int i = size; i > indice; i--) {
            array[i] = array[i - 1];
        }
        array[indice] = element;
        size++;
    }

    @Override
    public void adicionarInicio(Type element) {
        increaseSize();
        for (int i = size; i > 0; i--) {
            array[i] = array[i - 1];
        }
        array[0] = element;
        size++;
    }

    @Override
    public Type obter(int indice) {
        if (indice >= size) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        return array[indice];
    }

    @Override
    public void remover(int indice) {
        for (int i = indice; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    @Override
    public boolean remover(Type value) {

        if (array[size - 1].equals(value)) {
            array[size - 1] = null;
            size--;
            return true;
        }

        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                remover(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void limpar() {
        array = (Type[]) new Object[16];
    }

    @Override
    public int tamanho() {
        return size;
    }

    @Override
    public boolean contem(Type value) {

        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                return true;
            }
        }

        return false;

    }

    @Override
    public Iterator<Type> iterator() {
        return new com.array.IteradorArray<>(this);
    }

    private void increaseSize() {
        if (array.length == size) {
            Type[] vetor2 = (Type[]) new Object[size * 2];
            for (int i = 0; i < array.length; i++) {
                vetor2[i] = array[i];
            }
            array = vetor2;
        }
    }
    
    public int capacidade() {
    	return this.array.length;
    }
}
