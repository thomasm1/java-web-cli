package net.thomasmaestas.java.bean0;

 
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MessageListApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("net/thomasmaestas/java/bean0/beans/beans.xml");
		
		MessageList messagelist = (MessageList)context.getBean("messagelist");
		
		System.out.println(messagelist);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
