public class BakersDozen extends BagelsOrderItem{
  public BakersDozen(double price){
    super(price, 13);
  }

  @Override
  public double getCost(){
    return 12 * getPrice();
  }

}
