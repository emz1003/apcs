import java.util.EmptyStackException;

public class NodeStack<E> implements MyStack<E>{
    // private instance values
    private Node<E> top;
    private int size;

    // constructor
    public NodeStack(){
    	top = null;
    	size = 0;
    }

    @Override
	  public boolean empty(){ return size == 0;}

    @Override
	  public int size() { return size; }

    @Override
  	public void push (E value){
    	top = new Node<E>(value, top);
    	size++;
    }

    @Override
  	public E peek() throws EmptyStackException{
    	if (empty()) throw new EmptyStackException();
    	 return top.getValue();
    }

    @Override
  	public E pop() throws EmptyStackException{
    	E ans = peek();
    	top = top.getNext();
    	size--;
    	return ans;
    }

    @Override
  	public String toString(){
    	String ans = "[";
      Node<E> node = top;
      while(node != null){
        ans += node;
        if(node.getNext() != null)
          ans += ", ";
        node = node.getNext();
      }
    	return ans + "]";
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

    	@Override
    	public String toString(){
    	   return VALUE.toString();
    	}

    }

    public static void main(String[] args){
    	MyStack<Integer> s = new NodeStack<Integer>();
    	for (int i = 0; i < 10; i++){
    	    s.push(i);
    	    System.out.println(s);
    	}
    	System.out.println("Popping.... ");
    	while(!s.empty()){
    	    System.out.println(s.pop());
    	}
    	System.out.println(s);
    }


}
