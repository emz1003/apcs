import java.util.ArrayList;

// How to run: $java Substets 3
// Here is code to complete question 2.
// It uses an queue of ArrayLists.
// ArrayLists are AP material.


public class SubsetsV1{



    public static void main(String [] args){
    	ArrayList<Integer> set = new ArrayList<Integer>();
    	final int N = Integer.parseInt(args[0]);
    	// create a list : [ 0, 1, ..., N-1]
    	for(int i = 0; i < N; i++) set.add(i);
    	System.out.println("set: " + set);
    	// Creates a queue of ArrayLists
    	MyQueue<ArrayList> q = new ArrayQueue<ArrayList>((int)(Math.pow(2,set.size())));
    	System.out.println(q);
    	// YOUR CODE GOES HERE

      for(int x: set) {
        for(int n = q.size(); n > 0; n--) {
          ArrayList<Integer> sub = q.remove();
          ArrayList<Integer> newSub = (ArrayList<Integer>) sub.clone();
          newSub.add(x);
          q.add(sub);
          q.add(newSub);
        }
      }
    	// Use a queue to generate all the subsets of a set.
            // In order to make a copy of an ArrayList, use
    	// the method    clone() -> Object.
    	// ex. ArrayList a = q.poll();     a refers to an ArrayList
    	//     ArrayList b = (ArrayList)a.clone();   b refers to a copy of a

    }

}
