import java.util.Scanner;

public class Project5 {
	public static void main(String[] args) {
		System.out.println("WElcome to nim! enter the number of stones");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		while(n < 10) {
			System.out.println("pick another number; this one is too small");
			n = s.nextInt();
		}

		while (n >= 0) {
			System.out.println("choose number of stones to take");
			int stones = s.nextInt();
			while (stones > 3 || stones <= 0 || stones > n) {
				System.out.println("invalid number of stones, pick again");
				stones = s.nextInt();
			}

			n -= stones;
			if (n > 0) {
					System.out.println(
							stones + ((stones == 1) ? " stone " : " stones ") + "has been taken, " + (n) + " remain.");
			}
			else {
				System.out.println("0 stones remain. you lose");
				return;
			}
			int r = (int) (Math.random() * 3) + 1;
			while(r>n) {
				r = (int) (Math.random() * 3) + 1;
			}
			n -=r;
			if(n>0)System.out.println("bot decides to take " + r + ((r == 1) ? " stone, " : " stones, ") + n + " left");
			else {
				System.out.println("bot decides to take " + r + ((r == 1) ? " stone, " : " stones, ") + "0 stones remain. you win");
				return;
			}
		}
	}
}
