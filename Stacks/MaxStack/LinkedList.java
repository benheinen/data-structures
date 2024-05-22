
import java.util.Iterator;
import java.util.NoSuchElementException;

// LinkedList implements a singly-linked list.  Elements
// may be added to the front or back of the list, but
// may only be removed from the front.

public class LinkedList<T> implements Iterable<T> {

	private class Node {
		T data;
		Node next;
		Node(T item, Node n) {
			data = item;
			next = n;
		}
	}

	private Node front;
	private Node back ;
	private int numItems;

	// addFront() adds an item to the front of the list.
	public void addFront(T item) {
		front = new Node(item, front);
		if (back == null)
			back = front;
		numItems += 1;
	}

	// addBack() adds an item to the back of the list.
	public void addBack(T item) {
		if (back == null) {
			back = front = new Node(item, null);
		} else {
			Node t = new Node(item, null);
			back.next = t;
			back = t;
		}
		numItems += 1;
	}

	// removeFront() removes an item from the front
	// of the list.
	// NOTE: Because of the nature of a linked list,
	// we cannot efficiently remove from the back
	// of the list.
	public T removeFront() {
		if (front == null)
			throw new NoSuchElementException();

		T ret = front.data;
		front.data = null;		// prevent loitering
		front = front.next;
		if (front == null)
			back = null;
		numItems -= 1;
		return ret;
	}
	
	// size() returns the number of items in the list.
	public int size() {
		return numItems;
	}

	// isEmpty() returns true if the list has no items,
	// and false otherwise.
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		for (Node n = front; n != null; n = n.next) {
			String s = String.format("%s ", n.data);
			sb.append(s);
		}
		sb.append("]");
		return sb.toString();
	}

	// ListIterator implements a simple Iterator
	// usable with the Java enhanced for loop.
	private class ListIterator implements Iterator<T> {

		private Node current = front;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T t = current.data;
			current = current.next;
			return t;
		}
	}

	// iterator() returns an instant of ListIterator.
	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
}
