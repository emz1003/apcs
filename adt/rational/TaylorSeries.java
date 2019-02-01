public class TaylorSeries{
  public static void main(String[] args) {
    new TaylorSeries().run();
  }

  public void run(){
    Rational sum = new Rational(1,1);
    for(int i = 1; i < 9; i++){
      sum = sum.plus(new Rational(1,factorial(i)));
    }
    System.out.println(sum);
    System.out.println((double) sum.getNum() / sum.getDen());
  }

  private int factorial(int x){
    int f = x;
    while(x > 1){
      f *= --x;
    }
    return f;
  }
}
