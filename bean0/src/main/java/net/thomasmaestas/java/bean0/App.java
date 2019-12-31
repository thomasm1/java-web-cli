package net.thomasmaestas.java.bean0;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		System.out.println("Main Application Starting");
		
//		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/net/thomasmaestas/java/bean0/beans/beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("net/thomasmaestas/java/bean0/beans/beans.xml");
 
//		User user = new User();
		User user1 = (User)context.getBean("user");
		User user2 = (User)context.getBean("user");
 
		user1.setDeptId(400); 
		
		user2.speak();

		System.out.println(user1); // gets user1 deptId 
		System.out.println(user2); // also gets user1 deptId *if* scope is singleton
		
		System.out.println(user2); // only user2 properties if scope is prototype
		
		
		Address address = (Address)context.getBean("address");
		System.out.println("#Context Address: "+ address);
		
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
