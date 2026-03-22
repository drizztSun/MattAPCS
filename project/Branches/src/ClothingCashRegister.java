import java.util.Scanner;
public class ClothingCashRegister {
	public static void load(int x) throws InterruptedException {
		Thread.sleep(x);
		System.out.print(".");
		Thread.sleep(x);
		System.out.print(".");
		Thread.sleep(x);
		System.out.print(".");
		Thread.sleep(x);
		System.out.print(".");
		Thread.sleep(x);
		System.out.print(".");
		
	}
	
	static double round(double a) {
		double left = a-(int)a;
		if(left > 0.5) {
			return Math.ceil(a);
		}else {
			return Math.floor(a);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("------NN-----------NN-----------------------------------------------------------------------------");
		System.out.println("------NNN----------NN------------OOOOOOOOOOO-----V---------------------V--------------A-----------");
		System.out.println("------NN-N---------NN-----------O-----------O-----V-------------------V--------------A-A----------");
		System.out.println("------NN--N--------NN----------O-------------O-----V-----------------V--------------A---A---------");
		System.out.println("------NN---N-------NN----------O-------------O------V---------------V--------------A-----A--------");
		System.out.println("------NN----N------NN----------O-------------O-------V-------------V--------------A-------A-------");
		System.out.println("------NN-----N-----NN----------O-------------O--------V-----------V--------------AAAAAAAAAAA------");
		System.out.println("------NN------N----NN----------O-------------O---------V---------V--------------A-----------A-----");
		System.out.println("------NN-------N---NN----------O-------------O----------V-------V--------------A-------------A----");
		System.out.println("------NN--------N--NN----------O-------------O-----------V-----V--------------A---------------A---");
		System.out.println("------NN---------N-NN----------O-------------O------------V---V--------------A-----------------A--");
		System.out.println("------NN----------NNN-----------O-----------O--------------V-V--------------A-------------------A-");
		System.out.println("------NN-----------NN------------OOOOOOOOOOO----------------V--------------A---------------------A");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		System.out.println();System.out.println();System.out.println();System.out.println();
		
		System.out.println("Welcome to NOVA! Enter the prices of your clothing($) to calculate total. Enter 0 to stop");
		
		double res = 0;
		double taxtotal = 0;
		Scanner s = new Scanner(System.in);
		
		
		while(true) {
			double cur = s.nextDouble();
			if(cur == 0)break;
			cur *= 100;
			
			if(cur > 17500.0) {
				double over = cur-17500.0;
				
				double tax = over * 0.0625;
				
				tax = round(tax);
				
				taxtotal += tax;
				
			}
			
			res += cur;
			
		}
		res = round(res);
		res /= 100.0;
		taxtotal = round(taxtotal);
		taxtotal /= 100.0;
		
		System.out.println("Your subtotal is " + (int)(res) + " dollars and " + (int)(round((res -  Math.floor(res))*100.0)) + " cents");
		System.out.println("Your tax is " + (int)(taxtotal) + " dollars and " + (int)(round((taxtotal -  Math.floor(taxtotal))*100.0)) + " cents");
		res += taxtotal;
		System.out.println("Your total is " + (int)(res) + " dollars and " + (int)(round((res -  Math.floor(res))*100.0)) + " cents");
		System.out.println("thank you for visiting! This program will end in 5 seconds");
		load(1000);
		
		
		System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();System.out.println();
		
		
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("------NN-----------NN-----------------------------------------------------------------------------");
		System.out.println("------NNN----------NN------------OOOOOOOOOOO-----V---------------------V--------------A-----------");
		System.out.println("------NN-N---------NN-----------O-----------O-----V-------------------V--------------A-A----------");
		System.out.println("------NN--N--------NN----------O-------------O-----V-----------------V--------------A---A---------");
		System.out.println("------NN---N-------NN----------O-------------O------V---------------V--------------A-----A--------");
		System.out.println("------NN----N------NN----------O-------------O-------V-------------V--------------A-------A-------");
		System.out.println("------NN-----N-----NN----------O-------------O--------V-----------V--------------AAAAAAAAAAA------");
		System.out.println("------NN------N----NN----------O-------------O---------V---------V--------------A-----------A-----");
		System.out.println("------NN-------N---NN----------O-------------O----------V-------V--------------A-------------A----");
		System.out.println("------NN--------N--NN----------O-------------O-----------V-----V--------------A---------------A---");
		System.out.println("------NN---------N-NN----------O-------------O------------V---V--------------A-----------------A--");
		System.out.println("------NN----------NNN-----------O-----------O--------------V-V--------------A-------------------A-");
		System.out.println("------NN-----------NN------------OOOOOOOOOOO----------------V--------------A---------------------A");
		System.out.println("--------------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------------");
		
		
	}

}
