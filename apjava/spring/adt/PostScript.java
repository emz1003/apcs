//Kaitlyn Lau and Emily Zhang
//Lab#5 Question 1
//3/31/19
import java.util.EmptyStackException;
import java.util.Stack;
public class PostScript {
    public static void roll(Stack <String> stack, int n, int k) {
       //make a new stack to push the reordered elements together
      if (n < 0 || k < 0 || n > stack.size()) throw new RuntimeException("roll: argument out of range");
	     for (int j = 0; j < k; j++) {
  	      Stack <String> scramble = new Stack <String> ();
          Stack <String> scramble2 = new Stack <String> ();
          String top = stack.pop();
  	      for (int i = 0; i < n-1; i++)
  	        scramble.push(stack.pop());
          for (int a = 0; a <= scramble.size(); a++)
            scramble2.push(scramble.pop());
	        Stack <String> new1 = new Stack <String> ();
          for (int m = 0; m <= scramble2.size(); m++){
              new1.push(scramble2.pop());
            }
          new1.push(top);
          while(new1.empty() == false){
            stack.push(new1.pop());
          }
          System.out.println(stack);
	       }
    }
    public static void main (String [] args) {
       Stack <String> test = new Stack <String> ();
       test.push("D");
       test.push("C");
       test.push("B");
       test.push("A");
       roll(test,2,4);
       System.out.println(test.toString());
    }
  }
