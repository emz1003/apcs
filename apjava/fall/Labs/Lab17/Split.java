import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Split{
  public static void main(String[] args) {
    new Split().run(args[0]);
  }

  public void run(String fileName){
    try{
      BufferedReader rd = new BufferedReader(new FileReader(fileName));
      PrintWriter wr = new PrintWriter(new BufferedWriter(new FileWriter("states.txt")));
      PrintWriter wr2 = new PrintWriter(new BufferedWriter(new FileWriter("abbrev.txt")));
      PrintWriter wr3 = new PrintWriter(new BufferedWriter(new FileWriter("codes.txt")));
      while(true){
        String line = rd.readLine();
        if(line == null) break;
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(",");
        wr.println(scanner.next());
        wr2.println(scanner.next());
        wr3.println(scanner.nextInt());
      }
      rd.close();
      wr.close();
      wr2.close();
      wr3.close();
    } catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }
}
