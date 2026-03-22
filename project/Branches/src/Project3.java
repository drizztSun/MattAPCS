import java.util.Scanner;
public class Project3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//running total
		System.out.println("enter numbers");
		Scanner s = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			int cur = s.nextInt();
			sum += cur;
			if(cur == 0) {
				break;
			}
		}
		
		
		System.out.println("total:" + sum);
	}

}
