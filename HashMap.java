package com.hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.array.Array;
import com.list.ListaDEncadeada;

public class HashMap<K, V> implements IHashMap<K, V> {

	private Array<ListaDEncadeada<No<K, V>>> hashMap;
	private int tamanho;

	public HashMap(int capacidade) {
		this.hashMap = new Array<>(16);

		for (int i = 0; i < hashMap.capacidade(); i++) {
			hashMap.adicionar(new ListaDEncadeada<No<K, V>>());
		}
	}

	public HashMap() {
		this(16);
	}

	private int hash(K chave) {
		return Math.abs(chave.hashCode() % hashMap.capacidade());
	}

	private boolean fazerRehash() {
		if (tamanho / hashMap.capacidade() > 0.75) {
			return true;
		}

		return false;
	}

	private Array<ListaDEncadeada<No<K, V>>> obterTabelaHash() {
		return this.hashMap;
	}

	private void rehash() {
		HashMap<K, V> novoHash = new HashMap<>(this.hashMap.capacidade() * 2);

		for (int i = 0; i < hashMap.tamanho(); i++) {
			ListaDEncadeada<No<K, V>> lista = this.hashMap.obter(i);
			for (No<K, V> no : lista) {
				novoHash.inserir(no.getChave(), no.getValor());
			}
		}

		this.hashMap = novoHash.obterTabelaHash();
	}

	@Override
	public Iterator<V> iterator() {
		return this.valores().iterator();
	}

	public List<V> valores() {
		List<V> elementos = new ArrayList<>(this.tamanho);
		for (int i = 0; i < hashMap.tamanho(); i++) {
			ListaDEncadeada<No<K, V>> lista = this.hashMap.obter(i);
			for (No<K, V> no : lista) {
				elementos.add(no.getValor());
			}
		}
		return elementos;
	}

	@Override
	public void inserir(K key, V value) {
		if (fazerRehash()) {
			rehash();
		}

		int posicao = this.hash(key);

		No<K, V> novoNo = new No<>(key, value);

		this.hashMap.obter(posicao).adicionar(novoNo);
		this.tamanho++;

	}

	@Override
	public boolean remover(K key) {
		int i = this.hash(key);

		ListaDEncadeada<No<K, V>> lista = this.hashMap.obter(i);

		for (No<K, V> no : lista) {
			if (no.getChave().equals(key)) {
				lista.remover(no);
				return true;
			}
		}

		return false;
	}

	private No<K, V> buscarNo(K chave, ListaDEncadeada<No<K, V>> lista) {
		for (No<K, V> no : lista) {
			if (no.getChave().equals(chave)) {
				return no;
			}
		}
		return null;
	}

	@Override
	public V buscar(K key) {
		ListaDEncadeada<No<K, V>> lista = this.hashMap.obter(this.hash(key));
		No<K, V> no = this.buscarNo(key, lista);

		if (no != null) {
			return no.getValor();
		}

		return null;
	}

	@Override
	public boolean contem(V value) {

		for (int i = 0; i < hashMap.capacidade(); i++) {
			ListaDEncadeada<No<K, V>> lista = this.hashMap.obter(i);
			for (int j = 0; j < lista.tamanho(); j++) {
				if (lista.obter(j).getValor().equals(value)) {
					return true;
				}
			}

		}

		return false;
	}

	@Override
	public int tamanho() {
		return this.tamanho;
	}

	@Override
	public boolean vazio() {
		return this.tamanho == 0;
	}

	@Override
	public void limpar() {
		HashMap<K, V> novoHash = new HashMap<>();

		this.hashMap = novoHash.obterTabelaHash();

		this.tamanho = 0;

	}

	@Override
	public String toString() {

		StringBuilder string = new StringBuilder();

		for (int i = 0; i < hashMap.capacidade(); i++) {
			ListaDEncadeada<No<K, V>> lista = this.hashMap.obter(i);
			for (No<K, V> no : lista) {

				string.append(no.getValor());
				string.append(" ");
			}
		}
		return string.toString();
	}

}
