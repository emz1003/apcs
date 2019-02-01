import java.util.ArrayList;
import java.util.List;

public class MapDemo{

  public static void main(String [] args){
	   new MapDemo().run();
  }

  public void run(){
  	// List is a JAVA interface.
  	// View its API:
  	//     https://docs.oracle.com/javase/8/docs/api/java/util/List.html
  	// The class ArrayList implements the List Interface.
  	List <Integer> list = new ArrayList<Integer>();
  	for (int i = 0; i < 10; i++)
  	 list.add((int)(Math.random() * 10));

  	System.out.println("Before: " + list);
  	list = map(new Half(), list);
  	System.out.println("After : " + list);
  }

  // Pre: f represents a unary function
  // Post: Returns a new list by applying f to each
  //       element of list. NO SIDE EFFECTS ARE PRODUCED.
  private List<Integer> map(Function f, List<Integer> list){
	   ArrayList<Integer> newList = new ArrayList<Integer>();
     for(int i : list)
      newList.add(f.evaluate(i));
	   return newList;
  }

}
