public class SelectionSort {
  public static void main(String [] args) {
    int[] a = {3,1,5,4,2};
    SelectionSort(a);
    print(a);
  }

  public static void SelectionSort(int [] data){
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

  public static void print(int[] arr){
    System.out.print("[");
    for (int i = 0; i < arr.length; i++){
      System.out.print(arr[i]);
      if(i != arr.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }
}
