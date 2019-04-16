import java.util. NoSuchElementException;

public class ArrayQueue<E> implements MyQueue<E>{


    // instance variables
    private E[] queue;
    private int head;  // index of the element at the head
    private int tail;  // index of next insertion point
    //private int size; // # of elements in queue
    private final int MAX_CAPACITY;

    /* *** IMPORTANT ****
     *  To simplify the code:
     *      1. head = tail iff the queue is empty
     *      2. The length of the queue is 1 more than the maximum
     *         capacity of the queue. There is always at least 1 empty
     *         location in the queue.
     *
     *   If N = queue.length then size = (N - head + tail) % N
     */

    // constructor
    public ArrayQueue(int cap){
	queue = (E[])(new Object[cap + 1]);
	head = tail = 0;
	MAX_CAPACITY = cap;
    }
    @Override
	public int size() {
	final int N = queue.length;
	return (N - head + tail) % N;
    }
    @Override
	public boolean isEmpty() { return size() == 0; }

    public boolean isFull() { return queue.length - 1 == size(); }

    @Override
	// when at capacity
	public boolean  add(E val)  throws IllegalStateException {
	if (isFull()) throw new IllegalStateException("Full Queue");
	queue[tail] = val;
	tail = (tail + 1) % (MAX_CAPACITY + 1);
	return true;
    }
    @Override
	// inserts E into queue if space available
	public boolean  offer(E val){
	if (isFull()) return false;
	return add(val);
    }
    @Override
	// returns the head of the queue or null if empty
	public E  peek(){
	if (isEmpty()) return null;
	return queue[head];
    }
    @Override
	// removes and returns the head of the queue or null
	public E poll(){
	if (isEmpty()) return null;
	return remove();
    }
    @Override
	public E  remove() throws NoSuchElementException{
	if (isEmpty()) throw new NoSuchElementException("Empty Queue");
	E ans = queue[head];
	queue[head] = null;
	head = (head + 1) % (MAX_CAPACITY + 1);
	return ans;
    }

    @Override
	public String toString(){
	String ans = "[";
	for (int i = 0; i < size() ; i++){
	    ans += queue[(head + i) % (MAX_CAPACITY + 1)] + ",";
	}
	if (ans.length() > 1) ans = ans.substring(0, ans.length() - 1);
	//ans += "]" + " head: " + head + " tail: " + tail + " size: " + size();
	return ans + "]";
    }

    public static void main(String [] args){
	MyQueue<String> q = new ArrayQueue<String>(5);
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
	System.out.println(q);
	System.out.println("dequeue: "  + q.remove());
	System.out.println(q);
	System.out.println("enqueue: F");
	q.offer("F");
	System.out.println(q);
    }


}
