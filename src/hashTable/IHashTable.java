package hashTable;

import java.util.List;

import customExceptions.RepeatedElementException;

public interface IHashTable<K, V>{

	public V search(K key);

	public void add(K key, V value) throws RepeatedElementException;

	public V delete(K key);

	public List<V> returnHash();

}
