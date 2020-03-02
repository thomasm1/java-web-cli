package encapsulation;

public class Car {

	String model;
	private int year;
	char character;
	
	public Car() {
		model = "Make Model";
		year = 2000;
		character = 'c';
	}
	
	public Car(String model) {
		this();
		this.model = model;
	}
	
	public Car(String model, int year) {
		this(model);
		this.year = year;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {

		if (year <= 1900) {
			this.year = 1900;
		} else if (year > 2020) {
			this.year = 2020;
		} else {
			this.year = year;
		}
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Override
	public String toString() {
		return "Car [model=" + model + ", year=" + year + ", character=" + character + "]";
	}
}
