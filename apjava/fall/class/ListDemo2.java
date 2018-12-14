import java.util.ArrayList;

public class ListDemo2{
  public static void main(String[] args) {
  }

  public int numOccurances(ArrayList<String> list, String x){
    int count = 0;
    for(String s: list)
      if (s.equals(x)) count++;
    return count;
  }

  public ArrayList<String> append(ArrayList<String> list, ArrayList<String> list2){
    for(String s: list2)
      list.add(s);
    return list;
  }

  public void reverse(ArrayList<String> str){
    for(int i = 0; i < str.size() / 2; i++){
      str.set(0,str.set(str.get(str.size() - 1))
    }
  }
}
