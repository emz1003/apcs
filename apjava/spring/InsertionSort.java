public class InsertionSort{
  public static void insertionSort(int[] data) {
    for (int i = 1; i < data.length; i++){
      if(data[i] <= data[i - 1]) 
      for (int j = 0; j < i; j++){
        int temp = data[i];
        data[i] = data[i - 1];
        data[i - 1] = temp;
      }
    }
  }
  public static void main(String [] args) {
    int[] a = {3,1,5,4,2};
    insertionSort(a);
    print(a);
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
