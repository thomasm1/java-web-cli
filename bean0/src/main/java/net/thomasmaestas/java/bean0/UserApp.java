package net.thomasmaestas.java.bean0;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;

public class UserApp {
	public static void main(String[] args) {
		System.out.println("Main Application Starting");
		
//		ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml");
//		ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/net/thomasmaestas/java/bean0/beans/beans.xml");
		ApplicationContext context = new ClassPathXmlApplicationContext("net/thomasmaestas/java/bean0/beans/beans.xml");
 
//		User user = new User();
		User user1 = (User)context.getBean("user");
		User user2 = (User)context.getBean("user");
		
		User userReq = (User)context.getBean("userReq"); // cast User type to userReq bean
		 
		user1.setDept("academic"); 
		user2.speak();

		System.out.println(user1); // gets user1 deptId 
		System.out.println(user2); // also gets user1 deptId *if* scope is singleton
		System.out.println(user2); // only user2 properties if scope is prototype

		System.out.println(userReq); // userReq bean; user2 properties if scope is prototype
 	
		UserAddress address = (UserAddress)context.getBean("address"); 
		System.out.println("#Context Address: "+ address);

		UserAddress addressP = (UserAddress)context.getBean("addressP"); 
		System.out.println("#P-Namespace AddressP: "+ addressP+"\n");

		Title title = (Title)context.getBean("title");
		System.out.println(title);
			

		Department department = (Department)context.getBean("department");
		System.out.println(department);
		
		Financials financials = (Financials)context.getBean("financials");
		System.out.println(financials);
		
		Request request = (Request)context.getBean("request");
		System.out.println(request);
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
