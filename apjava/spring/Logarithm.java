// O(log N), halves the number each time
public class Logarithm{
  // pre: n >= 1
  // post: returns the floor of the logarithm base 2 of n.
  public static int log(int n){
    int counter = 0;
    while(n > 1){
      n /= 2;
      counter++;
    }
    return counter;
  }

  public static void main(String[] args){
    for(int i = 1; i < 11; i++)
    System.out.println(log(i));
  }
}
