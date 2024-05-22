import java.util.ArrayList;
import java.util.Iterator;

public class BSTMap<K extends Comparable<K>> implements Set<K> {

    private class Node {
        K data;
        Node left = null;
        Node right = null;

        Node(T data) {
            this.data = data;
        }
    }

    // Invariant: root == null <-> numItems == 0
    private Node root = null;
    private int numItems = 0;

    private Node add(Node n, K item) {
        if (n == null) {
            numItems += 1;
            return new Node(item);
        }
        int c = item.compareTo(n.data);
        if (c < 0) {
            n.left = add(n.left, item);
        } else if (c > 0) {
            n.right = add(n.right, item);
        }

        return n;
    }

    @Override
    public void add(T item) {
        root = add(root, item);
    }

    @Override
    public boolean contains(T item) {
        Node n = root;
        while (n != null) {
            int c = item.compareTo(n.data);
            if (c < 0) {
                n = n.left;
            } else if (c > 0) {
                n = n.right;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return numItems;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    private void inOrder(Node n, ArrayList<T> a) {
        if (n == null) return;
        inOrder(n.left, a);
        a.add(n.data);
        inOrder(n.right, a);
    }

    @Override
    public Iterator<T> iterator() {
        // It would preferable to have an iterator specific to this
        // class that could keep track of the current node and use
        // a successor() method to move to the next one.  Maybe later.
        ArrayList<T> a = new ArrayList<T>(numItems);
        inOrder(root, a);
        return a.iterator();
    }
}
