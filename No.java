/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list;

public class No<Tipo> {

    private Tipo elemento;
    private No<Tipo> proximo;
    private No<Tipo> anterior;

    public No() {
    }

    public No(Tipo objeto) {
        this.elemento = objeto;
        this.proximo = null;
        this.anterior = null;
    }

    public No(No<Tipo> proximo, Tipo objeto) {
        this.elemento = objeto;
        this.proximo = proximo;
    }

    public No(Tipo elemento, No<Tipo> proximo, No<Tipo> anterior) {
        this(proximo, elemento);
        this.anterior = anterior;
    }

    public Tipo getElemento() {
        return elemento;
    }

    public void setElemento(Tipo elemento) {
        this.elemento = elemento;
    }

    public No<Tipo> getProximo() {
        return proximo;
    }

    public void setProximo(No<Tipo> proximo) {
        this.proximo = proximo;
    }

    public No<Tipo> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<Tipo> anterior) {
        this.anterior = anterior;
    }

}
