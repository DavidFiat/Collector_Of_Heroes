package hashTable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import customExceptions.RepeatedElementException;

public class HashTable<K, V> implements IHashTable<K, V>, Serializable {

	private static final long serialVersionUID = 1L;
	public static final int SIZE = 1009;
	private HashTableNode<K, V>[] hashTableNodes;
	private int size;

	@SuppressWarnings("unchecked")
	public HashTable() {
		hashTableNodes = new HashTableNode[SIZE];
		size = 0;
	}

	@Override
	public V search(K key) {
		V value = null;
		int i = key.hashCode() % SIZE;
		HashTableNode<K, V> h = hashTableNodes[i];
		if (h != null) {
			boolean founded = false;
			while (!founded && h != null) {
				if (h.getKey().equals(key)) {
					value = h.getValue();
					founded = true;
				}
				h = h.getNext();

			}
		}
		return value;
	}

	public int Size() {
		return size;
	}

	@Override
	public void add(K key, V value) throws RepeatedElementException {
		int i = Math.abs(key.hashCode() % SIZE);
		HashTableNode<K, V> h = hashTableNodes[i];
		if (h == null) {
			h = new HashTableNode<>(key, value);
			hashTableNodes[i] = h;
		} else {
			if (search(key) != null) {
				throw new RepeatedElementException();
			}
			HashTableNode<K, V> h1 = new HashTableNode<>(key, value);
			h1.setNext(h);
			h.setPrev(h1);
			hashTableNodes[i] = h1;

		}
		size++;

	}

	@Override
	public V delete(K key) {
		V value = null;
		int i = key.hashCode() % SIZE;
		HashTableNode<K, V> h = hashTableNodes[i];
		if (h != null) {
			boolean deleted = false;
			while (!deleted && h != null) {
				if (h.getKey().equals(key)) {
					value = h.getValue();
					if (h.getNext() != null) {
						h.getNext().setPrev(h.getPrev());

					}
					if (h.getPrev() != null) {
						h.getPrev().setNext(h.getNext());
					}

					deleted = true;
				}
				h = h.getNext();

			}
		}
		size--;
		return value;

	}

	public HashTableNode<K, V>[] getHashTableNodes() {
		return hashTableNodes;
	}

	public List<V> returnHash() {
		List<V> l = new ArrayList<>();
		for (int i = 0; i < hashTableNodes.length; i++) {
			HashTableNode<K, V> h = hashTableNodes[i];
			while (h != null) {
				l.add(h.getValue());
				h = h.getNext();
			}

		}
		return l;
	}
}
