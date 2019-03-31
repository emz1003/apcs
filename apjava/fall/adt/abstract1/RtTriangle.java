public class RtTriangle extends Shape{
  private double width;
  private double height;

  public RtTriangle(double width, double height){
    super(3);
    this.width = width;
    this.height = height;
  }

  @Override
  public double getArea(){
    return .5 * width * height;
  }

  @Override
  public double getPerimeter(){
    return width + height + Math.sqrt(width * width + height * height);
  }
}
