import java.util.ArrayList;

public class Josephus{

  public static<E> MyQueue<E> buildQueue(ArrayList<E> players){
  	  MyQueue<E> ans = new ArrayQueue<E>(players.size());
    for (E player : players)
        ans.add(player);
    return ans;
  }

  // Pre: k > 0
  // Post: Uses a round robin scheduler to determine
  //       the winner.
  public static<E> E josephus(MyQueue<E> q, int k){
    int i = 1;
    while(q.size() != 1) {
      System.out.println(q);
      if (i % (k + 1) == 0 && i != 0) {
        System.out.println("Remove: " + q.poll());
      }
      else
        q.add(q.poll());
      i++;
    }
    return q.poll();
  }

  public static void main(String[] args){
    ArrayList<String> list = new ArrayList<String>();
    String[] arr = {"Bobby", "Sue", "Amy", "Mark", "Danny", "Kelly", "Yuki"};
    for(String i: arr){
      list.add(i);
    }
    System.out.println(list);
    System.out.println("Winner: " + josephus(buildQueue(list), 2));
  }

  public static<E> E josephus(MyQueue<E> q, int k){
    while(q.size() > 1) {
      for(int i = 0; i < k; i++) {
        q.add(q.remove())
      }
      System.out.println("Remove: " + q.remove();
    }
    return p.remove();
  }
 }
