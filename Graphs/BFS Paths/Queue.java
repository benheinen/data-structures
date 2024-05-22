import java.util.Iterator;

interface Queue<T> extends Iterable<T> {
    void enqueue(T item);
    T dequeue();
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
}
