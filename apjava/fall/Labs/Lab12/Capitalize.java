public class Capitalize{
  public static void main(String[] args) {
    System.out.println(capitalize("BOOLEAN"));
  }

  private static String capitalize(String str){
    String first = str.substring(0,1);
    if (Character.isLetter(str.charAt(0))) first = first.toUpperCase();
    return  first + str.substring(1).toLowerCase();
  }


}
