public class FindDNAMatch{
  public static int findDNAMatch(String s1, String s2, int start){
    // translate String
    s1 = s1.substring(start);
    s1 = s1.replace("A", "X").replace("T", "A").replace("X","T").replace("C","X").replace("G","C").replace("X","G");
    return s2.indexOf(s1) + start;
  }

  public static void main(String[] args) {
    System.out.println(findDNAMatch("TTGCC", "TAACGGTACGTC", 3));
  }
}
