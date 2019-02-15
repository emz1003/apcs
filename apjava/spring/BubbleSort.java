/*
1. Exam #1 2/15

    Topics

      - Classifying algorithms with big Oh notation.
      - Proofs using the definition of big Oh notation.
      - Search Algorithms : Sequential and Binary
      - Simple In-Place Sorts: Bogo, Bubble, Selection, and Insertion.


2. After reviewing the notes stated below, implement the bubble sort
   algorithm.

============================================================================
 Bubble Sort Algorithm
============================================================================
Assume N elements.

   a. There are exactly N-1 passes through the array.

        pass is within [1,N).


   b. On a pass, i is  within [0, N - pass).
       for each i the following comparison is made:
       	   if data[i] > data[i+1]
	   then swap data[i] and data[i-1].


ex. data = [5,4,3 2,1]
    N = 5
    total passes = 4

    pass #1:
          i within [0,4)

           [4,5,3,2,1]
	   [4,3,5,2,1]
	   [4,3,2,5,1]
	   [4,3,2,1,5]

           * 5 is sorted.

    pass #2:
           i within [0,3)
           [3,4,2,1,5]
	   [3,2,4,1,5]
	   [3,2,1,4,5]

	   * 4 and 5 are sorted.

     pass #3:
           i within [0,2)
	   [2,3,1,4,5]
           [2,1,3,4,5]

	   * 3,4 and 5 are sorted.

     pass #4:
           i within [0,1)
	   [1,2,3,4,5]

	   * all are sorted.

* Upon the completion of a pass, a new element is sorted (final resting place).
    Thus N elements require N-1 passes. If N-1 elements are in place,
    then all N elements are in place.

* On a pass, the number of comparisons made is |[0,N-pass)|.

    N = 5
    # comparisons on pass #1: 4
    # comparisons on pass #2: 3
    # comparisons on pass #3: 2
    # comparisons on pass #4: 1
    Total comparison: 4 + 3 + 2 + 1 = 10

    In general, with N elements there are N(N-1)/2 comparisons.
    Thus O(N*N).

    Note: The summation fromula for 1 + 2 + ... + (n-1) + n.
            S = 1 + 2 + ... + (n-1) + n
	    S = n(n+1)/2



* On a pass, the number of data exchanges is at most |[0,N-pass)|.
  Worst case, a data exchange after each comparison.
  Best case, no data exchanges (the array is already sorted).

  Thus data exchanges are also O(N*N).

* Thus, bubble sort is O(N*N).



Final Thoughts
==============
1. Easy to code.
2. May have a lot of excessive data movement.
3. Can be modified to exit early resulting in O(n) performance.

---------------------------------------------------------------------------
* Exercise : implement the bubble sort.
---------------------------------------------------------------------------
*/
public static void bubbleSort(int [] data) {
  for (int i = 0; i < data.length - 1; i++){
    if (data[i] < data[i + 1]){
      int first = data[i];
      data[i] = data[i + 1];
      data[i + 1] = first;
    }
  }
}
