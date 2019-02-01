public class Point{
  private int  row,  col;

  // sets row to newRow, col to newCol
  public Point(int row, int col){
  	  row = row;
	  col = col;
  }
  public int getRow(){
        return  row;
  }

  public int getCol(){
        return  col;
  }

  public String toString(){
        return "row = " + getRow() + "\tcol= " + getCol();
  }
}
