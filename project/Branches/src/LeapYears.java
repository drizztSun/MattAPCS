import java.util.Scanner;

public class LeapYears {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter year");
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		if (n % 4 == 0) {
			if (n % 100 == 0) {
				if (n % 400 == 0) {
					System.out.println("leap year");
				} else {
					System.out.println("not a leap year");

				}
			} else {
				System.out.println("leap year");
			}
		} else {
			System.out.println("not a leap year");

		}
	}

}
