public class Client{
  public static void main(String[] args) {
    Interface1 t1 = new R();
    R t2 = (R)t1;
    System.out.println(t1.f(1));
    System.out.println(t2.f(1));
    System.out.println(t1.g(1));
    System.out.println(t2.g(1));
    System.out.println(t1.toString());
    System.out.println(t2.toString());
  }
}
