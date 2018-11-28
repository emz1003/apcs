public class Scrabble{
  public static void main(String[] args) {
    System.out.println(getPoints("ABaZ.")); //should be 14
  }

  private static int getPoints(String str){
    String c;
    String one = "AEILNORSTU";
    String two = "DG";
    String three = "BCMP";
    String four = "FHVWY";
    String five = "K";
    String eight = "JX";
    String ten = "QZ";
    int points = 0;
    while(true){
      c = str.substring(0,1);
      if(one.contains(c)) points += 1;
      else if(two.contains(c)) points += 2;
      else if(three.contains(c)) points += 3;
      else if(four.contains(c)) points += 4;
      else if(five.contains(c)) points += 5;
      else if(eight.contains(c)) points += 8;
      else if(ten.contains(c)) points += 10;
      if (str.length() == 1) return points;
      str = str.substring(1);
    }
  }
}
