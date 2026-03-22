import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WordGame {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		String s = new String("qwertyuiopasdfghjklzxcvbnm");
		File filetoread = new File("/Users/mattsun/Desktop/project/Branches/src/words_alpha.txt");
		Scanner p = new Scanner(System.in);
		ArrayList<String> allwords = new ArrayList<String>();

		Scanner everyword = new Scanner(filetoread);

		while (everyword.hasNext()) {
			String temp = everyword.nextLine();
			allwords.add(temp);
		}

		ArrayList<Character> letters = new ArrayList<Character>();

		for (int i = 0; i < 7; i++) {
			char letter = s.charAt((int) (Math.random() * 26));
			while (letters.contains(letter)) {
				letter = s.charAt((int) (Math.random() * 26));
			}
			letters.add(letter);
		}

		ArrayList<String> words = new ArrayList<String>();
		System.out.println("The letters are " + letters);
		System.out.println("The central letter is " + letters.get(0));
		int points = 0;

		while (true) {
			System.out.println("enter a word to start");

			String q = p.nextLine();

			boolean isinsequence = true;
			boolean ispanagram = true;

			for (int i = 0; i < q.length(); i++) {
				if (!letters.contains(q.charAt(i))) {
					isinsequence = false;
				}
			}
			if (q.indexOf(letters.get(0)) == -1) {
				isinsequence = false;
			}

			for (int i = 0; i < letters.size(); i++) {
				if (q.indexOf(letters.get(i)) == -1) {
					ispanagram = false;
				}
			}

			while (!allwords.contains(q) || q.length() <= 3 || words.contains(q) || !isinsequence) {
				isinsequence = true;
				ispanagram = true;

				for (int i = 0; i < q.length(); i++) {
					if (!letters.contains(q.charAt(i))) {
						isinsequence = false;
					}
				}
				if (q.indexOf(letters.get(0)) == -1) {
					isinsequence = false;
				}

				for (int i = 0; i < letters.size(); i++) {
					if (q.indexOf(letters.get(i)) == -1) {
						ispanagram = false;
					}
				}

				if (!allwords.contains(q)) {
					System.out.println("thats not a word");
				} else if (q.length() <= 3) {
					System.out.println("this word is too short");
				} else if (!isinsequence) {
					System.out.println("this word is not in the sequence, or the center letter was not included");
				} else {
					System.out.println("you have already picked this word");
				}

				q = p.nextLine();
			}

			words.add(q);

			int curpoints = q.length() - 3;

			if (ispanagram) {
				curpoints += 7;
			}

			if (!ispanagram) {
				System.out.println(
						"you scored " + curpoints + ((curpoints == 1) ? " point" : " points") + " with this word");
			} else {
				System.out.println("Panagram! you scored " + curpoints + ((curpoints == 1) ? " point" : " points")
						+ " with the panagram");
			}

			points += curpoints;
			System.out.println("you have " + points + ((points == 1) ? " point" : " points") + " right now");

		}

	}

}