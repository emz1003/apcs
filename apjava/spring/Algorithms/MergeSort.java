//Hw09:
/*
1. trace diagram
  5,1,8,4,2,9,3
  5,1,8,4   2,9,3
  5,1 8,4   2   9,3
  1,5 4,8   2   3,9
  1,4,5,8   2,3,9
  1,2,3,4,5,8,9

*/

public class MergeSort{
  // pre: a and b are sorted in ascending order
  // post: returns an array that contains every element of a and b in ascending order NO SIDE EFFECTS ARE PRODUCED
  public static int[] merge(int [] a , int [] b){
     final int N1 = a.length;
     final int N2 = b.length;
     final int N = N1 + N2;
     int[] ans = new int[N];   // O(N) additional space
     int i = 0, j = 0, k = 0;
     // O(N)
     while (k < N){
       if (i >= N1 || j >= N2)
         break; // i,j and k are in-bounds
       if (a[i] < b[j]) ans[k++] = a[i++]; // k index for ans, i index for a, j index for b
       else ans[k++] = b[j++];
      }
      while (i < N1)
        ans[k++] = a[i++];
      while(j < N2)
        ans[k++] = b[j++];
     return ans;
   }


   // pre: data != null
   // post: data is sorted in ascending order in O(NlogN) time and space
   public static void mergeSort(int[] data){
     final int N = data.length;
     int[] aux = new int[N]; // O(N) additional space
     msHelper(data, aux, 0, N); // [0, N)
   }

   // pre: 0 < = lo <= hi <= data.length;
   private static void msHelper (int[] data, int[] aux, int lo, int hi){
     if (hi - lo <= 1) return ;
     int m = lo + (hi = lo) / 2;
     msHelper(data, aux, lo, m);
     msHelper(data, aux, lo, hi);
     merge( data, aux, lo, m , hi);
   }

   // pre: data != null
   // 0 <= lo <= m <= hi <= data.length
   // elements within [lo, m) and [m, hi) are sorted
   // post: elements withing [lo, hi) are sorted in O(N) time
   public static void merge(int[] data, int[] aux, int lo, int m , int hi){
     // step 1: copy elements within the region [lo, hi) from data into aux
     // step 2: merge the copied elements from aux back into data

     for (int i = lo; i < hi; i++){
       aux[i] = data[i];
     }

     int c1 = lo , c2 = m , c3 = lo;
     while ( c1 < m && c2 < hi ){
       if (aux[c1] <= aux[c2]])
        data[c3++] = aux[c1++];
      else data[c3++] = aux[c2++];

     }

     while(c1 < m) data[c3++] = aux(c1++);
     while(c2 < hi) data[c3++] = aux(c2++);  
   }

  public static void main(String[] args){
    int[] a = {4,6,9,8,11};
    mergeSort(a);
    print(a);
  }

  public static void print(int[] arr){
    System.out.print("[");
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i]);
      if(i != arr.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }
}
