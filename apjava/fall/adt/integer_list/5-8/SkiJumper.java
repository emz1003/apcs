public class SkiJumper extends Athlete implements Flier,Comparable<SkiJumper>{
  private int jumps;

  public SkiJumper(String first, String last){
    super(first, last);
    jumps = 0;
  }

  public void fly(){
    jumps++;
  }

  public int getjumps(){
    return jumps;
  }

  @Override
  public String toString(){
    return super.toString() + " jumped " + jumps + " times.";
  }

  @Override
  public int compareTo(SkiJumper rhs){
    return this.jumps - rhs.jumps;
  }

}
