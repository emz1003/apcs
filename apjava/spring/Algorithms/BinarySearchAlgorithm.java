import java.util.Arrays;

/*
3. Write a program to run experiments to verify the performance of
   the recursive binary search on a sorted array.

   Will the stack frame height overflow? Why or why not?
   it would not overflow because the part of the data being examined is halved each time, and is a very fast calculation method.


4. Implement an iterative version of the binary search algorithm.
   Run experiments to ensure that it works and it is O(logN).

5. Write a modified recursive binary search method that returns
   the minimum index of the key. In other words, the if the key
   occurs  multiple times in the array, the index returned is the
   minimum index.  Your implementation must be O(logN).

   // pre: data is sorted in ascending order.
   //      Search within the region [lo,hi).
   // post: returns -1 if key not found
   //       returns the minimum index of key
   public static int binarySearchModified(int[] data, int key, int lo, int hi){}
*/

public class BinarySearchAlgorithm {
  public static int[] makeData(int lo, int hi, int n){
        int [] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans [i] = (int) (Math.random() * (hi - lo) ) + lo;
        return ans;
    }

    public static void print(int [] array){
        for (int x : array)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String [] args){
        int lo = Integer.parseInt(args[0]);
        int hi = Integer.parseInt(args[1]);
        final int N = Integer.parseInt(args[2]);
        int [] data = makeData(lo, hi, N);
        print(data);
        Arrays.sort(data);
        print(data);
        System.out.println("key: " + data[N - 1]);
        for (int i = 0; i < 1000; i++) {
          System.out.println(binarySearch(data, data[N - 1], lo, hi));
          print(data);
        }
    }

    public static int binarySearch (int[] data, int key, int lo, int hi) {
      if(lo >= hi) return -1;
      int m = lo + (hi - lo) / 2;
      if (data[m] == key) return m;
      if(key < data[m]) return binarySearch (data, key, lo, m);
      return binarySearch(data, key, m + 1, hi);
    }

    public static int iterativeBinarySearch (int[] data, int key, int lo, int hi) {
      int m = -1;
      for (int i = 0; i < data.length; i++){
        if( lo >= hi ) break;
        m = lo + (hi - lo) / 2;
        if (data[m] == key) break;
        if (key < data[m]) hi = m;
        else lo = m + 1;
      }
      return m;
    }

    public static int binarySearchModified(int[] data, int key, int lo, int hi){
      if(lo >= hi) return -1;
      int m = lo + (hi - lo) / 2;
      if (data[m] == key) {
        while (data[m - 1] == key)
          m--;
        return m;
      }
      if(key < data[m]) return binarySearch (data, key, lo, m);
      return binarySearch(data, key, m + 1, hi);
    }


    public static int iterativeBinarySearchII (int[] data, int key, int lo, int hi) {
      while (lo < hi) {
        int m = lo + (hi - lo) / 2;
        if (data[m] == key) return m;
        if ( key < data[m])
          hi = m;
        else
          lo = m + 1;
      }
      return -1;
    }
}
