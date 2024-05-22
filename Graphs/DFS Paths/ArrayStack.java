import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private T[] stack;
    private int numItems = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxSize) {
        stack = (T[]) new Object[maxSize];
    }

    @Override
    public void push(T item) {
        stack[numItems++] = item;
    }

    @Override
    public T pop() {
        return stack[--numItems];
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    private class ArrayStackIterator implements Iterator<T> {

        int numLeft = numItems;

        @Override
        public boolean hasNext() {
            return numLeft > 0;
        }

        @Override
        public T next() {
            return stack[--numLeft];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }
}
