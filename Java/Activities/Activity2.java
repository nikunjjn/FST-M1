package activities;

public class Activity2 {
	
	

	public static void main(String[] args) {
		
		Activity2 activity = new Activity2();
		
		activity.checkSum();
	}
	
	public void checkSum() {
		
		int value=0;
		int a[]={10,77,10,54,-11,10};
		
		
		for(int i=0;i<=a.length-1;i++) {
		
		if(a[i]==10) {
			value=value + a[i];	
		}
		
		
		}
		if(value==30) {
			
			System.out.println("Result: true");
		}
		else {
			System.out.println("Result: false");
		}
		
	}

}
