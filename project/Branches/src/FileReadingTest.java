
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileReadingTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ArrayList<String> people = new ArrayList<String>();
		File filetoread = new File("/home/mattsun/project/names.txt"); // names.txt must be located in the project
		Scanner inp = new Scanner(filetoread); // folder of the active project – refresh if needed
		String buffer = "";
		PrintWriter newwords = new PrintWriter("/home/mattsun/project/lowercasenames.txt"); // lowercase.txt will be added
		while (inp.hasNext()) { // to the same classes folder
			buffer = inp.nextLine(); // you may need to refresh to see it
			people.add(buffer);
			newwords.println(buffer.toLowerCase());
		}
		System.out.println(people);
		inp.close(); // it is critical to close these files
		newwords.close(); // when you are done with them

	}
}
