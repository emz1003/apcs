public class SkiJumperClient{
  public static void main(String[] args) {
    SkiJumper ski = new SkiJumper("first", "last");
    System.out.println(ski);
    ski.train(5);
    System.out.println(ski);
    ski.fly();
    System.out.println(ski);
    System.out.println(ski.compareTo(new SkiJumper("f","l")));
  }
}
