import java.util.Scanner;
public class Jigsawpuzzle {

	public static void main(String[] args) {
		//calculates the number and percentage of picecs that are edge piceces
		Scanner k = new Scanner(System.in);
		
		System.out.println("how many pieces tall is the puzzle?");
		int x = k.nextInt();
		System.out.println("how many pieces wide is the puzzle?");
		int y = k.nextInt();
		
		double area = x*y;
		
		double edge = 2*(x+y)-4;
		
		
		double percentage = 100*(edge/area);
		System.out.println("Edge pieces:" + (int) edge + ", percentage of edge pieces:" + percentage + "%");
	}
	

}
