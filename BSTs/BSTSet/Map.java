import java.util.Iterator;

public interface Map<K, V> extends Iterable<K> {

    public void add(K key, V value);
    public V get(K key);
    public boolean contains(K key);
    public int size();
    public boolean isEmpty();

    @Override
    public Iterator<K> iterator();
}
