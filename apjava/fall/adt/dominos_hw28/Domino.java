public final class Domino{
  private int LHS = 0;
  private int RHS = 0;

  public Domino(){
    LHS = 0;
    RHS = 0;
  }

  public Domino(int lhs, int rhs){
    LHS = lhs;
    RHS = rhs;
  }

  public final int getLeftDots(){
    return LHS;
  }
  public final int getRightDots(){
    return RHS;
  }

  @Override
  public final String toString(){
    String str = "\n*****************\n";
    for(int row = 0; row < 3; row++){
      for(int i = 0; i < 17; i++){
        if(i % 8 == 0) str += "*";
        else if(LHS == 1 && row == 1 && i == 4) str += "o";
        else if(LHS == 2 && ((row == 0 && i == 2) || (row == 2 && i == 6))) str += "o";
        else if(LHS == 3 && ((row == 0 && i == 2) || (row == 1 && i == 4) || row == 2 && i == 6))str += "o";
        else if(LHS == 4 && (i == 2 || i == 6) && (row == 0 || row == 2)) str += "o";
        else if(LHS == 5 && (((i == 2 || i == 6) && (row == 0 || row == 2)) || (row == 1 && i == 4))) str += "o";
        else if(LHS == 6 && (row == 0 || row == 2) && i < 8 && i % 2 == 0) str += "o";

        else if(RHS == 1 && row == 1 && i == 12) str += "o";
        else if(RHS == 2 && ((row == 0 && i == 10) || (row == 2 && i == 14))) str += "o";
        else if(RHS == 3 && ((row == 0 && i == 10) || (row == 1 && i == 12) || row == 2 && i == 14))str += "o";
        else if(RHS == 4 && (i == 10 || i == 14) && (row == 0 || row == 2)) str += "o";
        else if(RHS == 5 && (((i == 10 || i == 14) && (row == 0 || row == 2)) || (row == 1 && i == 12))) str += "o";
        else if(RHS == 6 && (row == 0 || row == 2)) str += "o";
        else str += " ";
      }
      str += "\n";
    }
    return str + "*****************\n";
  }
}
