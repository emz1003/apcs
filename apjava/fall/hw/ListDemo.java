/*

Useful ArrayList Constructor and Methods
------------------------------------------------------------------------------
 Constructor:
         new ArrayList<E>()

 Methods

  int	  size()	      : returns the length of the list
  boolean isEmpty()           : returns true if empty
  E    	  get(int i)          : returns the element at index i
  E    	  set(int i,E val)    : places val at index i and
                                returns the replaced val
  boolean add(E val)	      : adds to the end
  void    add(int i, E val)   : inserts val at i
  E    	  remove(int i)          : returns and removes the element at i
  boolean remove(E val)       : removes the first occurrence if found
                                returns true if val is removed
  void    clear()             : removes all elements
  boolean contains(E val)     : returns true if list contains val
  int     indexOf(E val)      : returns the first index of val or -1
                                if not found
  int     lastIndexOf(E val)  : returns the last index of val or -1
                                if not found

*/

/****************************************************************************
 *  Write a program that demonstrates the use of each of the ArrayList
 *  methods listed above.
*****************************************************************************/
import java.util.ArrayList;

public class ListDemo{

    public static void main(String [] args){
	     new ListDemo().run();

    }

    public void run(){
    	ArrayList<String> list = new ArrayList<String>();
    	System.out.println ("empty?: " + list.isEmpty());
    	System.out.println("empty list: " + list + " size: " + list.size());
    	list.add("a");
    	System.out.println("add a: " + list + " size: " + list.size()) ;
    	list.add("b");
    	System.out.println("add b: " + list + " size: " + list.size()) ;
    	list.add("d");
    	System.out.println("add d: " + list + " size: " + list.size()) ;
    	list.add(2,"c");
    	System.out.println("add c at 2 : " + list + " size: " + list.size()) ;

      //get
      System.out.println("element at index 2: " + list.get(2));
      //set
      list.set(2,"b");
      System.out.println("replace element 2 with b: " + list);
      //contains
      System.out.println("list contains \"b\": " + list.contains("b"));
      //indexOf
      System.out.println("first index of b: " + list.indexOf("b"));
      //lastIndexOf
      System.out.println("last index of b: " + list.lastIndexOf("b"));
      //clear
      list.clear();
      System.out.println("list after clearing: " + list);
    }


}
