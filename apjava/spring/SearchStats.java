public class SearchStats{
  public static void main(String[] args) {
    new SearchStats().run();
  }

  private void run(){
    System.out.println("     N   | Sequential | Binary    ");
    System.out.println("----------------------------------");
    for(int i = 1; i < 6; i++){
      boolean isHalved = false;
      Stopwatch sw = new Stopwatch();
      Stopwatch bw = new Stopwatch();
      int[] data = new int[n];
      int k = 0;
      for(int j = 0; j < n; j++){
        data[j] = k;
        if (k >= n) break;
        else k++;
      }

      int key = (int) (Math.random() * Math.pow(10, i));
      System.out.println("key: " + key);
      System.out.println("data length" + data.length);
      sw.start();
      SequentialSearchII.sequentialSearch(data, key);
      sw.stop();
      bw.start();
      BinarySearchAlgorithm.binarySearch(data, key, 0, (int) (Math.pow(10, i) - 1));
      bw.stop();
      System.out.printf("%-10d|%10f|%10f%n", (int) Math.pow(10, i), sw.elapsedTime() * .001, bw.elapsedTime() * .001);
    }
  }
}
