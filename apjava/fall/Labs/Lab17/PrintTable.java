import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class PrintTable{
  public static void main(String[] args) {
    new PrintTable().run();
  }

  public void run(){
    try{
      BufferedReader rd = new BufferedReader(new FileReader("states.txt"));
      BufferedReader rd2 = new BufferedReader(new FileReader("abbrev.txt"));
      BufferedReader rd3 = new BufferedReader(new FileReader("codes.txt"));
      System.out.printf("%-20s | %15s | %15s%n", "State", "Abbreviation", "Code");
      for(int i = 0; i <= 54; i++) System.out.print("-");
      System.out.println("-");
      while(true){
        String state = rd.readLine();
        String abbrev = rd2.readLine();
        String codes = rd3.readLine();
        if (state == null && abbrev == null && codes == null) break;
        Scanner scanner = new Scanner(codes);
        int code = scanner.nextInt();
        System.out.printf("%-20s | %15s | %15d%n", state, abbrev, code);

      }
    } catch(IOException ex){
        throw new RuntimeException(ex.toString());
    }
  }
}
