import java.util.NoSuchElementException;
public class ArrayQueue<E> implements MyQueue<E>{
  private int head;
  private int tail;
  private E[] queue;
  private final int MAX_CAPACITY;

  public ArrayQueue(int cap) {
    queue = (E[]) (new Object[cap + 1]);
    MAX_CAPACITY = cap;
    head = 0;
    tail = 0;
  }

  @Override
  public int size() {
    return (queue.length + tail - head) % queue.length;
  }

  @Override
  public boolean isEmpty() {
    return size() == 0l;
  }

  //Enqueue
  @Override
  public boolean add(E val) throws IllegalStateException{
    queue[tail] = val;
    tail = (tail + 1) % MAX_CAPACITY;
    return true;
  }

  @Override
  public boolean offer(E val) {
    if (size() + 1 != MAX_CAPACITY) {
      add(val);
    }
    return false;
  }

  @Override
  public E peek() {
    //if (!isEmpty())
    return queue[head];
    //return null;
  }

  @Override
  public E poll() {
    try{
      return remove();
    } catch (NoSuchElementException e) {
      return null;
    }
  }

  @Override
  public E remove() throws NoSuchElementException{
    if(isEmpty())
      throw new NoSuchElementException("Empty Queue");
    E temp = queue[head];
    queue[head] = null;
    head = (head + 1) % (MAX_CAPACITY + 1);

    return temp;
  }

  @Override
  public String toString() {
    String ans = "";
    for (E i: queue) {
      ans += i + " ";
    }
    return ans;
  }

}
