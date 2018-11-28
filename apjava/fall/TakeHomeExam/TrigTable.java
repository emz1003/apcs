public class TrigTable{
  public static void main(String[] args) {
    new TrigTable().run();
  }

  public void run(){
    System.out.printf("%6s|%11s|%11s|%n", "theta", "sin(theta)", "cos(theta)");

    for(int i = 0; i <=30; i++){
      if(i == 6 || i == 18 || i == 30) System.out.print("+");
      else System.out.print("-");
    }
    System.out.println();
    double a, sin, cos;
    for(a = -90; a <= 90; a += 15){
      sin = Math.sin(a * Math.PI / 180);
      cos = Math.cos(a * Math.PI / 180);
      System.out.printf("%6d|%11.7f|%11.7f|%n",(int) a, sin, cos);
    }
  }
}
