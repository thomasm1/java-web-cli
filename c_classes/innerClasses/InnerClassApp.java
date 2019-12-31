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
        
        // this here only works if Brain is declared public. (not usual to do htis)
        // Robot.Brain brain = robot.new Brain();
        // brain.think(); 
        
        //  static inner class.
        Robot.Battery battery = new Robot.Battery();
        battery.charge();
    }

}
