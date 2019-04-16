public class Subsets{
  public static void main(String[] args){
    
    int[] arr = {1,2,3,4};
    ArrayQueue<Integer> q = new ArrayQueue<Integer>(arr.length);
    ArrayQueue<Integer> aux = new ArrayQueue<Integer>(arr.length);
    for (int i: arr)
      q.add(i);

    Integer mem = q.peek();
    int occur = -1;

    while(!q.isEmpty()) {
      //System.out.print(aux + " ");
      System.out.println("q: " + q);
      if (q.peek() != mem){
        q.offer(aux.poll());
      } else {
        occur++;
        q.offer(aux.poll());
        aux.add(q.remove());
      }
      for(int i = 0; i < occur; i++)
        aux.add(q.remove());
      System.out.println(aux);
    }
  }
}
