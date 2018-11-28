import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Censor{
  public static void main(String[] args) {
    new Censor().run();
  }

  public void run(){
    Scanner sys = new Scanner(System.in);
    System.out.print("Enter filename: ");
    String fileName = sys.nextLine();
    System.out.print("Enter letters: ");
    String seq = sys.nextLine();
    BufferedReader rd = openFileReader(fileName);
    String newFileName = censor(fileName.substring(0,fileName.indexOf(".")), seq) + fileName.substring(fileName.indexOf("."));
    PrintWriter wr = openFileWriter(newFileName);
    try{
      while(true){
        String line = rd.readLine();
        if(line == null) break;
        System.out.println(line);
        wr.println(censor(line, seq));
      }
      rd.close();
      wr.close();
    } catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }
  private String censor(String line, String seq){
    for(int i = 0; i < seq.length(); i++){
      line = line.replace(Character.toString(seq.charAt(i)).toUpperCase(), "");
      line = line.replace(Character.toString(seq.charAt(i)).toLowerCase(), "");
    }
    return line;
  }

  private BufferedReader openFileReader(String fileName){
    try{
      return new BufferedReader(new FileReader(fileName));
    } catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }

  private PrintWriter openFileWriter(String fileName){
    try{
      return new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
    } catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }
}
