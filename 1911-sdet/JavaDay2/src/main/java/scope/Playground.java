package scope;

public class Playground {

	public static void main(String[] args) {
		
		System.out.println(Box.staticnum);
		//System.out.println(Box.instancenum); can't do this
		
		Box box1 = new Box();
		box1.staticnum = 11;
		box1.instancenum = 101;
		Box box2 = new Box();
		System.out.println(box1.staticnum);
		System.out.println(box2.staticnum);
		System.out.println(Box.staticnum);
		
		System.out.println(box1.instancenum);
		System.out.println(box2.instancenum);
		
		box1.method(box1.instancenum);

	}

}
