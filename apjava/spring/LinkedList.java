import javax.imageio.IIOException;
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
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // *************************** Exercise *******************************

    // returns true if v is not the header node
    public boolean hasPrevious(DNode<E> v) {

        return v != header;
    }

    // *************************** Exercise *******************************
    // returns true if v is not the trailer node
    public boolean hasNext(DNode<E> v) {
        return v != trailer;
    }

    @Override
    public E get(int i) {
        DNode<E> node = this.getFirst();
        while (i > 0) {
            node = node.getNext();
        }
        return node.getValue();
    }

    // *************************** Exercise *******************************
    public DNode<E> getFirst() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("empty list");
        return header.getNext();
    }

    // *************************** Exercise *******************************
    public DNode<E> getLast() throws IllegalStateException {
        if (isEmpty())
            throw new IllegalStateException("empty list");
        return trailer.getPrevious();
    }

    // *************************** Exercise *******************************
    // returns the node that comes directly before the current node.
    public DNode<E> getPrevious(DNode<E> current) throws IllegalArgumentException {
        if (!hasPrevious(current))
            throw new IllegalArgumentException("no previous");
        return current.getPrevious();
    }

    // *************************** Exercise *******************************
    // returns the node that comes directly after the current node.
    public DNode<E> getNext(DNode<E> current) throws IllegalArgumentException {
        if (!hasNext(current))
            throw new IllegalArgumentException("no next");
        return current.getNext();

    }

    // *************************** Exercise *******************************
    // *******************************************************************
    // inserts node a before node b.
    // An exception is thrown if b is the header
    public void addBefore(DNode<E> b, DNode<E> a) throws RuntimeException{
        if (b == header)
            throw new RuntimeException("cannot insert node before header");
        b.setPrevious(a);
        a.setNext(b);
    }

    // *************************** Exercise *******************************
    public void addLast(DNode<E> node){
        trailer.getPrevious().setNext(node);
        trailer.setPrevious(node);
    }

    // *************************** Exercise *******************************
    // *********************************************************************
    // inserts node b after node a
    // throw exception if b is the trailer node
    public void addAfter(DNode<E> a, DNode<E> b) throws RuntimeException{
        if (b == trailer)
            throw new RuntimeException("cannot insert node after trailer");
        a.getNext().setPrevious(b);
        b.setNext(a.getNext());
        a.setNext(b);
        b.setPrevious(a);
    }

    // *************************** Exercise *******************************
    public void addFirst(DNode<E> current) {
        header.getNext().setPrevious(current);
        header.setNext(current);
    }

    // *************************** Exercise *******************************
    public void addFirst(E value) {
        DNode<E> node = new DNode<E>(value, null, null);
        addFirst(node);
    }

    @Override
    public boolean add(E value) {
        addLast(new DNode<E>(value, null, null));
    }

    @Override
    public void add(int i, E value) {
        DNode<E> node = this.getFirst();
        while(i != 0) {
            this.getNext();
            i--;
        }
        addAfter(node, new DNode(value, node, node.getNext()));
    }
    // *************************** Exercise *******************************
    // *******************************************************************
    // precondition: v != null and is a node in the list
    // postconditon: removes the node v refers to.
    // Throws exception if v is header or trailer.
    public E remove(DNode<E> v) throws IllegalArgumentException{
        if (v == header || v == trailer)
            throw new IllegalArgumentException("cannot remove header or trailer");
        v.getNext().setPrevious(v.getPrevious());
        v.getPrevious().setNext(v.getNext());
        
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException{
        DNode<E> node = this.get(i);
        E ans = node.getValue();
        remove(node);
        return ans;
    }

    public E set(int i, E newValue) {
        E value = get(i).getValue();
        get(i).setValue(newValue);
        return value;
    }

    // *******************************************************************
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

    public E removeFirst() {
        return remove(this.getFirst());
    }
    public E removeLast() {
        return remove(this.getLast());
    }
    public DNode<E> getNode(int i) {
        DNode<E> node = this.getFirst();
        for (int x = 0; x < i; x++) {
            node = node.getNext();
        }
        return node;
    }

    public Iterator<E> iterator() {
        return new ListIterator<E>(this);
    }

    private class ListIterator<E> implements Iterator<E> {
        private LinkedList<E> myList;
        private DNode<E> current;
        //constructor
        public ListIterator ( linkedList<E> list) {
            myList = list;
            current = myList.head;
        }

        public E next() {
            current = current.getNext();
            return current.getValue();
        }

    }

    public void swap(DNode<E> x, DNode<E> y) {
        DNode<E> xNext = x.getNext();
        DNode<E> xPrev = x.getPrevious();
        x.setNext(y.getNext());
        x.setPrevious(y.getPrevious());
        y.setNext(xNext());
        y.setPrevious(xPrev);
    }

    public void addAll(LinkedList<E> rhs) {
        if (this == rhs) return;
        E dummy = null;
        this.addFirst(dummy);
        DNode<E> oldTrailer = trailer;
        DNode<E> prevLast = getLast();
        prevLast.setNext(rhs.getFirst());
        rhs.getFirst().setPrevious(prevLast);
        trailer = rhs.trailer;
        rhs.header.setNext(oldTrailer);
        oldTrailer.setPrevious(rhs.header);
        this.remove(dummy);
        size = n;
        rhs = 0;

        // if (rhs == this || empty(rhs)) return;
        // if (empty()) {
        //     header = rhs.header;
        //     trailer = rhs.trailer;
        //     return;
        // }
        // DNode<E> first = rhs.getFirst();
        // DNode<E> last = getLast();
        
        // last.setNext(first);
        // first.setPrevious(last);
        // DNode<E> temp = trailer;
        // trailer = rhs.trailer;
        // rhs.trailer = temp;
        // rhs.header.setNext(rhs.trailer);
        // rhs.trailer.setPrevious(rhs.header);
        // this.size += rhs.size();
        // rhs.size = 0;
    }

    public static void main(String[] args) {
        LinkedList<Integer> L = new LinkedList<Integer>();

        System.out.println("L : " + L);
        for (int i = 0; i < 10; i++) {
            L.addFirst(i);
            System.out.println("add " + i + " : " + L);
        }

        while(!L.isEmpty()) {
            L.remove(L.getFirst());
            System.out.println(L);
        }



    }

}
