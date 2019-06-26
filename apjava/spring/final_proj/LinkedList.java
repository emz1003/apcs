import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private DNode<E> header, trailer; // dummy (sentinel) nodes
    private int size;

    // constructor
    // instantiates an empty LinkedList object
    public LinkedList() {
        header = new DNode<E>(null, null, null);
        trailer = new DNode<E>(null, header, null);
        header.setNext(trailer);
        size = 0;
    }

    // ******** accessor methods *******
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // returns true if v is not the header node
    public boolean hasPrevious(DNode<E> v) {
        return v != header;
    }

    // returns true if v is not the trailer node
    public boolean hasNext(DNode<E> v) {
        return v != trailer;
    }

    // returns the first node of a non-empty linked list
    public DNode<E> getFirst() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("empty list");
        return header.getNext();
    }

    // returns the last node of a non-empty linked list
    public DNode<E> getLast() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("empty list");
        return trailer.getPrevious();
    }

    // returns the node that comes directly before the current node.
    public DNode<E> getPrevious(DNode<E> current) throws IllegalArgumentException {
        if (!hasPrevious(current))
            throw new IllegalArgumentException();
        return current.getPrevious();
    }

    // returns the node that comes directly after the current node.
    public DNode<E> getNext(DNode<E> current) throws IllegalArgumentException {
        if (!hasNext(current))
            throw new IllegalArgumentException();
        return current.getNext();

    }

    // inserts node a before node b.
    // An exception is thrown if b is the header
    public void addBefore(DNode<E> b, DNode<E> a) {
        DNode<E> prevB = getPrevious(b);
        a.setNext(b);
        a.setPrevious(prevB);
        b.setPrevious(a);
        prevB.setNext(a);
        size++;
    }

    public void addLast(DNode<E> node) {
        addBefore(trailer, node);
    }

    // inserts node b after node a
    // throw exception if a is the trailer node
    public void addAfter(DNode<E> a, DNode<E> b) {
        DNode<E> afterA = getNext(a);
        b.setPrevious(a);
        b.setNext(afterA);
        a.setNext(b);
        afterA.setPrevious(b);
        size++;
    }

    public void addFirst(DNode<E> current) {
        addAfter(header, current);
    }

    public void addFirst(E value) {
        addFirst(new DNode(value, null, null));
    }

    public void addLast(E value) {
        addLast(new DNode(value, null, null));
    }

    public void remove(DNode<E> v) {
        DNode<E> prev = getPrevious(v);
        DNode<E> after = getNext(v);
        prev.setNext(after);
        after.setPrevious(prev);
        v.setNext(null);
        v.setPrevious(null);
        size--;
    }

    public String toString() {
        String ans = "";
        DNode current = header.getNext();
        while (current != trailer) {
            ans += current.getValue() + ", ";
            current = current.getNext();
        }
        int len = ans.length();
        if (len > 0)
            ans = ans.substring(0, len - 2);
        ans = "[" + ans + " ]";
        return ans;
    }

    public void swap(DNode<E> x, DNode<E> y) {
        // x or y is a dummy node
        if (hasNext(x) && hasNext(y) && hasPrevious(x) && hasPrevious(y))
            ;
        // swap x with itself
        if (x == y)
            return;
        // generalize x right before y and y right before x
        if (getNext(y) == x) {
            swap(y, x);
            return;
        }
        // generalize : x adjacent to y
        DNode<E> dummy = new DNode<E>(null, null, null);
        addAfter(x, dummy);
        // general case
        DNode<E> prevX = getPrevious(x);
        DNode<E> afterX = getNext(x);
        DNode<E> prevY = getPrevious(y);
        DNode<E> afterY = getNext(y);

        x.setNext(afterY);
        x.setPrevious(prevY);
        afterY.setPrevious(x);
        prevY.setNext(x);
        y.setNext(afterX);
        y.setPrevious(prevX);
        afterX.setPrevious(y);
        prevX.setNext(y);
        remove(dummy);
    }

    public void addAll(LinkedList<E> rhs) {
        if (rhs.isEmpty() || this == rhs)
            return;
        E dummy = null;
        this.addFirst(dummy);
        DNode<E> h = rhs.header;
        DNode<E> t = this.trailer;
        getLast().setNext(rhs.getFirst());
        rhs.getFirst().setPrevious(getLast());
        trailer = rhs.trailer;
        rhs.trailer = t;
        rhs.header.setNext(rhs.trailer);
        rhs.trailer.setPrevious(rhs.header);
        remove(getFirst());
        size = size + rhs.size;
        rhs.size = 0;
    }

    public DNode<E> getNode(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size)
            throw new IndexOutOfBoundsException("out of bounds");
        DNode<E> current;
        // left half
        if (i < size() / 2) {
            current = getFirst();
            for (int j = 0; j < i; j++)
                current = getNext(current);
        }
        // right half
        else {
            current = getLast();
            for (int j = size() - 1 - i; j > 0; j--)
                current = getPrevious(current);
        }
        return current;

    }

    public boolean add(E value) {
        addLast(value);
        return true;
    }

    public void add(int i, E value) throws IndexOutOfBoundsException {
        if (i < 0 || i > size())
            throw new IndexOutOfBoundsException("i < 0 || i > size()");
        if (i == size())
            add(value);
        else {
            addBefore(getNode(i), new DNode<E>(value, null, null));
        }

    }

    public E remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size())
            throw new IndexOutOfBoundsException();
        DNode<E> x = getNode(i);
        remove(x);
        return x.getValue();
    }

    public E get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i > size())
            throw new IndexOutOfBoundsException();
        return getNode(i).getValue();
    }

    public E set(int i, E value) throws IndexOutOfBoundsException {
        if (i < 0 || i > size())
            throw new IndexOutOfBoundsException();
        return getNode(i).setValue(value);
    }

}