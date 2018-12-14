/*
  Constructor:
         new ArrayList<E>()

 Methods

  int     size()              : returns the length of the list
  boolean isEmpty()           : returns true if empty
  E       get(int i)          : returns the element at index i
  E       set(int i,E val)    : places val at index i and
                                returns the replaced val
  boolean add(E val)          : adds to the end
  void    add(int i, E val)   : inserts val at i
  E       remove(int i)          : returns and removes the element at i
  boolean remove(E val)       : removes the first occurrence if found
                                returns true if val is removed
  void    clear()             : removes all elements
  boolean contains(E val)     : returns true if list contains val
  int     indexOf(E val)      : returns the first index of val or -1
                                if not found
  int     lastIndexOf(E val)  : returns the last index of val or -1

 */


import java.util.ArrayList;

public class ListDemoII{

    public static void main(String [] args){
	       new ListDemoII().run();
    }

    public void run(){
    	ArrayList<String> list1 = new ArrayList<String>();
    	ArrayList<String> list2 = new ArrayList<String>();
    	String s = "abacadefg";
    	for (int i = 0; i < s.length(); i++){
    	    if (i % 2 == 0) list1.add(s.substring(i,i+1));
    	    else list2.add(s.substring(i,i+1));
    	}
    	System.out.println("list 1: " + list1);
    	System.out.println("list 2: " + list2);
    	// Test numOccurrences
    	System.out.println("a occurs " + numOccurrences(list1,"a") + " times in " + list1);
    	// Test append
    	System.out.println("append(" + list1 + ", " + list2 + "): " + append(list1,list2));
    	System.out.println("append(" + list2 + ", " + list1 + "): " + append(list2,list1));
    	// Test reverse
    	System.out.println ("before reversing: " + list1);
    	reverse(list1);
    	System.out.println ("after reversing: " + list1);
    	reverse(list1);
      System.out.println("is sorted: " + isSorted(list1));

      System.out.println("removed a: " + removeAll("a",list1));
      System.out.println("slice 1 to 4 by 2: " + slice(list1, 1, 4, 2));
      System.out.println("merge lists: " + merge(list1,list2));
      removeAll(list1, "e");
      System.out.println("list1 without e: " + list1);
    }


    private int numOccurrences(ArrayList<String> list, String x){
    	int ans = 0;
    	for (String a : list)
    	    if (a.equals(x)) ans++;
    	return ans;
    }
     // Pre:   list1 and list2 are lists.
     // Post:  Returns a new list by appending the elements of list2 to the
     //        end of list1. NO SIDE EFFECTS ARE PRODUCED.
    private ArrayList<String> append(ArrayList<String> list1, ArrayList<String> list2){
    	ArrayList<String> ans = new ArrayList<String>();
    	for (String x: list1)
    	    ans.add(x);
    	for (String x : list2)
    	    ans.add(x);
    	return ans;
    }
     // Pre:  list != null
     // Post: Reverses the order of the elments of list
    private void reverse(ArrayList<String> list){
      for(int i = 0; i < list.size() / 2; i++){
        list.set(i, list.set(list.size() - i - 1, list.get(i)));
      }
        System.out.println(list);
    }


    //  ********************** PROBLEM #1 ********************************************
    // Pre: list != null
    // Post: returns true if list is sorted in increasing order; false otherwise
    //       isSorted([a,a,b,c]) -> true
    //       isSorted([c,b,a,a]) -> false
    private boolean isSorted(ArrayList<String> list){
      String saved = "";
      for(String s: list){
        if(s.compareTo(saved) > 0 || s.compareTo(saved) == 0 || saved.equals(""))
          saved = s;
        else return false;
      }
	    return true;
    }

    //  ********************** PROBLEM #2 ********************************************
    // Pre: list != null
    // Post : Returns a new list by removing all occurrences of x from list.
    private ArrayList<String> removeAll(String x, ArrayList<String> list){
      ArrayList<String> copy = new ArrayList<String>();
      for(String s : list) copy.add(s);
      while(copy.contains(x)) copy.remove(x);
	       return copy;
    }

    //  ********************** PROBLEM #3 ********************************************
    //  Pre: list != null, from <= to, step > 0
    //  Post: returns a new list that contains the elements from list starting
    //        at index from up to but not including the element at index to.
    //       slice([a,b,c], 0,1,1) -> [a]
    //       slice([a,b,c], 0,2,1) -> [a, b]
    //       silce([a,b,c,d,e], 1, 5, 2) -> [b,d]
    private ArrayList<String> slice(ArrayList<String> list, int from , int to, int step){
      ArrayList<String> another = new ArrayList<String>();
      for(int i = from; i < to; i += step){
        another.add(list.get(i));
      }
      return another;
    }

    //  ********************** PROBLEM #4 ********************************************
    // Pre: list1 and list2 are both sorted in increasing order
    // Post: returns a new sorted list, in increasing order, by merging
    //       list1 and list2. NO SIDE EFFECTS ARE PRODUCED.
    private ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2){
      ArrayList<String> list = new ArrayList<String>();
      for(String s: list1){
        for(String t: list2){
          if(t.compareTo(s) == -1){
            list.add(t);
            break;
          }
        }
        list.add(s);
      }
      return list;
    }



    //  ********************** PROBLEM #5 ********************************************
    // Pre: list != null
    // Post: Produces the side effect that all occurrences of x are removed from list.
    private void removeAll(ArrayList<String> list, String x) {
      while(list.contains(x)) list.remove(x);
    }
}
