import java.util.Scanner;
public class Hw18_1{
  public static void main(String[] args){
    new Hw18_1().reverse();
  }

  private void reverse(){
    Scanner sc = new Scanner(System.in);
    ArrayStack<Integer> stack = new ArrayStack<Integer>(100);
    System.out.println("Enter a list of integers, ending with 0:");
    System.out.print("? ");
    int n = sc.nextInt();
    while(n != 0){
      stack.push((Integer) n);
      System.out.print("? ");
      n = sc.nextInt();
    }
    System.out.println("Those integers in reverse order are:");
    int N = stack.size();
    for(int i = 0; i < N; i++){
      System.out.println(stack.pop());
    }
  }
}
