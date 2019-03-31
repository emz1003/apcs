public interface OrderItem{

       /** Returns the price of this item. **/
       public double getPrice();

       /** Returns the number of units ordered. **/
       public int getQuantity();

       /** Returns the total cost for this order item. */
       public double getCost();
}
