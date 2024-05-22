import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {

    private class Node {
        T data;
        Node next;

        Node(T item) {
            this.data = item;
            this.next = null;
        }
    }

    // front == null <-> back == null
    private Node front = null;
    private Node back = null;
    private int numItems = 0;

    @Override
    public void enqueue(T item) {
        Node newNode = new Node(item);
        this.numItems++;
        if (this.front == null) {
            this.back = newNode;
            this.front = newNode;
        } else {
            back.next = newNode;
            back = newNode;
        }
   }

    @Override
    public T dequeue() {
        if (front == null) {
            throw new RuntimeException("Attempt to remove from an empty queue");
        }
        this.numItems--;
        T item = front.data;
        front = front.next;

        if (front == null) {
            back = null;
        }
        return item;
    }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public boolean isEmpty() {
        return front == null;
    }

    private class QueueIterator implements Iterator<T> {

        Node nextNode = front;

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T item = nextNode.data;
            nextNode = nextNode.next;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }    

}