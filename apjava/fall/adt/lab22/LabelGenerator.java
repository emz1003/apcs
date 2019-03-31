public class LabelGenerator{
  private final String NAME;
  private int start;

  public LabelGenerator(String name, int start){
    NAME = name;
    this.start = start;
  }

  public String nextLabel(){
    String ans = NAME + start;
    start++;
    return ans;
  }
}
