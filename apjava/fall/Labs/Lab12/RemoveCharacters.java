public class RemoveCharacters{
  public static void main(String[] args) {
    System.out.println(removeCharacters("counterrevolutionaries", "aeiou"));
  }

  private static String removeCharacters(String str, String rm){
    int index = 0;
    while(index < str.length() - 1){
      if (rm.contains(str.substring(index,index + 1))) str = str.replace(str.substring(index,index + 1), "");
      else index++;
    }
    return str;
  }
}
