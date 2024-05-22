import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T> {

    private int numItems = 0;
    private T[] queue;
    private int head = 0;
    private int tail = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxItems) {
        this.queue = (T[]) new Object[maxItems];
    }


    @Override
    public void enqueue(T item) {
        this.queue[this.tail++] = item;
        numItems++;
        if (this.tail == queue.length) {
            this.tail = 0;
        }
    }

    @Override
    public T dequeue() {
        T item = this.queue[this.head];
        this.queue[this.head++] = null;
        numItems--;
        if (this.head == queue.length) {
            this.head = 0;
        }
        return item;
   }

    @Override
    public int size() {
        return this.numItems;
    }

    @Override
    public boolean isEmpty() {
        return this.numItems == 0;
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
