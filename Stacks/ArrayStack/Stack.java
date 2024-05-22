import java.util.Iterator;

interface Stack<T> extends Iterable<T> {
    void push(T item);
    T pop();
    int size();
    boolean isEmpty();
    Iterator<T> iterator();
}