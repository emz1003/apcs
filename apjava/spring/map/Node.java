public class Node<E>{
    private Node<E> next;
    private final E VALUE;

    // constructor
    public Node(E value, Node<E> next){
           this.next = next;
     VALUE = value;
    }

    // accessor methods
    public Node<E> getNext(){ return next;}
    public E getValue() { return VALUE;}

    // mutator methods
    public void setNext(Node<E> x){ next = x; }

}
