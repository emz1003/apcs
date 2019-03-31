import java.util.Scanner;
public class Hw18{
  public static void main(String[] args){
    //new Hw18().reverse();
    System.out.println(new Hw18().matching("{[()]}"));
  }

  private void reverse(){
    Scanner sc = new Scanner(System.in);
    NodeStack<Integer> stack = new NodeStack<Integer>();
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

  private boolean matching(String str) {
    NodeStack<String> stack = new NodeStack<String>();
    NodeStack<String> aux = new NodeStack<String>();
    for (int i = 0; i < str.length(); i++){
      String item = Character.toString(str.charAt(i));
      if("({[)}]".contains(item))
        stack.push(item);
    }
    System.out.println(stack);

    while(stack.size() > 0){
      System.out.println("stack: " + stack + " aux: " + aux);
      if(!aux.empty()){
      System.out.println("match: " + getMatch(stack.peek()) + " aux peek: " + aux.peek());
      System.out.println(getMatch(stack.peek()).equals(aux.peek()));}

      while (!aux.empty() && !stack.empty() && getMatch(stack.peek()).equals(aux.peek())){
        System.out.println("stack: " + stack + " aux: " + aux);
        aux.pop();
        stack.pop();
      }
      aux.push(stack.pop());
    }
    return aux.empty() && stack.empty();

  }

  private String getMatch(String str){
    switch(str){
      case "(": return ")";
      case "{": return "}";
      case "[": return "]";
    }
    return "";
  }
}
