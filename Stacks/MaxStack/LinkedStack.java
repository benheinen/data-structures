
import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

	LinkedList<T> itemList = new LinkedList<T>();

	@Override
	public void push(T item) {
		itemList.addFront(item);
	}

	@Override
	public T pop() {
		return itemList.removeFront();
	}

	@Override
	public T peek() {
		T t = itemList.removeFront();
		itemList.addFront(t);
		return t;
	}

	@Override
	public boolean isEmpty() {
		return itemList.isEmpty();
	}

	@Override
	public int size() {
		return itemList.size();
	}

	@Override
	public String toString() {
		return itemList.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return itemList.iterator();
	}
}
