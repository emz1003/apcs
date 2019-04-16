public class NodeQueue<E> implements MyQueue<E>{
  private final Node<E> HEAD; // is dummy node
  private Node<E> tail;
  private int size;

  public NodeQueue(int cap) {
    HEAD = new Node<E>(null, null);
    tail = HEAD;
    size = 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty(){
    return size() == 0;
  }

  @Override
  public boolean add(E val) throws IllegalStateException {
    Node<E> temp = new Node<E>(val, null);
    tail.setNext(temp);
    tail = temp;
    size++;

    return true;
  }

  public boolean offer(E val) {
    return add(val);
  }

  public E peek() {
    if(isEmpty()) return null;
    return HEAD.getNext().getValue;
  }

  public E poll() {
    return remove();
  }

  public E remove() {
    if(isEmpty()) throw NoSuchElementException("Empty Q");
    E ans = HEAD.getNext().getValue();
    HEAD.setNext(HEAD.getNext().getNext());
    size--;
    if(isEmpty()) tail = HEAD;
    return ans;
  }

  private static class Node<E>{
    // instance variables
    private final E VALUE;
    private final Node<E> NEXT;

    // constructor
    public Node(E value, Node<E> next){
        VALUE = value;
        NEXT = next;
    }

    public E getValue(){ return VALUE;}
    public Node<E> getNext() { return NEXT;}

    public void setNext(Node<E> node) { NEXT = node};

    @Override
    public String toString(){
       return VALUE.toString();
    }
  }
}
