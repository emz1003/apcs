import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class CWL{
  public static void main(String[] args) {
    new CWL().run();
  }

  public void run(){
    BufferedReader rd = openFileReader(new Scanner(System.in), "Enter file: ");
    countCWL(rd);
  }

  private void countCWL(BufferedReader rd){
    try{
      int c = 0;
      int w = 0;
      int l = 0;
      boolean isWhite = true;
      while(true){
        int ch = rd.read();
        if(ch == -1) break;
        c++;
        if(Character.isWhitespace((char) ch)) {
          if(!isWhite) w++;
          isWhite = true;
        } else isWhite = false;

        if(Character.toString((char) ch).equals("\n")) l++;
      }
      System.out.printf("chars: %10d\nwords: %10d\nlines: %10d\n",c,w,l);
    } catch(IOException ex) {
      throw new RuntimeException(ex.toString());
    }
  }

  private BufferedReader openFileReader(Scanner sys, String prompt){
    BufferedReader rd = null;
    while(rd == null){
      try{
        System.out.print(prompt);
        String name = sys.nextLine();
        rd = new BufferedReader(new FileReader(name));
      } catch(IOException ex){
        System.out.println("Can't open that file");
      }
    }
    return rd;
  }
}
