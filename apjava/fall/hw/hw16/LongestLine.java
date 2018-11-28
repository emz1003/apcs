import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class LongestLine{
  public static void main(String[] args) {
    new LongestLine().run();
  }

  public void run(){
    BufferedReader rd = openFileReader(new Scanner(System.in),"Enter a file: ");
    longestLine(rd);
  }

  private void longestLine(BufferedReader rd){
    try{
      String ans = "";
      while (true){
        String line = rd.readLine();
        if (line == null) break;
        if (line.length() > ans.length()) ans = line;
      }
      System.out.println(ans);
    }catch(IOException ex){
        throw new RuntimeException(ex.toString());
    }
  }

  private BufferedReader openFileReader(Scanner sysin, String prompt){
    BufferedReader rd = null;
    while (rd == null){
      try {
        System.out.print (prompt);
        String name = sysin.nextLine();
        rd = new BufferedReader(new FileReader(name));
      }catch(IOException ex){
        System.out.println("Can't open that file.");
      }
    }
    return rd;
  }
}
