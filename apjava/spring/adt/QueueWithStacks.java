import java.util.Stack;
import java.util.NoSuchElementException;

public class StackQueue<E> implements MyQueue<E>{
  private ArrayStack<E> first;
  private ArrayStack<E> second;
  private final int CAP;

  public StackQueue(int cap) {
    first = new ArrayStack<E>(cap);
    second = new ArrayStack<E>(cap);
    CAP = cap;
  }

  @Override
  public int size() {
    return first.size();
  }

  @Override
  public boolean isEmpty(){
    return first.empty();
  }

  @Override
  public boolean add(E val) throws IllegalStateException{ //when the queue is at capacity
    if(first.size() == CAP) throw new IllegalStateException("Queue at capacity");
    second.push(val);
    second.transferTo(first);
    return true;
  }

  @Override
  public boolean offer(E val) { // inserts the element into queue if space available
    if(first.size() != CAP)
      return add(val);
    return false;
  }

  @Override
  public E peek() { // returns the head or null if empty
    return first.peek();
  }

  @Override
  public E poll() {// returns and removes the head or null if empty
    if (isEmpty()) return null;
    return remove();
  }

  @Override
  public E remove() throws NoSuchElementException { // returns and removes the head
    if (isEmpty()) throw new NoSuchElementException("Empty Q");
    E ans = first.pop();
    ArrayStack<E> temp = new ArrayStack<E>(CAP);
    while (!isEmpty() && !second.empty()) {
      E item = first.pop();
      second.push(item);
      temp.push(item);
    }
    temp.transferTo(first);
    return ans;
  }
  @Override
  public String toString() {
    return first.toString();
  }

  public static void main(String [] args){
    MyQueue<String> q = new StackQueue<String>(5);
    System.out.println(q);
    System.out.println("enqueue: A");
    q.add("A");
    System.out.println(q);
    System.out.println("enqueue: B");
    q.add("B");
    System.out.println(q);
    System.out.println("enqueue: C");
    q.add("C");
    System.out.println(q);
    System.out.println("enqueue: D");
    q.add("D");
    System.out.println(q);
    System.out.println("enqueue: E");
    q.add("E");
    System.out.println(q);
    System.out.println("enqueue: F");
    q.offer("F");

    System.out.println(q);
    System.out.println("dequeue: "  + q.remove());
    System.out.println("q is empty (should be false): " + q.isEmpty());
    System.out.println(q);
    System.out.println("dequeue: "  + q.remove());
    System.out.println(q);
    System.out.println("enqueue: F");
    q.offer("F");
    System.out.println(q);
  }
}
