
public class Bubsort {
	
	public static int[] bubsort(int[] x) {
		int nswaps = 1;
		int l = 0;
		while(nswaps > 0) {
			nswaps = 0;
			for(int i = 0; i<x.length-1-l; i++) {
				if(x[i] > x[i+1]) {
					int temp = x[i];
					x[i] = x[i+1];
					x[i+1] = temp;
					nswaps++;
				}
			}
			l++;
		}
		
		return x;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = {3, 8, 6, 2, 7, 5, 9, 1, 4};
		
		int[] newx = bubsort(x);
		
		for(int i : newx) {
			System.out.println(i);
		}
		
	}

}
