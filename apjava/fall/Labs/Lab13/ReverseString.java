public class ReverseString{
  public static void main(String[] args) {
    System.out.println(reverse("reverse"));
    System.out.println(reverseR("reverse"));
  }

  private static String reverse(String str){
    String sub = "";
    for(int i = str.length() - 1; i >= 0; i--){
      sub += Character.toString(str.charAt(i));
      str = str.substring(0, str.length() - 1);
    }
    return sub;
  }

  private static String reverseR(String str){
    if (str.length() == 1) return str;
    return Character.toString(str.charAt(str.length() - 1)) + reverseR(str.substring(0, str.length() - 1));
  }
}
