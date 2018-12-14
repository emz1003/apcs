//Emily Zhang and Claire Tempelman
  // TO RUN: run and give the number of "coins" to test binomial distribution
public class BinomialCoefficients{
  public static void main(String[] args) {
    double[][] ans = new BinomialCoefficients().binomialCoefficients(Integer.parseInt(args[0]));
    new BinomialCoefficients().printJagged(ans);
  }

// Output: a ragged array with the probabilities of getting column heads in row coins
  private double[][] binomialCoefficients(int x){
    double[][] a = new double[x][];
    for(int i = 0; i < x; i++){
      a[i] = new double[i + 1];
      a[i][0] = 0;
    }
    a[1][1] = 1.0;
    for(int n = 2; n < a.length; n++)
      for(int k = 1; k < a[n].length; k++){
        if(n == k) a[n][k] = a[n][1];
        else a[n][k] = (a[n-1][k] + a[n-1][k-1]) / 2.0;
      }
    return a;
  }

  private void printJagged(double[][] ans){
    for(double[] row: ans){
      for(double col: row)
        System.out.printf("%10f", col);
      System.out.println();
    }
  }
}
