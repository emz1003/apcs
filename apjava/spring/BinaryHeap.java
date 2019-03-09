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

    public static void heapify(int [] data, int i){
      int left = 2 * i + 1;
      int right = left + 1;
      if(left < data.length && data[left] > data[i] && (right >= data.length || data[left] > data[right])) {
        swap(data, left, i);
        if (left <= data.length / 2 - 1)
          heapify(data, left);
      }

      if(right < data.length && data[right] > data[i] && data[right] > data[left]){
        swap(data, right, i);
        heapify(data, right);
      }
      if (i > 0)
        heapify(data, i - 1);
    }

      public static void buildHeap(int[] data){
        // starts with last parent: data.length / 2 - 1
        heapify(data, data.length / 2 - 1);

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

         int[] notHeap1 = {5,2,8,7,3,4,6,5};
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
