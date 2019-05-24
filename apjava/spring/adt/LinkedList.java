
public class LinkedList<E> implements List<E> {

    private DNode<E> _header, _trailer; // dummy (sentinel) nodes
    private int _size;

    // constructor
    // instantiates an empty LinkedList object
    public LinkedList() {
        _header = new DNode<E>(null, null, null);
        _trailer = new DNode<E>(null, _header, null);
        _header.setNext(_trailer);
        _size = 0;
    }

    // accessor methods
    // *********** Required by the List interface. ******************
    public int size() {
        return _size;
    }

    public boolean empty() {
        return _size == 0;
    }

    // returns true if v is not the header node
    public boolean hasPrevious(DNode<E> v) {
        return v != _header;
    }

    // returns true if v is not the trailer node
    public boolean hasNext(DNode<E> v) {
        return v != _trailer;
    }

    public DNode<E> getFirst() {
        if (empty())
            throw new IllegalStateException("empty list");
        return _header.getNext();
    }

    public DNode<E> getLast() {
        if (empty())
            throw new IllegalStateException("empty list");
        return _trailer.getPrevious();
    }

    public DNode<E> getPrevious(DNode<E> current) {
        if (!hasPrevious(current))
            throw new IllegalArgumentException("cannot move back past header");
        return current.getPrevious();
    }

    public DNode<E> getNext(DNode<E> current) {
        if (!hasNext(current))
            throw new IllegalArgumentException("cannot move forward past trailer");
        return current.getNext();

    }

    // *******************************************************************
    // inserts node a before node b.
    // An exception is thrown if b is the header
    public void addBefore(DNode<E> b, DNode<E> a) {
        DNode<E> prevB = getPrevious(b); // throws exception
        prevB.setNext(a);
        a.setNext(b);
        a.setPrevious(prevB);
        b.setPrevious(a);
        _size++;
    }

    public void addLast(DNode<E> node) {
        addBefore(_trailer, node);
    }

    // *********** Required by the List interface. ******************
    public boolean add(E value) {
        addLast(new DNode<E>(value, null, null));
        return true;
    }

    // ************* HW ******************************************************
    // inserts node b after node a
    // throw exception if b is the trailer node
    public void addAfter(DNode<E> a, DNode<E> b) {
        DNode<E> afterA = getNext(a);
        a.setNext(b);
        b.setPrevious(a);
        afterA.setPrevious(b);
        b.setNext(afterA);
        _size++;
    }

    public void addFirst(DNode<E> current) {
        addAfter(_header, current);
    }

    public void addFirst(E value) {
        addFirst(new DNode<E>(value, null, null));
    }

    // *********** Required by the List interface. ******************
    public void add(int index, E val) {
        if (index < 0 || index > size())
            throw new IndexOutOfBoundsException("index = " + index + " index < 0 || index > size");
        if (index == size())
            add(val);
        else {
            DNode<E> x = getNode(index);
            addBefore(x, new DNode<E>(val, null, null));
        }
    }

    // **********IN CLASS1 ***************************************************
    public DNode<E> getNode(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException("index < 0 || index >= size()");
        DNode<E> current = null;
        if (i < size() / 2) {
            current = _header;
            for (int j = 0; j <= i; j++) {
                current = current.getNext();
                // System.out.print("h");
            }
        } else {
            current = _trailer;
            for (int j = 0; j < size() - i; j++) {
                current = current.getPrevious();
                // System.out.print("t");
            }
        }
        return current;

    }

    // *********** Required by the List interface. ******************
    public E get(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException("i : " + i + "index < 0 || index >= size()");
        return getNode(i).getValue();
    }

    // *******************************************************************
    // precondition: v != null and is a node in the list
    // postconditon: removes the node v refers to.
    // Throws exception if v is header or trailer.
    public void remove(DNode<E> v) {
        DNode<E> prev = getPrevious(v);
        DNode<E> next = getNext(v);
        prev.setNext(next);
        next.setPrevious(prev);
        _size--;
        // unlink the node
        v.setPrevious(null);
        v.setNext(null);
    }

    public E removeFirst() {
        E ans = getFirst().getValue();
        remove(getFirst());
        return ans;
    }

    public E removeLast() {
        E ans = getLast().getValue();
        remove(getLast());
        return ans;
    }

    // *********** Required by the List interface. ******************
    public E remove(int i) {
        if (i < 0 || i >= size())
            throw new IndexOutOfBoundsException("i < 0 || i >= size");
        DNode<E> node = getNode(i);
        remove(node);
        return node.getValue();
    }

    // *******************************************************************
    public String toString() {
        String ans = "";
        DNode current = _header.getNext();
        while (current != _trailer) {
            ans += current.getValue() + ", ";
            current = current.getNext();
        }
        int len = ans.length();
        if (len > 0)
            ans = ans.substring(0, len - 2);
        ans = "[" + ans + " ]";
        return ans;
    }

    // *******************************************************************
    public E set(int index, E obj) {
        DNode<E> temp = getNode(index);
        return temp.setValue(obj);

    }

    // add all the rhs elements to the lhs in O(1) time and space
    // rhs should be empty after method call
    public void addAll(LinkedList<E> rhs) {
        if (rhs == this)
            return; // L.addAll(L) does nothing
        if (rhs.empty())
            return; // L.addAll([]) -> L
        if (empty()) {
            DNode<E> temp = _header;
            _header = rhs._header;
            rhs._header = temp;
            temp = _trailer;
            _trailer = rhs._trailer;
            rhs._trailer = temp;
            this._size = rhs._size;
            rhs._size = 0;
            return;
        }
        DNode<E> last = getLast();
        DNode<E> first = rhs.getFirst();
        last.setNext(first);
        first.setPrevious(last);
        DNode<E> t = _trailer;
        _trailer = rhs._trailer;
        rhs._trailer = t;
        rhs._header.setNext(rhs._trailer);
        rhs._trailer.setPrevious(rhs._header);
        this._size += rhs.size();
        rhs._size = 0;
    }

    /****************************************************************
     * Code to support the for-each loop and Iterators
     */

    public static void main(String[] args) {
        LinkedList<Integer> L = new LinkedList<Integer>();

        System.out.println("L : " + L);
        for (int i = 0; i < 10; i++) {
            L.add(i);
            System.out.println("add " + i + " : " + L);
        }

        System.out.println("*********  testing for-each loop ***********");
        Iterator<Integer> itr = L.iterator();
        // System.out.println(itr.hasNext());
        while (itr.hasNext()) {
            if (itr.next() % 2 == 0)
                itr.remove();
            // System.out.println(itr.next());

        }
        for (Integer x : L)
            System.out.println(x);

    }

}
