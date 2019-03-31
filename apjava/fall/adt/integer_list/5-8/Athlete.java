public class Athlete implements Trainable{
  private final String FIRST;
  private final String LAST;
  private double HOURS;
  public Athlete(String first, String last){
    FIRST = first;
    LAST = last;
    HOURS = 0;
  }

  public double getHoursTrained(){
    return HOURS;
  }

  public void train(double hours){
    HOURS += hours;
  }

  @Override
  public String toString(){
    return FIRST + " " + LAST + " trained " + HOURS + " hours.";
  }
}
