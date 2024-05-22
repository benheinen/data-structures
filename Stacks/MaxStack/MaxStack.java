import java.util.Iterator;

public class MaxStack<T extends Comparable<T>> implements Stack<T> {

    LinkedStack<T> linkedStack = new LinkedStack<T>();
    LinkedStack<T> maxStack = new LinkedStack<T>();
    private T currentMax = null;

    public T max() {
        return currentMax;
    }

	public void push(T item) {
		linkedStack.push(item);

        if (currentMax == null || item.compareTo(currentMax) > 0) {
            currentMax = item;
        }

        maxStack.push(currentMax);
	}

	public T pop() {
		maxStack.pop();

        T top = linkedStack.pop();

        if (maxStack.isEmpty()) {
            currentMax = null;
        } else {
            currentMax = maxStack.peek();
        }

        return top;
	}

    @Override
	public T peek() {
		T t = linkedStack.pop();
		linkedStack.push(t);
		return t;
	}

    @Override
	public boolean isEmpty() {
		return linkedStack.isEmpty();
	}

    @Override
	public int size() {
		return linkedStack.size();
	}

	public String toString() {
        return linkedStack.toString() + " Max = " + (currentMax);
	}

    @Override
    public Iterator<T> iterator() {
        return linkedStack.iterator();
    }

    // The ones you'll need to think about are push() and pop(), 
    // which, besides storing the given item, need to do 
    // something to keep track of the current maximum value.


}
