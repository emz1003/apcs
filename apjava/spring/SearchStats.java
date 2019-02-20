public class SearchStats{
  public static void main(String[] args) {
    new SearchStats().run();
  }

  private void run(){
    System.out.println("     N   | Sequential | Binary    ");
    System.out.println("----------------------------------");
    int n = 10;
    while (n < Math.pow(10,8)) {
      Stopwatch sw = new Stopwatch();
      Stopwatch bw = new Stopwatch();
      int[] data = new int[n];
      for(int j = 0; j < n; j++){
        data[j] = j;
      }

      int key = (int) (Math.random() * n);
      sw.start();
      SequentialSearchII.sequentialSearch(data, key);
      sw.stop();
      bw.start();
      BinarySearchAlgorithm.binarySearch(data, key, 0, n);
      bw.stop();
      System.out.printf("%-10d|%10f|%10f%n", n, sw.elapsedTime() * .001, bw.elapsedTime() * .001);
      if (Integer.parseInt(Integer.toString(n).substring(0, 1)) == 5) n *= 2;
      else n *= 5;
    }
  }
}
