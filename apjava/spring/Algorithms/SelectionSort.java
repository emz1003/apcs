public class SelectionSort extends Sort {
  public static void main(String [] args) {
    int[] a = {3,1,5,4,2};
    new SelectionSort().sort(a);
    new SelectionSort().print(a);
  }

  public void sort(int [] data){
    for (int i = 0; i < data.length; i++) {
      int min = Integer.MAX_VALUE;
      int minIndex = -1;
      for (int j = i; j < data.length; j++){
        if (data[j] < min) {
          min = data[j];
          minIndex = j;
        }
      }
      data[minIndex] = data[i];
      data[i] = min;
    }
  }
}
