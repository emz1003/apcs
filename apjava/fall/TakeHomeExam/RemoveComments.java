import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
public class RemoveComments{
    public static void main(String [] args){
	new RemoveComments().run();
    }
    public void run(){
	BufferedReader rd = openFileReader(new Scanner(System.in),
					   "Enter a file: ");
	removeC(rd);
    }
    private void removeC(BufferedReader rd){
	try{
	    PrintWriter wr = new PrintWriter(new BufferedWriter(
								new FileWriter("CommentFreeFile.java")));
	    String text = "";
	    while (true){
		String line = rd.readLine();
		if (line == null) break;
		if (line.contains("//")) text += line.substring(0, line.indexOf("//")) + "\n";
		else text += line + "\n";
	    }
	    while (text.contains("/*")){
		text = text.substring(0, text.indexOf("/*")) + text.substring(text.indexOf("*/") + 2);
	    }
	    wr.print(text);
	    rd.close();
	    wr.close();
	}catch(IOException ex){
	    throw new RuntimeException(ex.toString());
	}
    }
    private BufferedReader openFileReader(Scanner sysin, String prompt){
	BufferedReader rd = null;
	while (rd == null){
	    try{
		System.out.print(prompt);
		String name = sysin.nextLine();
		rd = new BufferedReader(new FileReader(name));
	    }catch(IOException ex){
		System.out.println("Can't open that file.");
	    }
	}
	return rd;
    }
}
