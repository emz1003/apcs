public class Searches {
  // Implement a sequential search to complete the following task.
  // precondition: data is a sequence of unordered integers
  //               from >= 0 and from <= to, to <= data.length
  // postcondition: returns true if x is found within the region [from,to)
  //                of data; false otherwise.
  public static boolean contains(int[] data, int x , int from, int to){
    for (int i = from; i < to; i++){
      if(data[i] == x){
        return true;
      }
    }
    return false;
  }
    /*
a. If data.length = N, what is the least # of comparisons that can be made?
   When does this event occur?
   1 comparisons, when from equals to.


b. If data.length = N, what is the most # of comparisons that may occur? Under what conditions
   does this event happen?
   2N + 1 comparisons, when from is zero and to is N.


*/


  public static void print(int[] data){
  	for (int x : data)
  	    System.out.print(x + " ");
  	System.out.println();
  }
    // precondition : n is > 0, from >= 0, from <= to.
    // postcondition : returns a random sequence as an array.
    //                 data[i] is a random integer and
    //                 from <= data[i] < to
  public static int[] randomData(int n, int from , int to){
  	int [] data = new int[n];
  	for (int i = 0; i < n; i++)
  	    data[i] = (int) (Math.random() * (to-from)) + from;
  	return data;
  }

  public static void main(String [] args){
  	int [] data = randomData(10,0,10);
  	int trials = 20;
  	for (int i = 0; i < trials; i++){
  	    int x = (int) (Math.random() * 10);
  	    int from = (int) (Math.random() * data.length);
  	    int to  = (int) (Math.random() * (data.length - from)) + from;
  	    print(data);
  	    System.out.println(x + " within in " + "[" + from + ", " + to + ") " +  contains(data,x,from,to));
  	}
  }
}
