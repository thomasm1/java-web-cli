package designpatterns;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListFactory {

	public static List getList(int choice) {
		if(choice == 1) {
			System.out.println("Created ArrayList");
			return new ArrayList();
		}
		if(choice == 2) {
			System.out.println("Created LinkedList");
			return new LinkedList();
		}
		
		return null;
	}
	
}
