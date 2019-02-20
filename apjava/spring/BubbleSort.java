public class BubbleSort extends Sort{
  public static void main(String[] args) {
    int[] a = {3,1,5,4,2};
    new BubbleSort().sort(a);
    new BubbleSort().print(a);
  }

  @Override
  public void sort(int [] data) {
    final int N = data.length;
    // N-1 passes
    for (int pass = 1; pass < N; pass++){
        for (int i = 0; i < N - pass; i++){
          if (data[i] > data[i+1]){
            int temp = data[i];
            data[i] = data[i+1];
            data[i+1] = temp;
          }
        }
    }
  }
}
