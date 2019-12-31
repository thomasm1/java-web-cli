package net.thomasmaestas.java.bean0;

public class Address {
private String street;
private int zip;

public Address(String street, int zip) {
//	super();
	this.street = street;
	this.zip = zip;
}
public void defaultInit() {
	System.out.println("#default-init bean created: "+ this);
}

public void defaultDestroy() {
	System.out.println("#default-destroy -- Bean created: "+ this);
}
@Override
public String toString() {
	return "Address [street=" + street + ", zip=" + zip + "]";
}

}
