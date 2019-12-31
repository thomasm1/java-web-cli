package innerclass;

//import classes.Android.Battery;

public class InnerClassApp {

	public static void main(String[] args) {
		int id = 3;
		double cpu = 3.3;
		Android android = new Android(id, cpu);
		
		Android.Battery bat0 = new Android.Battery();
		bat0.charge();
		
//		Battery bat1 = new Battery();
//		bat1.charge();
		System.out.println("\n ---------------\n");
		android.start();
		
	       Android.Battery battery = new Android.Battery();
	        battery.charge(); 
	}

}
