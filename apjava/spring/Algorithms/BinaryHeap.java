public class BinaryHeap{

      public static void print(int [] data){
      	     for (int x :  data)
	     	 System.out.print(x + " ");
             System.out.println();
      }

      // pre: data != null and both i and j are index positions
      // post: the elements data[i] and data[j] are exchanged.
      public static void swap(int [] data, int i, int j){
      	     int temp = data[i];
	     data[i] = data[j];
	     data[j] = temp;
      }

    // Pre: data != null,  0<= i < data.length
    //      the left and right children of the node at
    //      index i are both binary heaps.
    // Post: the binary tree with its root located
    //       at index i has heap property
    //

    public static void heapify(int [] data, int i, int upper){
      int left = 2 * i + 1;
      int right = 2 * i + 2;
      if (left >= upper) return;
      int maxChildPos = left ? right < upper && data[right] > data[left] : right;
      if ( data[i] < data[maxChildPos]){
        swap(data, i, maxChildPos);
        heapify(data, maxChildPos, upper);
      }
    }

      public static void buildHeap(int[] data){
        // starts with last parent: data.length / 2 - 1
        //heapify(data, data.length / 2 - 1);
        final int N = data.length; // Nlog(N)
        for (int i = N / 2 - 1; i >= 0; i--)
          heapify(data, i);
      }

      public static boolean isHeap(int [] data) {
      	    return isHeapHelper(data,0);
      }

      private static boolean isHeapHelper(int[] data, int i) {
          if(data.length == i)
            return true;
          if (i > 0 && data[i] > data[(i - 1) /2])
            return false;
          return isHeapHelper(data, i + 1);

          //O(N)
      }

      public static void heapSort(int[] data){
        final int N = data.length;
        buildHeap(data); // O(N)
        for( int i = 1; i < N, i++){
          swap(data, 0, N - i);
          // heap within [0, N - i]
          // sorted region (N - i, N)
          heapify(data, 0 , N - i);
        }
        // O(log N), no additonal space
      }


       public static void main(String [] args){
         int[] bheap = {5,3,1};
         print(bheap);
         System.out.println(isHeap(bheap) + "\n");

         int[] bheap1 = {5,3,4,1,2,4};
         print(bheap1);
         System.out.println(isHeap(bheap1) + "\n");

         int[] notHeap = {1,3,5};
         print(notHeap);
         heapify(notHeap, 0);
         System.out.println("heapified: ");
         print(notHeap);

         System.out.println();

         int[] notHeap1 = {5,2,1,4,3};

         print(notHeap1);
         heapify(notHeap1, 1);
         System.out.println("heapified: ");
         print(notHeap1);

         System.out.println();

         int[] notHeap2 = {5,7,8,5,3,4,6,2};
         print(notHeap2);
         heapify(notHeap2, 0);
         System.out.println("heapified: ");
         print(notHeap2);

         System.out.println("FINAL TEST");

         buildHeap(notHeap1);
         print(notHeap1);
       }

}
