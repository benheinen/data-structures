import java.util.Iterator;

public class ArrayStack<T> implements Stack<T> {

    private T[] stk;
    private int numItems = 0;

    @SuppressWarnings("unchecked")
    public ArrayStack(int maxItems) {
        this.stk = (T[]) new Object[maxItems];
    }

    @Override
    public void push(T item) {
        this.stk[this.numItems++] = item;
    }

    @Override
    public T pop() {
        T item = this.stk[--this.numItems];
        this.stk[this.numItems] = null;
        return item;
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
            return stk[--numLeft];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayStackIterator();
    }
    
}