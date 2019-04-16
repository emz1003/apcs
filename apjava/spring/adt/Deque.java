/*
2. A Deque is a queue-like data structure that supports insertion and
   deletion at both the front and the rear of a queue. Deque, pronounced
   "deck", is also known as a double-ended queue.

  Here's the interface for our Deque ADT:
*/
   public interface Deque<E>{
    
   
    public int size();
    public boolean isEmpty();
 
    
    public E getFirst() throws EmptyDequeException;
    public E getLast() throws EmptyDequeException;
    
    public void addFirst(E val);
    public void addLast(E val);
    
   
    public E removeFirst() throws EmptyDequeException;
    public E removeLast()  throws EmptyDequeException;
    
   
  } 

 
