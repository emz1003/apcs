public class MagicSquare{
  public static void main(String[] args) {
    int[][] arr = {{8,1,6},{3,5,7},{4,9,2}};
    int[][] arr1 = {{16,3,2,13},{5,10,11,8},{9,6,7,12},{4,15,14,1}};
    System.out.println(new MagicSquare().isMagicSquare(arr1));
  }
  boolean isMagicSquare(int [][] square){
    if (square.length != square[0].length) return false;
    int sum = 0;
    for(int i = 0; i < square.length; i++) sum += square[i][i];

    int diasum = sum;
    int rowsum = sum;
    int colsum = sum;

    for(int row = 0; row < square.length; row++)
      for(int col = 0; col < square.length; col++){
        if(row + col == square.length - 1) diasum -= square[row][col];
      }

    if(diasum != 0) return false;

    for(int row = 0; row < square.length; row++){
      rowsum = sum;
      for(int col = 0; col < square.length; col++){
        rowsum -= square[row][col];
      }
    }
    if(rowsum != 0) return false;
    return true;
  }
}
