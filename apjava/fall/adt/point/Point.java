public class Point extends Object{
  // instance variables
  private int x;
  private int y;

  //default constructor
  public Point(){
    this(0,0);
  }

  //constructor
  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  //overloaded constructor returns other Point
  public Point(Point other){
    this(other.x, other.y);
  }

  //getter methods
  public int getX(){
    return x;
  }

  public int getY(){
    return y;
  }

  // Moves a point to the point (x,y)
  public void move(int x, int y){
    this.x = x;
    this.y = y;
  }

  //Translates a point(x,y) to the location (x + dx, y + dy).
  void translate(int dx, int dy){
    x += dx;
    y += dy;
    // move(x + dx, y + dy);
  }

  // Moves a Point to the location of other
  void setLocation(Point other){
    x = other.x;
    y = other.y;
  }

  // Post: Returns a copy of the Point object by creating a new instance of a Point
  public Point getLocation(){
    return new Point(x,y);
    //return new Point(this);
  }

  //override the toString method
  public String toString(){
    return "(" + x + ", " + y + ")";
  }

}
