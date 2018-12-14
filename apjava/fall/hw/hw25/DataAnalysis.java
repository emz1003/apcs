import java.util.ArrayList;

public class DataAnalysis{
  public static void main(String[] args) {
    int[] arr = {1,2,3,4,5,4,4,3,5,5,5}; // mode should be 5
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i: arr)
      list.add(i);
    System.out.println(isMode(list, 7));
    System.out.println(modeIndex(list));
    printHistogram(list, 20, "*");
  }

  // precondition: 0 < k < data.size()
	public static boolean isMode(ArrayList<Integer> data, int k){
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
