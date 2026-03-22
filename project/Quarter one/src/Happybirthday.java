import java.util.Scanner;

public class Happybirthday {
	public static void sing(String name) {
		System.out.println("Happy Birthday to you");
		System.out.println("Happy Birthday to you");
		System.out.println("Happy Birthday dear");
		System.out.print(name);
		System.out.println("Happy Birthday to you");
	}
	
	public static void main(String[] args) {
		System.out.println("Whose birthday is it?");
		
		Scanner kboard = new Scanner(System.in);
		
		String person = kboard.nextLine();
		
		sing(person);
	}
}
