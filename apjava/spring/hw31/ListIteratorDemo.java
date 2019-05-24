import java.util.List;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.LinkedList;

public class ListIteratorDemo {

	public static void main(String[] args) {
		List<String> L = new LinkedList<String>();
		L.add("hat");
		L.add("cat");
		L.add("bat");

		System.out.println("The list: " + L);

		ListIterator<String> itr = L.listIterator();
		// IMPORTANT YOU ARE NOT TO DECLARE ANY VARIABLES IN THE CODE BELOW

		// *************** Exercise 1 **************************************
		// Use an iterator to print each item in the list
		// hat
		// cat
		// bat
		System.out.println("Print the values in order.");

		// YOUR CODE GOES HERE
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		// *************** Exercise 2 **************************************
		// Use the same iterator to print:
		// bat
		// cat
		// hat
		System.out.println("Print the values in reverse order.");

		// YOUR CODE GOES HERE
		while(itr.hasPrevious())
			System.out.println(itr.previous());

		// *************** Exercise 3 **************************************
		// Use the iterator to print both the index position and the value
		// 0 hat
		// 1 cat
		// 2 bat
		System.out.println("Print the index and  values in order.");

		// YOUR CODE GOES HERE
		for(int i = 0; itr.hasNext(); i++) {
			System.out.println(i + " " + itr.next());
		}

		// *************** Exercise 4 **************************************
		// Use an iterator to print the previous index and the previous value
		// 2 bat
		// 1 cat
		// 0 hat
		System.out.println("Print the index and  values in reverse order.");

		// YOUR CODE GOES HERE
		for(int i = L.size() - 1; itr.hasPrevious(); i--){
			System.out.println(i + " " + itr.previous());
		}

		// *************** Exercise 5 **************************************
		// Use an iterator to replace cat with dog
		System.out.println("replace cat with dog");

		// YOUR CODE GOES HERE
		while(itr.hasNext()) {
			if(itr.next().equals("cat")) {
				itr.remove();
				itr.add("dog");
			}
		}

		System.out.println("The list: " + L);

	}
}
