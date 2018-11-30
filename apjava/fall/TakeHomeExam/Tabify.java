import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
public class Tabify{
    public static void main(String [] args){
	new Tabify().run();
    }
    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in),
					   "Enter a file: ");
	showLineByLine(rd);
    }
    private void showLineByLine(BufferedReader rd ){
	try{
	    PrintWriter wr = new PrintWriter(new BufferedWriter(
								new FileWriter("Tabified.txt")));
	    int count = 0;
	    while (true){
		int ch = rd.read();
		if (ch == -1) break;
		if (ch == 9){
		    for (int c = 0; c < (8 - count); c++){
			wr.print(" ");
		    }
		    count = 0;
		}
		else{
		    char cha = (char) ch;
		    wr.print(cha);
		    count = (count + 1) % 8;
		}
	    }
	    rd.close();
	    wr.close();
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
