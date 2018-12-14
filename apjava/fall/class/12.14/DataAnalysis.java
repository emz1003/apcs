 import java.util.ArrayList;

public class DataAnalysis{

    public static void main(String [] args){
	     new DataAnalysis().run();
    }

    public void run(){
    	ArrayList<Integer> data = new ArrayList<Integer> ();
    	data.add(3);
    	data.add(5);
    	data.add(9);
    	data.add(10);
    	data.add(12);
    	data.add(11);
    	data.add(9);
    	data.add(4);
    	System.out.println("data : " + data);
    	System.out.println("k = 4 " + isMode(data,4));
    	System.out.println("k = 5 " + isMode(data,5));
    	System.out.println("mode index " + modeIndex(data));
    	printHistogram(data, 20, "x");
    }

    // precondition: 0 < k < data.size()
    private static boolean isMode(ArrayList<Integer> data, int k){
      for(int i = 1; i < data.size(); i++)
       if(data.get(i) == k)
        return (data.get(i) > data.get(i - 1) && data.get(i) > data.get(i + 1));
      return false;
    }
    // precondition:  data is unimodal and data.size() ≥ 3
    public static int modeIndex(ArrayList<Integer> data){
      for(int i: data)
        if(isMode(data, i)) return i;
      return -1;
    }



    // precondition:  data is unimodal and data.size() ≥ 3;
    //                data.get(k) ≥ 0 for 0 ≤ k < data.size()
   public static void printHistogram(ArrayList<Integer> data, int longestBar, String barChar){
     System.out.printf("%-15s%-15s%-15s%-15s\n","Index k", "data.get(k)", "Length of bar","Output of call");
     int mode = modeIndex(data);
     for(int k = 0; k < data.size(); k++){
        int barLength = (int) Math.round(longestBar * data.get(k) / (double) mode);
        System.out.printf("%3d%18d%14d%10s", k, data.get(k), barLength, "");
        while(barLength != 0){
          System.out.print(barChar);
          barLength--;
        }
        System.out.println();
    }
   }

}
