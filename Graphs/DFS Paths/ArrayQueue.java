import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    private int head = 0;
    private int tail = 0;
    private int numItems = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxSize) {
        queue = (T[]) new Object[maxSize];
    }

    @Override
    public void enqueue(T item) {
        queue[tail++] = item;
        if (tail == queue.length)
            tail = 0;
        numItems += 1;
    }

    @Override
    public T dequeue() {
        T item = queue[head++];
        if (head == queue.length)
            head = 0;
        numItems -= 1;
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

    private class ArrayQueueIterator implements Iterator<T> {

        int numLeft = numItems;
        int nextIndex = head;

        @Override
        public boolean hasNext() {
            return numLeft > 0;
        }

        @Override
        public T next() {
            T item = queue[nextIndex++];
            if (nextIndex == queue.length)
                nextIndex = 0;
            numLeft -= 1;
            return item;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayQueueIterator();
    }
}
