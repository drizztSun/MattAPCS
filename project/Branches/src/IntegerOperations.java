import java.util.ArrayList;
import java.util.Scanner;

public class IntegerOperations {

	@SuppressWarnings("unchecked")
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
		
		ArrayList<Integer> primes = new ArrayList();
		
		for(int i = 1; i<=maxv; i++) {
			if(silve.get(i) == 0) {
				primes.add(i);
			}
		}
		
		
		
		
		
		System.out.println("choose a number");
		
		Scanner kboard = new Scanner(System.in);
		
		int p = kboard.nextInt();
		
		int sum = 0;
		
		for(int i = 1; i<=p; i++) {
			 sum += i*i;
		}
		
		System.out.println("the usm of the squares of the first " + p + " numbers is: " + sum);
		
		
		System.out.print("the factors of "+p+ " are:");
		for(int i = 1; i<=p; i++) {
			if(p % i == 0) {
				System.out.print(i + ((i == p) ? "" : ", "));
			}
		}
		
		System.out.println();
		
		
		System.out.print("the prime factorization of "+p+ " is:");
		int i = 0;
		while(i < primes.size() && p > 1) {
			while( p % (primes.get(i)) == 0) {
				System.out.print(primes.get(i)+((p/primes.get(i) == 1) ? "" : "*"));
				p /= primes.get(i);
			}
			i++;
		}
		
		
		
		
	}

}
