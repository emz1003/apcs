//Emily Zhang and Claire Tempelman

public class CouponCollectorTest{
  public static void main(String[] args) {
    new CouponCollectorTest().validate(Integer.parseInt(args[0]));
  }
  // TO RUN: call validate with the number of trials
  // Output: print out the percent error of the number of trials compared to the one predicted by the harmonic.
  private void validate(int n){
    double harmonic = 0;
    for(int i = 1; i <= n; i++)
      harmonic += 1 / i;
    harmonic *= n;
    int percenterror = (int) Math.abs(Math.round((harmonic - calculateTrials(n)) / harmonic  * 100) / 100);
    System.out.println("Percent error: " + percenterror);
  }

  private double calculateTrials(int n){
    boolean[] bools = new boolean[n];
    int trials = 0;
    boolean all_true = false;
    while(!all_true){
      int rand = (int) (Math.random() * n);
      bools[rand] = true;
      trials++;
      all_true = true;
      for(boolean x: bools)
        if(!x)
          all_true = false;
    }
    return trials;
  }
}
