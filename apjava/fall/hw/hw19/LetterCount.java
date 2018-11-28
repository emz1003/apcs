import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class LetterCount{
  public static void main(String[] args) {
    new LetterCount().run();
  }

  public void run(){
    Scanner sys = new Scanner(System.in);
    System.out.print("Enter file: ");
    String filename = sys.nextLine();
    BufferedReader rd = openFileReader(filename);
    System.out.printf("%-10s%10s%n", "Letter", "Frequency");
    printTable(rd);
  }

  private BufferedReader openFileReader(String filename){
    try{
      return new BufferedReader(new FileReader(filename));
    } catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }

  private void printTable(BufferedReader rd){
    int[] count = new int[26];
    try{
      while(true){
        int ch = rd.read();
        if(ch == -1) break;
        if (Character.isLetter((char) ch)) count[ch % 97]++;
      }
      for(int i = 97; i < 97 + 26; i++){
        System.out.printf("%-10c%10d%n", (char) i, count[i - 97]);
      }

      rd.close();
    }catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }
}
