/*
2. A Deque is a queue-like data structure that supports insertion and
   deletion at both the front and the rear of a queue. Deque, pronounced
   "deck", is also known as a double-ended queue.

  Here's the interface for our Deque ADT:
*/
/*   The length of the array is one more than the capacity.
 *   head is the first open slot for the new head.
 *   tail is the first open slot for the new tail.
 *   head = tail iff at capacity
 *
 *   
 *
 */



public class ArrayDeque<E> implements  Deque<E>{
    
    // instance variables
    private E[] deck;
    private int head;  
    private int tail;
    private final int MAX_CAPACITY;

    public ArrayDeque(int cap){
	deck = (E[]) (new Object[cap + 1]);
	head = 0;
	tail = 1;
	MAX_CAPACITY = cap;
    }

    @Override
	public int size(){
	final int N = deck.length;
	return (N - head  + tail - 1) % N;
    }
    @Override
	public boolean isEmpty(){
	return size() == 0;
    }
 
    public boolean isFull(){
	return size() == MAX_CAPACITY;
    }

    @Override
	public E getFirst() throws EmptyDequeException{
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	int i = Math.floorMod(head + 1, deck.length);
	return deck[i];
    }
    @Override    
	public E getLast() throws EmptyDequeException{
	if (isEmpty()) 
	    throw new EmptyDequeException("Empty Deque");
	int i = Math.floorMod(tail - 1, deck.length);
	return deck[i];

    }
    @Override
	public void addFirst(E val) throws FullDequeException{
	if (isFull()) 
	    throw new FullDequeException("Full Deque");
	deck[head] = val;
	head = Math.floorMod(head - 1, MAX_CAPACITY + 1);
    }

    @Override    
	public void addLast(E val)throws FullDequeException{
	if (isFull())
	    throw new  FullDequeException("Full Deque");
	deck[tail] = val;
	tail = Math.floorMod(tail + 1, MAX_CAPACITY + 1);
    }
    
    @Override
	public E removeFirst() throws EmptyDequeException{
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	E ans = getFirst();
	head = Math.floorMod(head + 1, MAX_CAPACITY + 1);
	deck[head] = null;
	return ans;
    }
    @Override    
	public E removeLast()  throws EmptyDequeException{
	if (isEmpty())
	    throw new EmptyDequeException("Empty Deque");
	E ans = getLast();
	tail = Math.floorMod(tail - 1, MAX_CAPACITY + 1);
	deck[tail] = null;
	return ans;

    }
     
    @Override
	public String toString(){
	String ans = "[";
	// Round Robin Scheduler
	for (int i = size(); i > 0 ; i--){
	    E temp = removeFirst();
	    ans += temp + ",";
	    addLast(temp);
	}
	if (ans.length() > 1) 
	    ans = ans.substring(0,ans.length() - 1);
	ans += "]";
	return ans;
    }

    public static void main(String [] args){
	Deque<Integer> deck = new ArrayDeque<Integer>(5);
	System.out.println(deck);
	for (int i = 0; i < 20; i++){
	    int r = (int)(Math.random() * 4);
	    if (r == 0){ 
		System.out.println("add first : " + i);
		deck.addFirst(i);
	    }
	    else if (r == 1){
		System.out.println("add last : " + i);
		deck.addLast(i);
	    }
	    else if (r == 2 )
		System.out.println("Remove first: " + deck.removeFirst());
	    else
		System.out.println("Remove last: " + deck.removeLast());
	    System.out.println(deck);    
	}

    }
   
} 

 
