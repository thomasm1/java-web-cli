package reflectionfun;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Frankenstein {
	
	Method bark;
	Method meow;
	
	Field f;
	
	//The Class class
	Class c;
	
	public Frankenstein() {
		
		try {
			this.bark = Dog.class.getMethod("bark", null);
			this.meow = Cat.class.getMethod("meow", null);
			this.f = Dog.class.getField("breed");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Frankenstein catdog = new Frankenstein();
		
		try {
			catdog.bark.invoke(null, null);
			catdog.meow.invoke(null, null);
			System.out.println(catdog.f.getName());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		Method[] methods = String.class.getMethods();
		
		for(Method m : methods) {
			System.out.println(m.toGenericString());
		}
		
		
	}

}
