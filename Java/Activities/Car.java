package activities;

public class Car {

	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	 Car() {
		 tyres=4;
		 doors=4;
	
	}
	 
	 public void displayCharacteristics() {
		 
		 System.out.println("Color of car: " +color);
		 System.out.println("Transmission: " +transmission);
		 System.out.println("Make of car: " +make);
		 System.out.println("Tyres of car: " +tyres);
		 System.out.println("Doors of car: " +doors);
	 }
	 
	 public void accelarate() {
		 
		 System.out.println("Car is moving forward.");
	 }
	 public void brake() {
		 
		 System.out.println("Car has stopped.");
	 }
	 

}


