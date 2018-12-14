import java.io.IOException;
public class MinesweeperMethods{
  public static void main(String[] args){
    boolean [][] arr = {{true, false, false, false, false, true},
                        {false, false, false, false, false, true},
                        {true, true, false, true, false, true},
                        {true, false, false, false, false, false},
                        {false, false, true, false, false, false},
                        {false, false, false, false, false, false}};
    new MinesweeperMethods().run(arr);
  }

  public void run(boolean[][] arr){
    int[][] mineCounts = countMines(arr);
    printMatrix(mineCounts);
  }

  private int[][] countMines(boolean[][] mines){
    int[][] count = new int[mines.length][mines[0].length];
    int ans = 0;
    for(int row = 0; row < mines.length; row++){
      for(int col = 0; col < mines[0].length; col ++){
        if(mines[row][col]){
          for(int i  = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
              if ((row + i < mines.length) && (row + i >= 0) && (col + j < mines[0].length) && (col + j >= 0)){
                count[row + i][col + j]++;
              }
            }
          }
        }
      }
    }
    return count;
  }

  private void printMatrix(int [] [] m){
  for (int row = 0 ; row < m.length; row++){
      for (int col = 0; col < m[row].length; col++){
        System.out.printf("%10d" , m[row][col] );
      }
      System.out.println();
  }
}
}
