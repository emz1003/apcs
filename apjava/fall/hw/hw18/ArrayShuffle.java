import java.util.Scanner;

public class ArrayShuffle{


    public static void main(String [] args){
	new ArrayShuffle().run();
    }

    public void run(){
	Scanner sys = new Scanner(System.in);
	System.out.print("enter size of array: ");
  int size = sys.nextInt();
	// create and name an integer array
	int [] intArray = new int[size];

	// initialize with ints [1,10]
	for (int i = 0; i < intArray.length; i++)
	    intArray[i] = i + 1;
	// Prints the elements: 1 2 ...
	System.out.print("Unshuffled: ");
        printArray(intArray);
	// Shuffle the array
	shuffle(intArray);
	// Prints the shuffled array
	System.out.print("Shuffled:   ");
	printArray(intArray);

    }
    // prints array  element0 element1 ... elementN
  private void printArray(int [] data){
  	for (int i = 0; i < data.length; i++)
  	    System.out.print(data[i]  + " ");
  	System.out.println();
    }
    /*   HOMEWORK
     *  randomly schuffles the array as a side effect
        Each permutation is equally likely.
    */
    private void shuffle(int [] data){
	     for(int i = 0; i < data.length; i++){
         int randIndex = (int) (Math.random() * (data.length - 1));
         int mem = data[i];
         data[i] = data[randIndex];
         data[randIndex] = mem;
       }
    }

}
