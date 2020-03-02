package quick;

public class Grandchild extends Child {

	//Covariant return type
	//The return return of an overridden method may be
	//the same as the parent's implementation or any
	//of its subclasses.
	@Override
	public Child method() {
		return null;
	}
}
