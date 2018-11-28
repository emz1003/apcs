import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

public class Copy{

  public static void main(String[] args) {
    new Copy().run();
  }

  public void run(){
    BufferedReader rd = openFileReader(new Scanner(System.in), "Enter file name: ");
    PrintWriter wr = openFileWriter(new Scanner(System.in), "Enter name of copy: ");
    //copyFileCharByChar(rd, wr);
    copyFileLineByLine(rd, wr);
    closeFiles(rd,wr);
  }

  private void copyFileLineByLine(BufferedReader rd, PrintWriter wr){
    try{
      while(true){
        String line = rd.readLine();
        if(line == null) break;
        wr.println(line);
      }
    } catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }
  private void copyFileCharByChar(BufferedReader rd, PrintWriter wr){
    try{
      while(true){
        int ch = rd.read();
        if(ch == -1) break;
        wr.write(ch);
      }
    }catch(IOException ex){
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

  private PrintWriter openFileWriter(Scanner sys, String prompt){
    PrintWriter wr = null;
    while(wr == null){
      try{
        System.out.print(prompt);
        String name = sys.nextLine();
        wr = new PrintWriter(new BufferedWriter(new FileWriter(name)));
      } catch(IOException ex){
        System.out.println("Can't write to that file");
      }
    }
    return wr;
  }

  private void closeFiles(BufferedReader rd, PrintWriter wr){
    try{
      rd.close();
      wr.close();
    } catch(IOException ex){
      System.out.println("Can't close file");
    }
  }
}
