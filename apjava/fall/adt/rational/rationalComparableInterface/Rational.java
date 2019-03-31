import java.util.ArrayList;
import java.util.Collections;

// Immutable ADT Rational represents a rational number (n/d).
// - it is a final class which prevents any class from subclassing it.

public final class Rational implements Comparable<Rational>{

    // instance varriables (fields) CONSTANTS
    private final int NUM; // numerator
    private final int DEN; // denominator

    // Constructors
    // Default Constructor
    public Rational(){
	this(0,1);       // must be the first statemet
    }
    // Constructor
    public Rational(int n){
	this(n,1);
    }
    // Constructor
    public Rational(int n, int d){
	if (d == 0) throw new RuntimeException("DIVISION BY ZERO");
	if (n == 0) {
	    // this() ;   // call to this must be the first statement
	    NUM = 0;
	    DEN = 1;
	}
	else{
	    // n is not zero
	    int sign = Math.abs(n)/n * Math.abs(d) / d;
	    n = Math.abs(n);
	    d = Math.abs(d);
	    NUM = sign *  n / gcd(n,d);
	    DEN =  d / gcd(n,d);
	}
    }
    public Rational plus (Rational rhs){
	return new Rational(NUM*rhs.DEN + rhs.NUM * DEN, DEN * rhs.DEN);
    }

    public Rational minus (Rational rhs){
	return new Rational(NUM*rhs.DEN - rhs.NUM * DEN, DEN * rhs.DEN);
    }

    public Rational times(Rational rhs){
	return new Rational(NUM*rhs.NUM, DEN * rhs.DEN);
    }

    public Rational divideBy(Rational rhs){
	return new Rational(NUM*rhs.DEN, DEN * rhs.NUM);
    }

    public Double toDouble(){
	return new Double(NUM * 1.0 / DEN);
    }
    private int gcd(int x ,  int y){
	int r  = x % y;
	while (r != 0){
	    x = y;
	    y = r;
	    r = x % y;
	}
	return y;
    }

    @Override
    public String toString(){
	return NUM + "/" + DEN;
    }

    public int compareTo(Rational rhs){
      return (int) this.toDouble().compareTo(rhs.toDouble())
    }

    public static void main(String [] args){
	Rational x = new Rational(5,15);
	Rational y = new Rational(20,-4);

	System.out.println(x + " + " + y + " = " + x.plus(y));
	System.out.println(x + " - " + y + " = " + x.minus(y));
	System.out.println(x + " * " + y + " = " + x.times(y));
	System.out.println(x + " / " + y + " = " + x.divideBy(y));

	ArrayList<Rational> rats = new ArrayList<Rational>();
	for (int i = 0 ; i < 2 ; i++){
	    int n = 1 + (int) (Math.random() * 10);
	    int d = 1 + (int) (Math.random() * 10);
	    rats.add(new Rational(n,d));
	}

	System.out.println("rats: " + rats);
	Rational ans = new Rational();
	for (Rational r : rats){
	    System.out.println(r + " :  "  + ans);
	    ans = ans.plus(r);
	}
	System.out.println("sum of " + rats + " = " + ans);

	Rational s = rats.get(0);
	Rational t = s.times(new Rational(1,1));
        System.out.println(rats + " contains " + s + " " + rats.contains(s));
	System.out.println(rats + " contains " + t + " " + rats.contains(t));

	// approximate e
	Rational e = new Rational();
	int N = 30;
	int factorial = 1;
	for (int i = 0; i < N; i++){
	    System.out.printf("%-5d %-20s %4.8f\n", i , e , e.toDouble());
	    factorial *= (i > 0) ? i : 1;
	    e = e.plus(new Rational(1, factorial));
	}

   }
}
