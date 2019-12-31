package evaluations;
 
public class EvaluationServiceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EvaluationService newChar = new EvaluationService();
		System.out.println("1.)");
		newChar.reverseMe("character");
		newChar.reverseMe("hi tom");
		newChar.reverseMe("\n");
		
    	newChar.acronym("hi tom");
	
    	System.out.println("3.)");
    	EvaluationService triangle = new EvaluationService();
    	triangle.isEquilateral(3.0,3.0,3.0); // equi
    	triangle.isEquilateral(3.0,3.1,3.0); // not equi

    	System.out.println("\n");
    	triangle.isIsosceles(3.0,3.0,3.0); // isIsosceles
    	triangle.isIsosceles(3.0,3.1,3.0); // isIsosceles
    	triangle.isIsosceles(3.0,3.1,3.2); // Not isIsosceles
		
    	System.out.println("\n");
    	triangle.isScalene(3.0,3.0,3.0); // Note isScalene
    	triangle.isScalene(3.0,3.1,3.0); // Not isScalene
    	triangle.isScalene(3.0,3.1,3.2); //   isScalene
		
	}

}
