public class Client{
  public static void main(String[] args){
    new Client().run();
  }

  public void run(){
    Coin a = new Coin();
    System.out.println("coin: " + a.flip());
    Flippable b = new BiasedCoin(0.2);
    System.out.println("biased coin: " + b.flip());
  }
}
