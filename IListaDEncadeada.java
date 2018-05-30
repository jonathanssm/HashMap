/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.list;

public interface IListaDEncadeada<Tipo> extends Lista<Tipo> {

    public void adicionar(Tipo elemento);

    public void adicionar(int indice, Tipo elemento);

    public void adicionarNoInicio(Tipo elemento);

    public Tipo obter(int indice);

    public void removerPosicao(int indice);

    public boolean remover(Tipo valor);

    public void limpar();

    public int tamanho();

    public boolean contem(Tipo valor);

}
