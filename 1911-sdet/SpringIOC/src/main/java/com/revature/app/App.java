package com.revature.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.revature.beans.Donut;
import com.revature.configs.DonutConfig;

public class App {

	public static void main(String[] args) {
		
//		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		
//		Box a = ac.getBean("getSingleBox", Box.class);
//		Box b = ac.getBean("getSingleBox", Box.class);
//		
//		System.out.println(a == b);
//		
//		Box c = ac.getBean("getProtoBox", Box.class);
//		Box d = ac.getBean("getProtoBox", Box.class);
//		
//		System.out.println(c == d);
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(DonutConfig.class);
		
		Donut bdonut = ac.getBean("getBlueberryDonut", Donut.class);
		Donut pbdonut = ac.getBean("getPeanutButterDonut", Donut.class);
		
		System.out.println(bdonut);
		System.out.println(pbdonut);
		
	}
}
