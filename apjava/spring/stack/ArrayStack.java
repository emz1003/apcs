import java.util.EmptyStackException;

public class ArrayStack<E> implements MyStack<E> {
    // instance variables
    private E[] stack;
    private final int CAPACITY;
    private int top; // the index of value at the top

    public ArrayStack (int cap) {
        stack = (E[]) (new Object[cap]);
        CAPACITY = cap;
        top = -1;
    }

    public static void main(String[] args) {
        ArrayStack<String> s = new ArrayStack<String>(3);
        s.push("a");
        s.push("b");
        s.push("c");
        System.out.println(s);

        ArrayStack<String> t = new ArrayStack<String>(3);
        s.transferTo(t);
        System.out.println(t);

    }
    /*2.
      A.transferTo(B); // 95, 5, 0
      B.transferTo(C); // 95, 2, 3
      C.transferTo(A); // 98, 2, 0
      B.transferTo(C); // 98, 0, 2
      A.transferTo(B); // 98, 5, 2
      B.transferTo(C); // 98, 4, 3
    */

    @Override
    public boolean empty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public void push(E val) throws FullStackException {
        if (size() == CAPACITY)
            throw new FullStackException("Stack full");
        stack[top + 1] = val;
        top++;
    }

    @Override
    public E peek() throws EmptyStackException{
      if(empty())
        throw new EmptyStackException();
      return stack[top];
    }

    @Override
    public E pop() throws EmptyStackException{
      if(empty())
        throw new EmptyStackException();
      E popped = stack[top];
      stack[top] = null; /// Dereference, release object for garbage collection
      top--;
      return popped;
    }

    @Override
    public String toString() {
      String ans = "[";
      for(E x: stack) {
        if(x == null) break;
        ans += x + ",";
      }
      if(ans.length() > 1)
        ans = ans.substring(0, ans.length() - 1);
      ans += "]";
      return ans;
    }

    public void transferTo(ArrayStack<E> rhs){
      while(!empty() && top < stack.length && rhs.size() < rhs.CAPACITY){
          rhs.push(this.pop());
      }
    }
}
