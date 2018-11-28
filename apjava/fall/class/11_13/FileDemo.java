import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;


public class FileDemo{

  public static void main(String [] args){
	   new FileDemo().run();
  }

  public void run(){
	   BufferedReader rd = openFileReader(new Scanner(System.in),"Enter a file:");
  	//showCharByChar(rd);
  	showLineByLine(rd);
    }

  private void showLineByLine(BufferedReader rd){
  	try{
  	    while (true){
  		String line = rd.readLine();
  		if (line == null) break;
  		System.out.println(line);
  	    }
  	}catch(IOException ex){
  	    throw new RuntimeException(ex.toString());
  	}
  }
  private void showCharByChar(BufferedReader rd){
  	try{
  	    while (true){
  		int ch = rd.read();
  		if (ch == -1) break;
  		System.out.println((char)ch);
  	    }
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
