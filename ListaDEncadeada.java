/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list;

import java.util.Iterator;

public class ListaDEncadeada<Tipo> implements IListaDEncadeada<Tipo> {

    private No<Tipo> inicio, fim;
    private int contElementos;

    public ListaDEncadeada() {
        this.inicio = this.fim = null;
    }

    @Override
    public void removerPosicao(int indice) {

        if (indice == 0) {
            this.RemoverNoInicio();
        } else if (indice == this.contElementos - 1) {
            this.RemoverNoFim();
        } else {
            No<Tipo> anterior = this.pegaNo(indice - 1);
            No<Tipo> atual = anterior.getProximo();
            No<Tipo> proxima = atual.getProximo();
            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);
            this.contElementos--;
        }
    }

    public void RemoverNoInicio() {
        if (!this.posicaoOcupada(0)) {
            throw new IllegalArgumentException("Inexistente");
        }
        this.inicio = this.inicio.getProximo();
        this.contElementos--;
        if (this.contElementos == 0) {
            this.fim = null;
        }

    }

    public void RemoverNoFim() {
        if (this.contElementos == 1) {
            this.RemoverNoInicio();
        } else {
            No<Tipo> penultimo = this.fim.getAnterior();
            penultimo.setProximo(null);
            this.fim = penultimo;
            this.contElementos--;
        }
    }

    @Override
    public void adicionarNoInicio(Tipo elemento) {

        if (this.inicio == null) {
            No<Tipo> novoNo = new No<Tipo>(elemento);
            this.inicio = this.fim = novoNo;
        } else {
            No<Tipo> novoNo = new No<Tipo>(this.inicio, elemento);
            this.inicio.setAnterior(novoNo);
            this.inicio = novoNo;
        }
        this.contElementos++;
    }

    @Override
    public void adicionar(Tipo elemento) {
        No<Tipo> novoNo = new No<>(elemento);
        if (this.inicio == null) {
            this.inicio = this.fim = novoNo;
        } else {
            this.fim.setProximo(novoNo);
            novoNo.setAnterior(this.fim);
            this.fim = novoNo;
        }
        this.contElementos++;
    }

    @Override
    public void adicionar(int indice, Tipo elemento) {
        No<Tipo> anterior = new No<>(elemento);
        No<Tipo> proxima = new No<>(elemento);

        if (indice == 0) {
            this.adicionarNoInicio(elemento);
        } else if (indice == this.contElementos) {
            this.adicionar(elemento);
        } else {
            anterior = this.pegaNo(indice - 1);
            proxima = anterior.getProximo();

            No<Tipo> novoNo = new No<Tipo>(elemento, proxima, anterior);
            anterior.setProximo(novoNo);
            proxima.setAnterior(novoNo);
        }
        this.contElementos++;
    }

    private boolean posicaoOcupada(int indice) {
        return indice >= 0 && indice < this.contElementos;
    }

    private No<Tipo> pegaNo(int indice) {
        if (!this.posicaoOcupada(indice)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        No<Tipo> atual = this.inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        return atual;
    }

    @Override
    public boolean contem(Tipo elemento) {
        No<Tipo> atual = this.inicio;
        if (this.contElementos == 0) {
            throw new IllegalArgumentException("YOU KNOW NOTHING");
        } else if (this.fim.getElemento().equals(elemento)) {
            return true;
        } else {
            for (int i = 0; i < this.contElementos; i++) {
                if (atual.getElemento().equals(elemento)) {
                    return true;
                } else {
                    atual = atual.getProximo();
                }
            }
        }
        return false;
    }

    @Override
    public int tamanho() {
        return this.contElementos;
    }

    @Override
    public Iterator<Tipo> iterator() {
        return new Iterador<>(this.inicio);
    }

    public Iterator<Tipo> iteratorReverso() {
        return new IteratorReverso<>(this.fim);
    }

    @Override
    public Tipo obter(int indice) {
        No<Tipo> atual = this.inicio;
        for (int i = 0; i < indice; i++) {
            atual = atual.getProximo();
        }
        System.out.println(atual);
        return (Tipo) atual;
    }

    @Override
    public boolean remover(Tipo elemento) {
        No<Tipo> atual = this.inicio;

        for (int i = 0; i < this.contElementos; i++) {
            if (atual.getElemento().equals(elemento)) {
                this.removerPosicao(i);
                return true;
            } else {
                atual = atual.getProximo();
            }
        }

        return true;
    }

    @Override
    public void limpar() {
        this.RemoverNoInicio();
        this.RemoverNoFim();
        for (int i = 0; i < this.contElementos; i++) {
            this.removerPosicao(i);
        }
    }
}
