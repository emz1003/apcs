public class IntegerListClient{

  public static void main(String[] args){
	   new IntegerListClient().run();
  }

  public void run(){
	  IntegerList list1 = new IntegerList(1);
  	IntegerList list2 = new IntegerList(1,2,3,4);

  	System.out.println("list 1: " + list1); // [1]
  	System.out.println("list 2: " + list2); // [1,2,3,4]

  }

}
