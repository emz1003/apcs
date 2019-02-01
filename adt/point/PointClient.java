import java.util.ArrayList;
public class PointClient{
  public static void main(String[] args) {
    new PointClient().run();
  }

  public void run(){
    ArrayList<Point> list = randomPoints(5,0,5);
    System.out.println("random list: " + list);
    for(int i = 0; i < list.size(); i++)
      list.get(i).translate(1,-1);
    System.out.println("translated list: " + list);

    for(int i = 0; i < 5; i++)
      list.add(new Point());
    list.get(0).translate(1,-1); // first point changes
    System.out.println("#3 result: " + list); // list length = 10
    System.out.println("list length: " + list.size()); // 10 point objects are contained

    System.out.println(distance(new Point(0,3), new Point(4,0)));
  }

  public static ArrayList<Point> randomPoints(int n, int from, int to){
    ArrayList<Point> randList = new ArrayList<Point>();
    for(int i = 0; i < n; i++){
      int x = (int) (Math.random() * (to - from) + from);
      int y = (int) (Math.random() * (to - from) + from);
      randList.add(new Point(x,y));
    }
    return randList;
  }

  public static double distance(Point a, Point b){
    return Math.sqrt((a.getY() - b.getY())*(a.getY() - b.getY()) + (a.getX() - b.getX())*(a.getX() - b.getX()));
  }
}
