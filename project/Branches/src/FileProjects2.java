import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileProjects2 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File filetoread = new File("/Users/mattsun/Desktop/project/Branches/src/essay.txt");
		Scanner s = new Scanner(filetoread);
		String buff = "";
		int periods = 0;
		int words = 0;

		while (s.hasNext()) {
			buff = s.nextLine();
			int curwords = 0;
			int cursentences = 0;
			final int n = buff.length();
			
			for (int i = 0; i < n;) {
				char c = buff.charAt(i);
				while (i < n && buff.charAt(i) == ' ') {
					i++;
				}
				c = buff.charAt(i);
				String cur = new String();
				while (i < n && c != ' ') {
					c = buff.charAt(i);
					cur += c;
					i++;
				}
				curwords++;
				boolean hassymbol = (cur.indexOf('.') != -1 || cur.indexOf('!') != -1 || cur.indexOf('?') != -1);
				if (hassymbol) {
					cursentences++;
				}
			}

			periods += cursentences;
			words += curwords;
		}
		System.out.println("There are " + periods + " sentences in your paper");
		System.out.println("There are " + words + " words in your paper");

		s.close();

	}

}
