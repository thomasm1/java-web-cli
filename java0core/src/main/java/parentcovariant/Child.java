package parentcovariant;

public class Child extends Parent {

	@Override
	public Parent method() {  // Overriding Parent, so can return Parent type (not object)
		return null;
	}
}
