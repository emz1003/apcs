public class Hw26 {
  public static int max(Node<Integer> p) {
    if (p == null) return 0;
    return Math.max(p.getValue(), max(p.getNext()));
  }

  public static void print(Node<Integer> p){
      System.out.println(p.getValue());
      if (p.getNext() != null) print(p.getNext());
  }

  private static void printR(Node<Integer> p) {
      if(p == null) return;
      printR(p.getNext());
      System.out.println(p.getValue());
  }

  public static int length(Node<Integer> p) {
     if(p == null) return 0;
     return 1 + length(p.getNext());

  public static void main(String[] args) {
    Node<Integer> list = new Node<Integer>(1,new Node<Integer>(2,new Node<Integer>(3,null)));
    print(list);
    System.out.println("max: " + max(list));
    printReverse(list);
    System.out.println("length: " + length(list));
  }
}
