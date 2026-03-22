import java.util.Scanner;
public class Project4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//running total
		System.out.print("enter a number");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int count  = 0;
		while(n != 1) {
			if(count % 15 == 0) {
				System.out.print("\n");
			}
			System.out.print(n + " ");
			if(n % 2 == 0) {
				n /=2;
			}else {
				n = (n*3)+1;
			}
			count++;
		}
		
		
		System.out.println(n);
	}

}