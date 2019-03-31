public class QuickSelect{
  private static int partition(int[] data, int lower, int upper) {
    swap(data, (int)(Math.random() * data.length), lower);
    int pivotPos = lower;
    int i = lower;
    int j = upper - 1;
    while (i <= j) {
      while (i <= j && data[i] <= data[pivotPos])
        i++;
      while (j >= i && data[j] >= data[pivotPos])
        j--;
      if (i < j)
        swap(data, i, j);
    }
    swap(data, pivotPos, j);
    return j;
  }
  public static void swap(int[] data, int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
  }

  // precondiion: data != null, 0 < k <= data.length
  // postcondition: returns the kth smallest element in the array.
  //                As a side effect the array may be reordered.
  //                The average runtime is O(N).
  public static int quickSelect(int[] data, int k) {
    int i;
    while(true){
      i = partition(data, 0, data.length);
      if (i == k - 1) return data[i];
    }
  }

  public static int quickSelectR(int[] data, int k) {
    int i = partition(data, 0, data.length);
    if (i == k - 1) return data[i];
    return quickSelectR(data, k);
  }

  public static void main(String[] args){
    int[] arr = {10,9,7,4,2,1};
    System.out.println("10 9 7 4 2 1");
    System.out.println(quickSelectR(arr, 4));
  }
}
/*
5. Finish the proof to show that the average case of the quickselct
   algorithm is linear.

   Assume N elements and the pivot divides the sequence in half after each
   partition.

   Let T(N) represent the number of comparisons made by quickselect algorithm.

   Start with the recurrence relation:

                T(N) = N + T(N/2)
                T(N) = N(1/2^N - 1) * -2
                      < N(-1) * -2
                      < 2N
                      < C(N)
                      => T(N) is O(N);

   Finish the proof.
*/
