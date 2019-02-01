public class DominoClient{
  public static void main(String[] args) {
    for(int l = 0; l < 6; l++)
      for(int r = 0; r <= l; r++)
        System.out.println(l + "-" + r + new Domino(l,r));
  }
}
