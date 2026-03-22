import java.util.Scanner;


public class Formulaproject {
	static Scanner k = new Scanner(System.in);
	static boolean deg = false;
	
	public static double[] ambiguous(double a, double b) {
		System.out.println("enter angle");
		double angle = k.nextInt();
		
		if(deg) {
			angle = Math.toRadians(angle);
		}
		
		double cosine = Math.cos(angle);
		
		double coeffB = -2*b*cosine;
		
		double coeffC = b*b-a*a;
		
		double disc = coeffB*coeffB-(4*coeffC);
		
		if(disc < 0) {//nrr
			double[] none = {-1.0, -1.0, -1.0};
			return none;
		}
		if(disc == 0) {//1rr
			double c0 = -coeffB/2;
			double[] res = {0.0, c0, c0};
			return res;
		}
		else {//2rr
			double c1 = (-coeffB+Math.sqrt(disc))/2;
			double c2 = (-coeffB-Math.sqrt(disc))/2;
			double[] res = {1.0, c1, c2};
			return res;
		}
		
	}
	
	
	public static void main(String[] args) {
		

		
		System.out.println("degrees or radians?");
		String s = k.nextLine();
		while(!s.equals("degrees") && !s.equals("radians")) {
			s = k.nextLine();
			System.out.println("what did you say");
		}
		if(s.equals("degrees")) {
			deg = true;
		}
		//law of cosines
		System.out.println("enter length of first side(a)");
		double a = k.nextDouble();
		System.out.println("enter length of second side(b)");
		double b = k.nextDouble();
		
		
		System.out.println("ambiguous case?");
		String amb = k.nextLine();
		amb = k.nextLine();
		
				
		if(amb.equals("yes")) {
			//later
			System.out.println("Which side is opposite to the angle?");
			String side = k.nextLine();
			double[] c;
			if(side.equals("a")) {
				c = ambiguous(a, b);
			}else {
				c = ambiguous(b, a);
			}

			if(c[0] == -1.0) {
				System.out.println("no triangle fits the parameter");
			}
			else if(c[0] == 0.0) {
				System.out.println("the value of c is:" + c[1]);
			}else {
				System.out.println("There are 2 possible triangles.");
				System.out.println("the first value of c is:" + c[1]);
				System.out.println("the second value of c is:" + c[2]);
			}
		 }
		if(amb.equals("no")){
			

			System.out.println("enter angle");
			double angle = k.nextInt();
			
			if(deg) {
				angle = Math.toRadians(angle);
			}
			
			double c = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(angle));
			
			System.out.println("third side is:" + c);
		}


	}

}
