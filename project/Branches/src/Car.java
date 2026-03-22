import java.util.ArrayList;
import java.util.Scanner;



public class Car {
	
	String brand;
	String model;
	int year;
	int accelration;
	int deaccelration;
	int capacity;
	
	boolean started;
	int speed;
	int pos = 0;
	ArrayList<String> occupants = new ArrayList();
	
	public Car(String brand1, String model1, int year1, int accelration1, int deaccelration1, int cap1){
		brand = brand1;
		model = model1;
		year = year1;
		accelration = accelration1;
		deaccelration = deaccelration1;
		capacity = cap1;
	}
	
	public void enter(String person) {
		if(occupants.size() == capacity) {
			System.out.println("too many people!!!");
			return;
		}
		occupants.add(person);
	}
	
	public void exit(String person) {
		if(occupants.contains(person)) {
			occupants.remove(person);
			return;
		}
		System.out.println("this person is not inside the car!");
	}
	
	public ArrayList<String> peopleinsidecar() {
		return occupants;
	}
	
	
	public boolean started() {
		return started;
	}
	
	public void start() {
		started = true;
	}
	
	public void stop() {
		started = false;
	}
	
	
	public void gas(int sec) {
		if(!started) {
			System.out.println("car isnt started yet");
			return;
		}
		for(int i = 0; i<sec; i++) {
			speed += accelration;
			pos += speed;
		}
	}
	
	public void brake(int sec) {
		if(!started) {
			System.out.println("car isnt started yet");
			return;
		}
		for(int i = 0; i<sec; i++) {
			speed -= deaccelration;
			speed = Math.max(speed, 0);
			pos += speed;
		}
	}
	
	public void move(int sec) {
		for(int i = 0; i<sec; i++) {
			pos += speed;
		}
	}
	
	
	public int curpos() {
		return pos;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car toyota = new Car("Toyota", "Corolla", 1991, 7, 2, 5);
		
		toyota.start();
		
		toyota.gas(5);
		toyota.move(2);
		System.out.println(toyota.curpos());
		
		
		
		Car minibus = new Car("Honda", "Odyssey EX-L", 2007, 4, 1, 8);
		
		minibus.enter("Alice");
		minibus.enter("Bob");
		minibus.enter("Charles");
		minibus.enter("Darren");
		minibus.enter("Elisa");
		minibus.enter("Frank");
		minibus.enter("Gerald");
		minibus.enter("Howard");
		minibus.enter("Issac");//too much people!
		
		System.out.println(minibus.peopleinsidecar());
		
		minibus.exit("Darren");
		minibus.exit("Howard");
		
		minibus.enter("Issac");
		
		System.out.println(minibus.peopleinsidecar());
		
		
		
	}

}
