import java.util.Scanner;
public class LetterSubstitution{
  String encodeLetterSubstitution(String key, String str){
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Boolean isUpper;
    String ans = "";
    for (int i = 0; i < str.length(); i++)
    {
      isUpper = Character.isUpperCase(str.charAt(i));
      if (!Character.isLetter(str.charAt(i))) ans += str.charAt(i);
      else{
        if (isUpper) ans += Character.toString(key.charAt(alpha.indexOf(str.charAt(i))));
        else ans += Character.toString(key.charAt(alpha.indexOf(str.charAt(i)))).toLowerCase();
      }
    }
    return ans;
  }

  String decodeLetterSubstitution(String key, String str){
    String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    Boolean isUpper;
    String ans = "";
    for (int i = 0; i < str.length(); i++)
    {
      isUpper = Character.isUpperCase(str.charAt(i));
      if (!Character.isLetter(str.charAt(i))) ans += str.charAt(i);
      else{
        if (isUpper) ans += Character.toString(alpha.charAt(key.indexOf(str.charAt(i))));
        else ans += Character.toString(alpha.charAt(key.indexOf(str.charAt(i)))).toLowerCase();
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner sys = new Scanner(System.in);
    System.out.print("Enter a 26-letter key: ");
    String key = sys.nextLine();
    System.out.print("Enter a message: ");
    String message = sys.nextLine();
    System.out.print("Encoded message: ");
    System.out.println(new LetterSubstitution().encodeLetterSubstitution(key, message));

    Scanner sys = new Scanner(System.in);
    System.out.print("Enter a 26-letter key: ");
    String key = sys.nextLine();
    System.out.print("Enter a message: ");
    String message = sys.nextLine();
    System.out.print("Decoded message: ");
    System.out.println(new LetterSubstitution().decodeLetterSubstitution(key, message));
  }
}
