import java.util.NoSuchElementException;

public interface MyQueue<E>{
    int size();
    boolean isEmpty();
    boolean add(E val) throws IllegalStateException; //when the queue is at capacity
    boolean offer(E val); // inserts the element into queue if space available
    E peek(); // returns the head or null if empty
    E poll(); // returns and removes the head or null if empty
    E remove() throws NoSuchElementException; // returns and removes the head
}
