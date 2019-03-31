public abstract class Sort{
  public abstract void sort(int[] data);
  public void print(int[] arr){
    System.out.print("[");
    for (int i = 0; i < arr.length; i++){
      System.out.print(arr[i]);
      if(i != arr.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }
}
