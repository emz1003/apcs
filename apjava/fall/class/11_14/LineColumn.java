import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class LineColumn{

  public static void main(String[] args) {
    new LineColumn().run();
  }

  public void run(){
    BufferedReader rd = openFR(new Scanner(System.in), "Enter a file: ");
    lineColumn(rd);
  }

  private void lineColumn(BufferedReader rd){
    try{
      Scanner sys = new Scanner(System.in);
      System.out.print("Enter sequence: ");
      String str = sys.nextLine();
      System.out.print(str + "\t\t\t");
      int i = 0;
      while(true){
        String line = rd.readLine();
        i++;
        if (line.contains(str)) System.out.println(i + ":" + line.indexOf(str));
        if (line == null) break;
      }
    }catch(IOException ex) {
      throw new RuntimeException(ex.toString());
    }
  }

  private BufferedReader openFR(Scanner sys, String str){
    BufferedReader rd = null;
    while (rd == null){
     try {
       System.out.print (str);
       String name = sys.nextLine();
       rd = new BufferedReader(new FileReader(name));
     } catch(IOException ex){
       System.out.println("Can't open that file.");
       }
     }
   return rd;
  }
}
