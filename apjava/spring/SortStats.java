public class SortStats{
  public static void main(String[] args){
    Sort[] s = {new BubbleSort(), new BubbleShort(), new InsertionSort(), new SelectionSort()};
    String[] str = {"Bubble sort", "Bubble short", "Insertion sort", "Selection sort"};
    for(int i = 0; i < 4; i++){
      run(str[i], s[i]);
    }
  }

  private static void run(String name, Sort alg){
    System.out.println(name);
    System.out.println("          N   |          Time(sec)");
    System.out.println("----------------------------------");
    Stopwatch sw = new Stopwatch();
    for(int i = 1; i < 6; i++){
      int[] data = new int[(int) Math.pow(10, i)];
      int k = (int) Math.pow(10,i);
      for(int j = 0; j < Math.pow(10,i); j++){
        data[j] = k;
        k--;
      }
      sw.start();
      alg.sort(data);
      sw.stop();
      System.out.printf("%-10d   |%10f%n", (int) Math.pow(10, i), sw.elapsedTime() * 0.001);
    }
  }
}
