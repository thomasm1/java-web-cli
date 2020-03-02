package constructors;

public class Dwelling {

	int area;
	
	public Dwelling() {
		System.out.println("I will provide my own value for area.");
		this.area = 500;
	}
	
	public Dwelling(int area) {
		System.out.println("Making a dwelling of size: " + area);
		this.area = area;
	}

	@Override
	public String toString() {
		return "Dwelling [area=" + area + "]";
	}
}
