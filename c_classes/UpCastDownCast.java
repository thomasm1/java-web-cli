class Machine {
    public void start() {
        System.out.println("Machine started");
    }
}
class Atm extends Machine {
    public void start() {
        System.out.println("Atm started");
    }
    public void chaChing() {
        System.out.println("cha-ching!");
    }
} 

public class UpCastDownCast {
    public static void main(String[] args) {

        Machine machine1 = new Machine();
        Atm atm1 = new Atm();

        machine1.start();  // Machine started
        atm1.start();  // Atm started
        atm1.chaChing(); // cha-ching!

        // Upcasting
        Machine machine2 = atm1;
        // machine2.chaChing(); //  ERROR
        machine2.start();

        // Downcasting 
        Machine machine3 = new Atm();
        Atm atm2 = (Atm)machine3;
        atm2.start();
        atm2.chaChing();

        Machine machine4 = new Machine();
        // Atm atm3 = (Atm)machine4;    // RUNTIME ERROR
        // atm3.start();             // RUNTIME ERROR
        // atm3.chaChing();         // RUNTIME ERROR
        

    }   
    
}