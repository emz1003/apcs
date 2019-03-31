import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Stats{
  public static void main(String[] args){
    int[] arr = new int[(int)(10 + Math.random() * 10)];
    ArrayList<Integer> list = new ArrayList<Integer>();
    for(int i = 0; i < arr.length; i++){
      arr[i] = (int) (Math.random() * 100);
      list.add((int) (Math.random() * 100));
    }
    System.out.println(mode(list));
  }

  private static double median(int[] arr){
    Arrays.sort(arr);
    if (arr.length % 2 == 0)
      return (double) (arr[arr.length / 2 - 1] + arr[arr.length / 2]) / 2;
    else
      return arr[arr.length / 2];
  }

  private static double median(ArrayList<Integer> list){
    Collections.sort(list);
    if (list.size() % 2 == 0)
      return (double) (list.get(list.size() / 2 - 1) + list.get(list.size() / 2) / 2);
    else
      return list.get(list.size() / 2);
  }

  private static int mode(int[] arr){
    Arrays.sort(arr);
    int ans = arr[0];
    int count = 1, max_count = 1;
    for(int i = 1; i < arr.length; i++){
      if(arr[i] == arr[i - 1])
        count++;
      else if (count > max_count){
        ans = arr[i - 1];
        max_count = count;
        count = 1;
      } else
        count = 1;
    }
    return ans;
  }

  private static int mode(ArrayList<Integer> list){
    Collections.sort(list);
    System.out.println(list);
    int ans = list.get(0);
    int count = 1, max_count = 1;
    for(int i = 1; i < list.size(); i++){
      if(list.get(i) == list.get(i - 1))
        count++;
      else if (count > max_count){
        ans = list.get(i - 1);
        max_count = count;
        count = 1;
      } else
        count = 1;
    }
    return ans;
  }

  private static void print(int[] arr){
    System.out.print("[");
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i]);
      if(i != arr.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }
}
