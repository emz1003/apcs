import java.util.ArrayList;
public class IntegerList extends ArrayList<Integer>{
  public IntegerList(int ... x){
    for(int i : x)
      this.add(i);
  }


}
