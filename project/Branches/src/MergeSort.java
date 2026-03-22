






public class MergeSort {
	
	
	public static int[] mergeinterval(int[] x, int ai, int aj, int bi, int bj) {
		int newa = ai, newb = bi;
		
		int[] res = new int[(aj-ai+1) + (bj-bi+1)];
		int resi = 0;
		while(newa <= aj && newb <= bj) {
			if(x[newa] < x[newb]) {
				res[resi] = x[newa];
				newa++;
			}else {
				res[resi] = x[newb];
				newb++;
			}
			resi++;
		}
		
		while(newa<=aj) {
			res[resi++] = x[newa++];
		}
		while (newb<= bj) {
			res[resi++] = x[newb++];
		}
		
		return res;
	}
	
	public static int[] mergesort(int[] x) {
		
		for(int i = 1; i<x.length; i*=2) {
			for(int j = 0; j<x.length; j+=2*i) {
				if(j+i-1 >= x.length)continue;
				int newj = j+i;
				int newjend = Math.min(x.length-1, newj+i-1);
				int[] newinterval = mergeinterval(x, j, j+i-1, newj, newjend);
				for(int k = j; k <= newjend; k++) {
					x[k] = newinterval[k-j];
				}
			}
		}
		
		return x;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		
		
		mergesort(x);
		
		for(int i : x) {
			System.out.println(i);
		}
	}

}
