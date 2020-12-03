package hashTable;

import java.io.Serializable;

public class HashTableNode<K, V> implements Serializable {

	private static final long serialVersionUID = 1L;
	private K key;
	private V value;

	private HashTableNode<K, V> next;
	private HashTableNode<K, V> prev;

	public HashTableNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public HashTableNode<K, V> getNext() {
		return next;
	}

	public void setNext(HashTableNode<K, V> next) {
		this.next = next;
	}

	public HashTableNode<K, V> getPrev() {
		return prev;
	}

	public void setPrev(HashTableNode<K, V> prev) {
		this.prev = prev;
	}

}
