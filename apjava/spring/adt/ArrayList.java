import java.util.LinkedList;

public class ArrayList<E> {// implements List<E>{

    // instance variables
    private  final int CAPACITY;       //  array capacity
    private E[] data;                       // generic array used for storage
    private int size;                       // current number of elements

    public ArrayList() {
      this(16);
    }

    public ArrayList(int cap) {
      CAPACITY = cap;
      data = (E[]) (new Object[cap]);
      size = 0;
    }

   public int size() {
     return size;
   }

   public boolean isEmpty() {
     return size == 0;
   }

   public String toString() {
     String ans = "[";
     for (int i = 0; i < size(); i++) {
       ans += data[i];
       if (i != size() - 1)
        ans += ",";
     }
     return ans + "]";
   }

   public boolean add(E value) throws IllegalStateException {
     if (size() == CAPACITY)
        throw new IllegalStateException();
     data[size()] = value;
     size++;
     return true;
   }

   public E get(int i) throws IndexOutOfBoundsException {
     if (i >= size())
        throw new IndexOutOfBoundsException();
     return data[i];
   }

   public E set(int i, E value) throws IndexOutOfBoundsException {
     if (i > size() || i < 0)
        throw new IndexOutOfBoundsException();
     E old = data[i];
     data[i] = value;
     return old;
   }

   public void remove(int i) throws IndexOutOfBoundsException {
     if (i >= size())
      throw new IndexOutOfBoundsException();
     for (int x = i + 1; x < size(); x++) {
       data[x - 1] = data[x];
     }
     data[size() - 1] = null;
     size--;
   }

  public boolean add(int i, E value) throws IndexOutOfBoundsException, IllegalStateException {
    if (i >= CAPACITY)
     throw new IndexOutOfBoundsException();
    if (size() == CAPACITY)
     throw new IllegalStateException();
    for (int x = size(); x > i; x--) {
      data[x] = data[x - 1];
    }
    set(i, value);
    size++;
    return true;
  }

   public static void main(String[] args) {

     //6
     ArrayList<String> list = new ArrayList<String>();
     String[] arr = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
     for(String i : arr) {
      list.add(i);
      System.out.println("list: " + list);
     }

     //7
     System.out.println();
     for(int i = 0; i < list.size(); i++) {
       System.out.println(list.get(i));
     }

     //8
     System.out.println("\nBefore: " + list);
     list.set(0,list.set(1, list.get(0)));
     System.out.println("After: " + list);
     list.set(0,list.set(1, list.get(0)));

     //9
     LinkedList<String> q = new LinkedList<String>();
     System.out.println("\n" + list);
     for(int i = 1; i < list.size(); i++) {
       System.out.println("remove: " + list.get(i));
       q.add(list.get(i));
       list.remove(i);
       System.out.println("list: " + list);
     }

     //10
     System.out.println("\nBefore inserting: " + list);
     for(int i = 1; i < list.size() + 1; i += 2) {
       System.out.println("insert: " + q.peek());
       list.add(i, q.remove());
       System.out.println("list: " + list);
     }

   }


}
