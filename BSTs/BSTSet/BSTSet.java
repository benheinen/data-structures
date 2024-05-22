import java.util.ArrayList;
import java.util.Iterator;
import java.lang.Math;

public class BSTSet<T extends Comparable<T>> implements Set<T> {


    private final int LEAF_HEIGHT = 1;

    private class Node {
        T data;
        int height = LEAF_HEIGHT;
        int size = 1;
        Node left = null;
        Node right = null;

        Node(T data) {
            this.data = data;
        }

    }

    // Invariant: root == null <-> numItems == 0
    private Node root = null;

    private int height(Node n) {
        return n == null ? (LEAF_HEIGHT - 1) : n.height;
    }

    private int size(Node n) {
        return n == null ? 0 : n.size;
    }

    private void recalculateHeight(Node n) {
        n.height = Math.max(height(n.left), height(n.right)) + 1;
    }

    private void recalculateSize(Node n) {
        n.size = size(n.left) + size(n.right) + 1;
    }

    private Node add(Node n, T item) {
        if (n == null) {
            return new Node(item);
        }
        int c = item.compareTo(n.data);
        if (c < 0) {
            n.left = add(n.left, item);
        } else if (c > 0) {
            n.right = add(n.right, item);
        }

        recalculateHeight(n);

        recalculateSize(n);

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
        return size(root);
    }

    @Override
    public boolean isEmpty() {
        return size(root) == 0;
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
        ArrayList<T> a = new ArrayList<T>(size());
        inOrder(root, a);
        return a.iterator();
    }
}
