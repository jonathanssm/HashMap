/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list;

import java.util.Iterator;

public class Iterador<Tipo> implements Iterator<Tipo> {

    private No<Tipo> no;

    public Iterador(No<Tipo> no) {
        this.no = no;
    }

    @Override
    public boolean hasNext() {
        return (this.no != null);
    }

    @Override
    public Tipo next() {
        Tipo g = this.no.getElemento();
        if (this.hasNext()) {
            g = this.no.getElemento();
            this.no = this.no.getProximo();
        }
        return g;
    }

}
