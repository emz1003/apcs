public class BiasedCoin extends Coin{
  private double prob;

  public BiasedCoin(double prob){
    this.prob = prob;
  }

  @Override
  public String flip(){
    if(Math.random() < prob) return "H";
    return "T";
  }
}
