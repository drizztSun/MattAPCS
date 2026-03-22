
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProjects {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		ArrayList<String> twowords = new ArrayList<String>();
		ArrayList<String> sevenwords = new ArrayList<String>();
		File filetoread = new File("/Users/mattsun/Desktop/project/Branches/src/words.txt"); 
		Scanner s = new Scanner(filetoread); 
		String buff = "";
		PrintWriter newwords = new PrintWriter("/Users/mattsun/Desktop/project/Branches/src/twoletterwords.txt"); 
		PrintWriter sevenlwords = new PrintWriter("/Users/mattsun/Desktop/project/Branches/src/sevenletterwords.txt"); 
		while (s.hasNext()) { 
			buff = s.nextLine();
			if(buff.length() == 2) {
				newwords.println(buff);
				twowords.add(buff);
			}
			if(buff.length() == 7) {
				sevenlwords.println(buff);
				sevenwords.add(buff);
			}
		}
		
		s.close(); 
		newwords.close(); 
		
	}

}
