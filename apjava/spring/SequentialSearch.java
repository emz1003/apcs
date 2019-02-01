public class SequentialSearch{

  public static boolean contains(int[] data, int x , int from, int to){
    for (int i = from; i < to; i++){
      if(data[i] == x){
        return true;
      }
    }
    return false;
  }
}
