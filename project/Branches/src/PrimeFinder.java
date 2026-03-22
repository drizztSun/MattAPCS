import java.util.Scanner;
import java.util.ArrayList;

public class PrimeFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final long maxv = 1000000;
		ArrayList<Integer> silve = new ArrayList();
		
		for(long i = 0; i<=maxv; i++) {
			silve.add(0);
		}
		
		silve.set(1, 1);
		
		for(long i = 1; i<=maxv; i++) {
			if(silve.get((int) (i)) == 1) {
				continue;
			}
			for(long j = i*2; j<=maxv; j+=i) {
				silve.set((int) (j), 1);
			}
			
			
		}
		
		
		
		
		
		System.out.println("choose a number");
		
		Scanner kboard = new Scanner(System.in);
		
		int p = kboard.nextInt();
		
		System.out.println("the primes less than " + p + " are:");
		
		for(int i = 1; i<=p; i++) {
			if(silve.get(i) == 0) {
				System.out.print(i+", ");
			}
		}
		
		
		
	}

}
