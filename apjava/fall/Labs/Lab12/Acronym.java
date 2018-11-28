public class Acronym{

  public static void main(String[] args) {
    System.out.println(acronym("-acquired-immune deficiency syndrome"));
  }

  private static String acronym(String str){
    String ans = "";
    for(int i = 0; i < str.length(); i++){
      if (i == 0 && Character.isLetter(str.charAt(i))) ans += str.substring(0,1).toUpperCase();
      if (!Character.isLetter(str.charAt(i))) ans += str.substring(i + 1, i + 2).toUpperCase();
    }
    return ans;
  }
}
