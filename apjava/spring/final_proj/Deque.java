public class Deque<Item> {
    private class LinkedList<E> {

        private DNode<E> header, trailer;
        private int size;

        public LinkedList() {
            header = new DNode<E>(null, null, null);
            trailer = new DNode<E>(null, header, null);
            header.setNext(trailer);
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean hasPrevious(DNode<E> node) {
            return node != header;
        }

        public boolean hasNext(DNode<E> node) {
            return node != trailer;
        }

        public DNode<E> getFirst() throws IllegalStateException {
            if (isEmpty())
                throw new IllegalStateException("empty list");
            return header.getNext();
        }

        public DNode<E> getLast() throws IllegalStateException {
            if (isEmpty())
                throw new IllegalStateException("empty list");
            return trailer.getPrevious();
        }

        public DNode<E> getPrevious(DNode<E> current) throws IllegalArgumentException {
            if (!hasPrevious(current))
                throw new IllegalArgumentException();
            return current.getPrevious();
        }

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

        public void addLast(E value) {
            addLast(new DNode(value, null, null));
        }

        public void remove(DNode<E> node) {
            DNode<E> prev = getPrevious(node);
            DNode<E> after = getNext(node);
            prev.setNext(after);
            after.setPrevious(prev);
            node.setNext(null);
            node.setPrevious(null);
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

        public DNode<E> getNode(int i) throws IndexOutOfBoundsException {
            if (i < 0 || i >= size)
                throw new IndexOutOfBoundsException("out of bounds");
            DNode<E> current;
            if (i < size() / 2) {
                current = getFirst();
                for (int j = 0; j < i; j++)
                    current = getNext(current);
            }
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
    }

    LinkedList<Item> deque;

    // construct an empty deque
    public Deque() {
        deque = new LinkedList<Item>();
    }
    // return true if the queue is empty, false otherwise
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    // insert the item at the front of the queue
    public void addFirst(Item item) {
        deque.addFirst(new DNode(item,null,null));
    }
    // insert the item at the end of the queue
    public void addLast(Item item) {
        deque.addLast(new DNode(item,null,null));
    }
    // delete and return the first item in the queue
    public Item removeFirst() {
        Item ans = deque.getFirst().getValue();
        deque.remove(deque.getFirst());
        return ans;
    }
    // delete and return the last item in the queue
    public Item removeLast() {
        Item ans = deque.getLast().getValue();
        deque.remove(deque.getLast());
        return ans;
    }

    public String toString() {
        return deque.toString();
    }

    public static void main(String[] args) {
        Deque d = new Deque<String>();
        String[] alphabet = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z".split(",");
        for (int i = 0; i < alphabet.length; i++) {
            if (i % 2 == 0)
                d.addLast(alphabet[i]);
            else    
                d.addFirst(alphabet[i]);
        }
        System.out.println(d);
        for (int i = 0; i < alphabet.length; i++) {
            if (i % 2 == 0)
                System.out.println("removing: " + d.removeLast());
            else
                System.out.println("removing: " + d.removeFirst());
        }
    }
}