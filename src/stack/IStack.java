package stack;

import java.io.Serializable;
import java.util.Iterator;

public class IStack<E> implements InStack<E>, Serializable {

	private static final long serialVersionUID = 1L;
	private StackNode<E> first;
	private StackNode<E> last;
	private int size;

	public IStack() {
		first = null;
		last = null;
		size = 0;
	}

	public StackNode<E> getFirst() {
		return first;
	}

	public void setFirst(StackNode<E> first) {
		this.first = first;
	}

	public StackNode<E> getLast() {
		return last;
	}

	public void setLast(StackNode<E> last) {
		this.last = last;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void push(E e) {
		// TODO Auto-generated method stub
		StackNode<E> newNode = new StackNode<E>(e);
		if (first == null) {
			first = newNode;
			last = newNode;
			size++;
		} else {
			last.setNext(newNode);
			newNode.setPrev(last);
			newNode.setNext(null);
			last = newNode;
			size++;
		}
	}

	@Override
	public E peek() {
		E aux = null;
		if (first == null) {
			return null;
		}
		if (first.getNext() == null) {
			aux = first.getElement();
		} else {
			aux = last.getElement();
		}
		return aux;
	}

	@Override
	public E pop() {
		E aux = null;
		if (first == null) {
			return null;
		}
		if (first.getNext() == null) {
			aux = first.getElement();
			first = null;
			size--;
		} else {
			aux = last.getElement();
			last.getPrev().setNext(null);
			last = last.getPrev();
			size--;
		}
		return aux;
	}

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int Isize() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator<E>(first);
	}
}
