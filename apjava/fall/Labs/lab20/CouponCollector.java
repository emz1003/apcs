// Thomas Creighton and Emily Zhang
public class CouponCollector{
  public static void main(String[] args) {
    new CouponCollector().run(Integer.parseInt(args[0]));
  }

  public void run(int n){
    boolean[] bools = new boolean[n];
    int trials = 0;
    while(true){
      int rand = (int) (Math.random() * n);
      bools[rand] = true;
      boolean all_true = true;
      trials++;
      for(boolean x: bools){
        if(!x){
          all_true = false;
          break;
        }
      }
      if(all_true) break;
    }
    System.out.println(trials);
  }
}
