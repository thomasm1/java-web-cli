package constructors;

public class House extends Dwelling {

	int walls;
	
	/*
	 * The first line in a constructor is always super()
	 */
	public House(int walls) {
		super();
		System.out.println("Building a house with " + walls + " wall(s)");
		this.walls = walls;
	}
	
	public House(int walls, int area) {
		super(area);
		System.out.println("Building a house with " + walls + " wall(s)");
		this.walls = walls;
	}

	@Override
	public String toString() {
		return "House [walls=" + walls + ", area=" + area + "]";
	}
	
}
