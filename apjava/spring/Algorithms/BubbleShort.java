public class BubbleShort extends Sort{
  public static void main(String[] args) {
    int[] a = {3,1,5,4,2};
    new BubbleShort().sort(a);
    new BubbleShort().print(a);
  }

  @Override
  public void sort(int[] data){
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
}
