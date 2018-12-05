public class Primes{
  public static void main(String[] args) {
    new Primes().run(Integer.parseInt(args[0]));
  }
  public void run(int n){
    n = n - 2;
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
      arr[i] = i + 2;
      for(int j = 2; j < n - 1; i++){
        if  (arr[i] % j == 0) arr[i] = -1;
      }
      if(arr[i] != -1) System.out.println(arr[i]);
    }
  }
}
