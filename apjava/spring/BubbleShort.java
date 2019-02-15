public class BubbleShort{
  public static void main(String[] args) {
    int[] a = {3,1,5,4,2};
    BubbleShort(a);
    print(a);
  }

  public static void BubbleShort(int[] data){
    final int N = data.length;
    boolean isExchanged = false;
    // N-1 passes
    for (int pass = 1; pass < N; pass++){
        // i in [0,N-pass) => N(N-1)/2 comparisons
      for (int i = 0; i < N - pass; i++){
        if (data[i] > data[i+1]){
          int temp = data[i];
          data[i] = data[i+1];
          data[i+1] = temp;
          isExchanged = true;
        }
      }
      if (!isExchanged) break;
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
