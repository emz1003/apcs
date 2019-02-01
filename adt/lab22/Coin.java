public class Coin implements Flippable{
  @Override
  public String flip(){
    if(Math.random() < .5) return "H";
    return "T";
  }
}
