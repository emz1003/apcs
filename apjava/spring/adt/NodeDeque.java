public class NodeDeque<E> implements Deque<E> {
  private int size;
  private final DNode<E> HEAD, TAIL;

  public NodeDeque() {
    HEAD = new DNode<E>(null, null, null);
    HEAD.setNext(new DNode<E>(null,HEAD,null));
    TAIL = HEAD.getNext();
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void addFirst(E value){
    DNode<E> temp = new DNode<E>(value, HEAD, HEAD.getNext());
    HEAD.getNext().setPrevious(temp);
    HEAD.setNext(temp);
    size++;
  }

  public void addLast(E value) {
    DNode<E> temp = new DNode<E>(value, TAIL.getPrevious(), TAIL);
    TAIL.getPrevious().setNext(temp);
    TAIL.setPrevious(temp);
    size++;
  }

  public E getFirst() throws EmptyDequeException {
    if (isEmpty()) throw new EmptyDequeException();
    return HEAD.getNext().getValue();

  }

  public void removeFirst() throws EmptyDequeException {
    if (isEmpty()) throw new EmptyDequeException();
    DNode<E> temp = HEAD.getNext();
    HEAD.setNext(HEAD.getNext().getNext().setPrevious(HEAD));
    temp.setNext(null).setPrevious(null);
    size--;

  }

  public String toString() {
    String ans = "[";
    for(DNode<E> x = HEAD.getNext(); x != TAIL; x = x.getNext()) {
      ans += x.getValue() + ", ";
    }
    if (ans.length() > 1)
      ans = ans.substring(0, ans.length() - 1);
    return ans + "]";
  }

  private static class DNode<E> {
    // isntance variables
    private final E VALUE;
    private DNode<E> previous, next;

    public DNode(E val, DNode<E> previous, DNode<E> next) {
      VALUE = val;
      this.next = next;
      this.previous = previous;
    }

    public E getValue(){
      return VALUE;
    }

    public DNode<E> getPrevious() {
      return previous;
    }
    public DNode<E> getNext() {
      return next;
    }
    public void setPrevious(DNode<E> x) {
      previous = x;
    }
    public void setNext(DNode<E> x) {
      next = x;
    }
  }

  public static void main(String[] args) {
    NodeDeque<Integer> deque = new NodeDeque<Integer>();
    System.out.println(deque);
    deque.addFirst(1);
    System.out.println(deque);
    deque.addFirst(2);
    System.out.println(deque);
  }
}
