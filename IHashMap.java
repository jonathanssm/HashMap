package com.hashmap;

public interface IHashMap<K, V> extends Iterable<V> {
	
	public void inserir(K key, V value);
	public boolean remover(K key);
	public V buscar(K key);
    public boolean contem(V value);
    public int tamanho();
    public boolean vazio();
    public void limpar();

}
