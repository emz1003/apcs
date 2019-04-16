public class Example{
public static void roll(NodeStack <String> NodeStack, int n, int k) {
       //make a new NodeStack to push the reordered elements together
      if (n < 0 || k < 0 || n > NodeStack.size()) throw new RuntimeException("roll: argument out of range");
	     for (int j = 0; j < k; j++) {
  	      NodeStack <String> scramble = new NodeStack <String> ();
          NodeStack <String> scramble2 = new NodeStack <String> ();
          String top = NodeStack.pop();
  	      for (int i = 0; i < n-1; i++)
  	        scramble.push(NodeStack.pop());
          System.out.println(NodeStack);
          for (int a = 0; a <= scramble.size(); a++)
            scramble2.push(scramble.pop());
	        NodeStack <String> new1 = new NodeStack <String> ();
          for (int m = 0; m <= scramble2.size(); m++){
              new1.push(scramble2.pop());
            }
          new1.push(top);
          System.out.println(new1);
          for(int l = 0; l <= new1.size(); l++){
            NodeStack.push(new1.pop());
          }
          System.out.println(NodeStack);
          System.out.println();
	       }
    }
    public static void main (String [] args) {
       NodeStack <String> test = new NodeStack <String> ();
       test.push("A");
       test.push("B");
       test.push("C");
       test.push("D");
       roll(test,3,2);
       System.out.println(test.toString());
    }
}
