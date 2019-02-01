import java.util.ArrayList;
public class RationalClient{
  public static void main(String[] args) {
    new RationalClient().run();
  }

  public void run(){
    Rational r = new Rational(0,5);
    Rational r5 = new Rational(5);
    Rational r34 = new Rational(3, - 4);
    System.out.println("r: " + r + "\nr5: " + r5 + "\nr3/4: " + r34);
    System.out.println(r34.plus(r5));
    System.out.println(r5.minus(r34));

    Rational a = new Rational();
    Rational b = new Rational(1,-2);
    Rational c = new Rational(1,4);
    Rational d = new Rational(1,8);
    System.out.println(a.plus(b).plus(c).plus(d));
    System.out.println(a.times(b.plus(c)).minus(d));
    System.out.println(a.plus(b).divideBy(c.plus(d)));

    ArrayList<Rational> rats = new ArrayList<Rational>();
    rats.add(a);
    rats.add(b);
    rats.add(c);
    rats.add(d);
    System.out.println("sum: " + sumList(rats));

    System.out.println(b + " inverted: \t" + b.invert());
    System.out.println(b + " negated: \t" + b.negate());
    System.out.println(b + " absolute value: \t" + b.abs());
    System.out.println(r.equals(a));
    System.out.println(a.equals(b));
  }

  private Rational sumList(ArrayList<Rational> rats){
    Rational sum = new Rational();
    for(Rational i: rats)
      sum = sum.plus(i);
    return sum;
  }
}
