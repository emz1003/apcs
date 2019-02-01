public class Sorts{
  public boolean isSorted(int[] data){
    // precondition : data != null
    // postcondition: returns true if the elements of data
    //                are increasing (not strictly) from left to right.
    for(int i = 1; i < data.length - 1; i++{
      if (data[i] < data[i - 1]){
        return false;
      }
    }
    return true;
  }
}

/*
b. 1 direct assignment, 2N + 1 comparisons, 2N array offset calculations, N increments
  F(N) = a + b(2N + 1) + 2Nc + Nd
c.e = max(a,b,c,d)
  F(N) <= e(1) + e(2N + 1) + e(2N) + e(N)
  F(N) <= e(5N + 2)

*/
