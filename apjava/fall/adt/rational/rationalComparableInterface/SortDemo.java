import java.util.ArrayList;
import java.util.Collections;

public class SortDemo{

    public static void main(String [] args){
	new SortDemo().run();
    }


    public void run(){
	// Sorting Integers
	ArrayList<Integer> ints = new ArrayList<Integer>();
	ints.add(5); ints.add(1); ints.add(3);
	System.out.println("Before sorting: " + ints);
	Collections.sort(ints);
	System.out.println("After sorting: "  + ints);
	// Sorting Doubles
	ArrayList<Double> floats = new ArrayList<Double>();
	floats.add(5.1); floats.add(0.1); floats.add(3.2);
	System.out.println("Before sorting: " + floats);
	Collections.sort(floats);
	System.out.println("After sorting: "  + floats);
	// Sorting Rationals
	/*
	ArrayList<Rational> rats = new ArrayList<Rational>();
	rats.add(new Rational(5,1)); rats.add(new Rational(1,10));
	rats.add(new Rational(3,2));
	System.out.println("Before sorting: " + rats);
	Collections.sort(rats);
	System.out.println("After sorting: "  + rats);
	*/
  }

}
