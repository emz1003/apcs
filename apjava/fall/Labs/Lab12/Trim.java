public class Trim{
  public static void main(String[] args) {
    System.out.println(trim("\t\nHello world        "));

  }

  private static String trim(String str){
    while (Character.isWhitespace(str.charAt(0))) str = str.substring(1);
    while (Character.isWhitespace(str.charAt(str.length() - 1))) str = str.substring(0, str.length() - 1);
    return str;
  }

}
