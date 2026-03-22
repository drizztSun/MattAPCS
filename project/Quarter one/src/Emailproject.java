import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Emailproject {
	static LocalDate time = LocalDate.now();
	static LocalDate newtime = time.plusDays(5);
	static Scanner kboard = new Scanner(System.in);
	// Generate the  
	public static void survey(String name) throws InterruptedException {
		System.out.println("Hello, " + name + "! Please complete the survey below for us.");
		System.out.println("Question 1: What do you plan to use Gemail for?");
		@SuppressWarnings("unused")
		String p = kboard.nextLine();
		System.out.println("Question 2: Are you satisfied with Gemail so far?");
		p = kboard.nextLine();
		System.out.println("Question 3: What New Features would you like to see in Gemail?");
		p = kboard.nextLine();
		System.out.print("Thank you for takning the survey! You will be returned to Gemail.");
		p += 'c';
		load(750);

	}
	
	public static String pswrdgen(String s) {
		String res = "";
		int i = 0;
		for(char c : s.toCharArray()) {
			String prd = "";
			if(i % 2 == 0) {
				int x = c;
				prd = Integer.toString(x);
			}
			else {
				prd += c;
			}
			
			res += prd;
			i++;
		}
		return res;
	}
	public static void load(int x) throws InterruptedException {
		Thread.sleep(x);
		System.out.print(".");
		Thread.sleep(x);
		System.out.println(".");
	}
	
	public static void email(String name, int num, int age) throws InterruptedException {

		if(num == 1) {
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("Happy Birthday!");
			System.out.println("Dear " + name + ",");
			System.out.println("Happy Birthday from Gemail! Today you will be turning " + age + " today.");
			System.out.println("In celebration of your birthday, we will be giving you Gemail premium for 7 days.");
			System.out.println("------------------------------");
			System.out.println();
		}
		else if(num == 2) {
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("Hello, " + name + ",");
			System.out.println("Your Detention sceduled at " + time + " is starting in 10 minutes. \n "
					+ "please report to the detention room linked below. The consequences for missing a detention, \n"
					+ "is another detention on top of the first detention. \n"
					+ "Attendence Office");
			System.out.println("------------------------------");
			System.out.println();
		}
		else if(num == 3){
			System.out.println();
			System.out.println("------------------------------");
			System.out.println(name + ",");
			System.out.println("Your order of the TI-84SC calculator was placed. Your order will be arriving at " + newtime + ".");
			System.out.println("------------------------------");
			System.out.println();
		}
		else if (num == 4){
			System.out.println();
			System.out.println("------------------------------");
			System.out.println("Dear " + name + ",");
			System.out.println("Welcome to Gemail! We at Gemail are very pleased with a new patron joining our platform.\n"
					+ "As you might imagine, customer feedback is our greatest source of information, so if you have time, please\n"
					+ "complete the survey below!");
			System.out.println("------------------------------");
			System.out.println();
			
			System.out.println("Attatchment detected, go to Attatchment? (Y/N)");
			String decision = kboard.nextLine();
			
			if(decision.equals("Y")) {
				survey(name);
			}
		}
		
		System.out.println("Enter anything to exit this email");
		String _ = kboard.nextLine();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Enter Name:");
		
		
	    Random random = new Random();
		String name = kboard.nextLine();
		
		String oldpswrd = pswrdgen(name);
		String pswrd = oldpswrd.substring(0, Math.min(oldpswrd.length(), 8));
		int age = random.nextInt(30) + 13;
		
		System.out.println("Enter password:");
		String password = kboard.nextLine();
		
		int i = 1;
		while(!password.equals(pswrd)) {
			System.out.println("password incorrect; enter password again");
			password = kboard.nextLine();
			if(i>=3) {
				System.out.println("hint:" + pswrd);
			}
			
			i++;
		}
		
		System.out.print("Correct! loading Gemail.");
		load(750);
		
		ArrayList<String> read = new ArrayList<>();
		for(int r = 0; r<4; r++) {
			read.add("unread");
		}

		int accessed = read.size();
		
		while(true) {
			
			System.out.println("You have mail!("+ Math.max(accessed, 0) +")");
			System.out.println("#1: Happy Birthday, Time:" + time + " " + read.get(0));
			System.out.println("#2: Detention notice, Time:" + time + " " + read.get(1));
			System.out.println("#3: Item Ordered, Time:" + time + " " + read.get(2));
			System.out.println("#4: " + name + ", Welcome to Gemail, Time:" + time + " " + read.get(3));
			System.out.println("which email would you like to access? type \"exit\" to exit Gemail");
			String str = kboard.nextLine();
			
			if(str.equals("exit")) {
				System.out.print("exiting.");
				load(750);
				break;
			}
			
			int num = Integer.parseInt(str);
			while(num <= 0 || num > 4) {
				
				System.out.println("Email not found; Try again");
				
				num = Integer.parseInt(kboard.nextLine());
			}
			read.set(num-1, "read");
			accessed--;
			
			System.out.print("Acessing.");
			load(450);

			email(name, num, age);
			kboard.close();
		}

	}
}
