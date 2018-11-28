import java.util.Scanner;
public class CaesarCipher{
  String encodeCaesarCipher(String str, int shift){
    String key = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String newKey = key;
    String ans = "";
    Boolean isUpper;
    if(shift > 0) newKey = newKey.substring(shift) + newKey.substring(0,shift);
    else if(shift < 0) newKey = newKey.substring(26  + shift) + newKey.substring(0, 26 + shift);


    for(int i = 0; i < str.length(); i++){
      isUpper = Character.isUpperCase(str.charAt(i));
      String chara = Character.toString(str.charAt(i));
      if (!Character.isLetter(str.charAt(i))) ans += chara;
      else{
        chara = chara.toUpperCase();
        if (isUpper) ans += newKey.charAt(key.indexOf(chara));
        else ans += Character.toString(newKey.charAt(key.indexOf(chara))).toLowerCase();
      }
    }

    return ans;
  }
  public static void main(String[] args) {
    Scanner sys = new Scanner(System.in);
    System.out.print("Enter the number of character positions to shift: ");
    int positions = sys.nextInt();
    sys.nextLine();
    System.out.print("Enter a message: ");
    String message = sys.nextLine();
    System.out.print("Encoded message: ");
    System.out.println(new CaesarCipher().encodeCaesarCipher(message, positions));
  }
}
