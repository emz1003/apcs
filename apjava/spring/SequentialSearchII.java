public class SequentialSearchII{
  // precondition : data != null
  // postcondition: returns the index position of the first occurrence
  //                of x in data; -1 if not found.
  public static int sequentialSearch(int [] data, int x){
    Stopwatch sw = new Stopwatch();
    sw.start();
    for(int i = 0; i < data.length; i++){
      if(data[i] == x){
        sw.stop();
        System.out.println("seq inside time: " + sw.elapsedTime());
        return i;
      }
    }
    return -1;
  }
  /*
    2N + 1 comparisons, N + 1 assignments
    F(N = a(2N + 1) + b(N + 1)
  */
}
