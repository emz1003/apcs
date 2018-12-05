public class HadamardMatrix{
  public static void main(String[] args) {
    new HadamardMatrix().run(Integer.parseInt(args[0]));
  }

  public void run(int n){
    boolean [][] h1 = new boolean[n][n];
    h1[0][0] = true;
    for(int h = 1; h < n; h *= 2){
      for(int row = 0; row < n - 1; row++){
        for(int col = 0; col < n - 1; col++){
          if(row < h && col < h){
            h1[row][col + h] = h1[row][col];
            h1[row + h][col] = h1[row][col];
            h1[row + h][col + h] = !h1[row][col];
          }
        }
      }
    }
    printMatrix(h1);
  }

  private void printMatrix(boolean [] [] m){
    for (int row = 0 ; row < m.length; row++){
        for (int col = 0; col < m[row].length; col++){
      System.out.printf("%10b" , m[row][col] );
        }
        System.out.println();
    }
  }
}
