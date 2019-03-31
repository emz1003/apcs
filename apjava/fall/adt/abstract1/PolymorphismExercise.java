import java.util.ArrayList;
public class PolymorphismExercise{
  public static void main(String[] args) {
    Rectangle rect = new Rectangle(1,2);
    RtTriangle tri = new RtTriangle(3,4);
    ArrayList<Shape> list = new ArrayList<Shape>();
    list.add(rect);
    list.add(tri);
    for(Shape sh : list){
    if(sh instanceof Resizable){
      ((Resizable) sh).resize(.5);
    }
      System.out.println("area: " + sh.getArea());
      System.out.println("perim: " + sh.getPerimeter());
    }
  }
}
