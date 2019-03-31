import java.io.IOException;

public final class Rational{
  private final int NUM;
  private final int DEN;
  public Rational(){
    NUM = 0;
    DEN = 1;
  }

  public Rational(int n){
    NUM = n;
    DEN = 1;
  }

  public Rational(int n, int d){
    if(d == 0) throw new RuntimeException("DIVISION BY ZERO");
    else{
      if(d < 0){
        n = - n;
        d = Math.abs(d);
      }
      NUM = n / Math.abs(gcd(n,d));
      DEN = d / Math.abs(gcd(n,d));
    }
  }

  private final int gcd(int x, int y){
    if(y == 0) return x;
    return gcd(y,  x % y);
  }

  private final int lcm(int x, int y){
    return x * y / gcd(x, y);
  }

  @Override
  public final String toString(){
    return NUM + "/" + DEN;
  }

  public final int getNum(){
    return NUM;
  }

  public final int getDen(){
    return DEN;
  }

  public final Rational invert(){
    return new Rational(DEN, NUM);
  }

  public final Rational negate(){
    return new Rational(- NUM, DEN);
  }

  public final Rational abs(){
    return new Rational(Math.abs(NUM), DEN);
  }
  public final Rational plus(Rational rhs){
    return new Rational(rhs.getDen() * NUM + rhs.getNum() * DEN, DEN * rhs.getDen());
  }

  public final Rational minus(Rational rhs){
    return new Rational(rhs.getDen() * NUM - rhs.getNum() * DEN, DEN * rhs.getDen());
  }

  public final Rational times(Rational rhs){
    return new Rational(rhs.getNum() * NUM, rhs.getDen() * DEN);
  }

  public final Rational divideBy(Rational rhs){
    return this.times(new Rational(rhs.getDen(), rhs.getNum()));
  }

  @Override
  public final Boolean equals(Rational rhs){
    return NUM == rhs.getNum() && DEN == rhs.getDen();
  }
}
