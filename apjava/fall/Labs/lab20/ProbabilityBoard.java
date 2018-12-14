// Emily Zhang and Thomas Creighton
public class ProbabilityBoard{
  public static void main(String[] args) {
    new ProbabilityBoard().run();
  }

  public void run(){
    System.out.printf("%-10s%10s%n", "Channels", "Marbles");
    int[] channels = new int[10];;
    for(int i = 0; i < 50; i++){
      int channel = 0;
      for(int peg = 0; peg < 9; peg++){
        if(Math.round(Math.random()) == 1) channel++;
      }
      channels[channel]++;
    }

    for(int i = 0; i < channels.length; i++){
      System.out.printf("%-10d",i);
      for(int channel = 0; channel < channels[i]; channel++){
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
