public class Obengloblish{
  public static String stringAt(String str, int i){
    if (i < 0) return "";
    return Character.toString(str.charAt(i));
  }
  private static String obengloblish(String word){
    String ans = "";

    for(int i = 0; i < word.length(); i++){
      if("aeiou".contains(stringAt(word, i))){
        if (!"aeiou".contains(stringAt(word, i - 1)) && !(i == word.length() - 1 && stringAt(word, word.length() -1).equals("e")))
        ans += "ob" + Character.toString(word.charAt(i));
        else{
          ans += Character.toString(word.charAt(i));
        }
      } else {
      ans += Character.toString(word.charAt(i));
      }
    }
    return ans;
  }
  public static void main(String[] args) {
    System.out.println(obengloblish(args[0]));

  }
}
