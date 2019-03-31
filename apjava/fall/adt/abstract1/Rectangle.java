public class Rectangle extends Shape implements Resizable{
  private double width;
  private double height;

  public Rectangle(double width, double height){
    super(4);
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea(){
    return width * height;
  }

  @Override
  public double getPerimeter(){
    return width * 2 + height * 2;
  }

  @Override
  public void resize(double x){
    width *= x;
    height *= x;
  }
}
