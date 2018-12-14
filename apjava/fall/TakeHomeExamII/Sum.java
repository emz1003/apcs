// Emily Zhang and Claire Tempelman
/* TO RUN:
  -run as is for the sum, which should be 10
  -call the method run() with any number of double parameters inside a print statement
*/
public class Sum{
  public static void main(String[] args) {
    System.out.println(new Sum().run(1.5,1.5,1.2,1.8,4));
  }
// Goal: program takes unspecified amount of parameters of type double and returns the sum
// Pre: d != null
// Post: returns the sum of the elements of d
  public double run(double ... d){
    double sum = 0;
    for(double i: d) sum += i;
    return sum;
  }
}
