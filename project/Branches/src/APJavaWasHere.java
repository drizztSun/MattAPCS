import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class APJavaWasHere {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File filetoread = new File("/Users/mattsun/Desktop/project/Branches/src/essay.txt");
		Scanner s = new Scanner(filetoread);
		String v = new String();
		ArrayList<String> p = new ArrayList<String>();

		while (s.hasNext()) {
			v = s.nextLine();
			p.add(v);
		}
		
		
		PrintWriter apcs = new PrintWriter("/Users/mattsun/Desktop/project/Branches/src/essay.txt");
		for(String k : p) {
			apcs.println(k);
		}
		
		apcs.println("Apcs java was here");


		s.close();
		apcs.close();

	}

}
