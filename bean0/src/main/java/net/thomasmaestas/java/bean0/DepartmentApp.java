package net.thomasmaestas.java.bean0;
 

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 

public class DepartmentApp {
	
public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net/thomasmaestas/java/bean0/beans/beans.xml");
		
		Title title = (Title)context.getBean("title");
		System.out.println("DepartmentApp title: "+title);
		
		
		Map<String, String> tasks = new HashMap<String, String>();
		System.out.println("DepartmentApp tasks: "+tasks);
		
		((ClassPathXmlApplicationContext)context).close();
	}


}
