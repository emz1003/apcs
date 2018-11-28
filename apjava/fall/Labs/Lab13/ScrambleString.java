public class ScrambleString{
  public static void main(String[] args) {
    for(int i = 0; i < 10; i++)
      System.out.println(scramble("abc"));
  }

  private static String scramble(String str){
    String result = "";
    while(!str.isEmpty()){
      int rand = (int)(Math.random() * str.length());
      String randChar = Character.toString(str.charAt(rand));
      //System.out.println("\nstr: " + str + "\nrandChar: " + randChar);
      for(int i = 0; i < str.length(); i++)
      {
        if (i == rand) {
        result += randChar;
        str = removeChar(str, randChar);
        //System.out.println("removing char: " + randChar);
      }
    }

    }
    return result;
  }

  private static String removeChar(String str, String rm){
    String ans = "";
    int index;
    for(index = 0; index < str.length(); index++){
      String chosenChar = Character.toString(str.charAt(index));
      if (chosenChar.equals(rm)) break;
    }
    return str.substring(0, index) + str.substring(index + 1);
  }
}
