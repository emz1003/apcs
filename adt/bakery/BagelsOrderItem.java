// BakersDozen -------> BagelsOrderItem - - - - >  OrderItem
public class BagelsOrderItem implements OrderItem{
  private final double PRICE;
  private final int QUANTITY;
  private final double COST;

  public BagelsOrderItem(double price, int quantity){
    PRICE = price;
    QUANTITY = quantity;
    COST = getCost();
  }

  public double getPrice(){
    return PRICE;
  }

  public int getQuantity(){
    return QUANTITY;
  }
  
  public double getCost(){
    return PRICE * QUANTITY;
  }
}
