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

  public static void main(String[] args){
    int[] a = {4,6,9};
    int[] b = {8,11};
    print(merge(a,b));
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
