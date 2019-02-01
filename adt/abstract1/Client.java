public class Client{
  public static void main(String[] args) {
    Rectangle rect = new Rectangle(2,3);
    RtTriangle rtt = new RtTriangle(3,4);
    System.out.println("rect area: " + rect.getArea());
    System.out.println("rect perim: " + rect.getPerimeter());
    rect.resize(2);
    System.out.println("rect area: " + rect.getArea());
    System.out.println("rect perim: " + rect.getPerimeter());

  }
}
