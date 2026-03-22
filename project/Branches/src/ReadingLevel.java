import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReadingLevel {
	
	public static int CountWords(String s) {
		int curss = 0;
		int n = s.length();

		for (int i = 0; i < n;) {
			char c = s.charAt(i);
			while (i < n && s.charAt(i) == ' ') {
				i++;
			}
			c = s.charAt(i);
			while (i < n && c != ' ') {
				c = s.charAt(i);
				i++;
			}
			curss++;
		}
		
		return curss;
		
	}
	
	public static int CountSentences(String s) {
		int cursents = 0;
		int n = s.length();
		String cur = new String();
		for(int i = 0; i<n; i++) {
			cur = ""+s.charAt(i);
			boolean hassymbol = (cur.indexOf('.') != -1 || cur.indexOf('!') != -1 || cur.indexOf('?') != -1);
			if (hassymbol) {
				cursents++;
			}
		}
		
		return cursents;
	}
	
	public static String clean(String s) {
		String res = new String();
		String p = "abcdefghijklmnopqrstuvwxyz";
		
		for(int i = 0; i<s.length(); i++) {
			if(p.indexOf(s.charAt(i)) != -1) {
				res += s.charAt(i);
			}
		}
		
		return res;
	}
	
	public static int countSyllables(String s) {
		int totalsyllables = 0;
		String[] words = s.split("\\s+");
		for(String word : words) {
			totalsyllables += countSyllablesHelper(word);
		}
		
		return totalsyllables;
	}
	
	public static int countSyllablesHelper(String s) {
        String cleaned = clean(s);//remove any unnessecary variables

        if (cleaned.isEmpty()) {
            return 0;
        }

        int count = 0;
        boolean lastVowel = false;
        String vowels = "aeiouy";
        char[] sc = cleaned.toCharArray()
;        
        for (char c : sc) {
            if (vowels.indexOf(c) != -1) {

                if (!lastVowel) {
                    count++;
                    lastVowel = true;
                }
            } else {
                lastVowel = false;
            }
        }
        if (cleaned.endsWith("e") && count > 1) {
            count = Math.max(count-1, 1);
        }

        return count;
    }

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		File filetoread = new File("/Users/mattsun/Desktop/project/Branches/src/example.txt");
		Scanner s = new Scanner(filetoread);
		String buff = "";
		double tperiods = 0;
		double twords = 0;
		double tsyllables = 0;

		while (s.hasNext()) {
			buff = s.nextLine();
			tperiods += CountSentences(buff);
			twords += CountWords(buff);
			tsyllables += countSyllables(buff);
		}
		
		double FI = 206.835-(84.6*(tsyllables/twords))-(1.015*(twords/tperiods));
		
		int index = 8;
		
		if(91.0<=FI) {
			index = 0;
		}
		if(81.0<=FI && FI<=90.0) {
			index = 1;
		}
		if(71.0<=FI && FI<=80.0) {
			index = 2;
		}
		if(66.0<=FI && FI<=70.0) {
			index = 3;
		}
		if(61.0<=FI && FI<=65.0) {
			index = 4;
		}
		if(51.0<=FI && FI<=60.0) {
			index = 5;
		}
		if(31.0<=FI && FI<=50.0) {
			index = 6;
		}
		if(0.0<=FI && FI<=30.0) {
			index = 7;
		}
		
		String[] levels = {"5th grade", "6th grade", "7th grade", "8th grade", "9th grade", "High School", "College Student", "College Graduate", "I dont know"};
		
		System.out.println("This text's reading level is " + levels[index] + " level.");
				
	}

}
