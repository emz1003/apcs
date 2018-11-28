import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class Cat{

  public static void main(String[] args) {
    new Cat().run(args[0],args[1],args[2]);
  }

  public void run(String in1, String in2, String out){
    BufferedReader rd1 = openFileReader(in1);
    BufferedReader rd2 = openFileReader(in2);
    PrintWriter wr = openFileWriter(out);
    cat(rd1,rd2,wr);
  }

  // preconditon: rd1 and rd2 are open for reading
  //              wr is open for writing
  // postconditon: concatenates the files read from rd1 and rd2 into the file
  //               associated with wr.
  //               All Readers and Writers are closed.
  private void cat(BufferedReader rd1, BufferedReader rd2, PrintWriter wr){
    try{
      while(true){
        String line = rd1.readLine();
        if(line == null) break;
        wr.println(line);
      }
      while(true){
        String line = rd2.readLine();
        if(line == null) break;
        wr.println(line);
      }
      rd1.close();
      rd2.close();
      wr.close();
    } catch (IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }

  private BufferedReader openFileReader(String file){
    try{
      return new BufferedReader(new FileReader(file));
    }catch(IOException ex){
      throw new RuntimeException(ex.toString());
    }
  }

  private PrintWriter openFileWriter(String file){
    try{
      return new PrintWriter(new BufferedWriter(new FileWriter(file)));
    } catch(IOException ex) {
      throw new RuntimeException(ex.toString());
    }
  }
}
