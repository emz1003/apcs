public class InsertionSort extends Sort{
  @Override
  public void sort(int[] data) {
    for (int i = 1; i < data.length; i++){
      int mem = data[i];
      int j = i;
      while (j > 0 && data[j - 1] > mem) {
        data[j] = data[j - 1];
        j--;
      }
      data[j] = mem;
    }
  }
  public static void main(String [] args) {
    int[] a = {3,1,4,5,2};
    new InsertionSort().sort(a);
    new InsertionSort().print(a);
  }

}
