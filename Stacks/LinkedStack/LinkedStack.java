import java.util.Iterator;

public class LinkedStack<T> implements Stack<T> {

    private class Node {
        T data;
        Node next;

        Node(T item, Node next) {
            this.data = item;
            this.next = next;
        }
    }

    // top == null <-> numItems == 0
    private Node top = null;
    private int numItems = 0;

    @Override
    public void push(T item) {
        this.top = new Node(item, top);
        this.numItems++;
    }

    @Override
    public T pop() {
        if (top == null) {
            throw new RuntimeException("Attempt to pop from empty stack");
        }
        T item = this.top.data;
        this.top.data = null;        // avoid loitering
        this.top = this.top.next;
        this.numItems--;
        return item;
    }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private class StackIterator implements Iterator<T> {

        Node next = top;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            T item = next.data;
            next = next.next;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }   
}
