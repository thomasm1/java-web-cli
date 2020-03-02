package com.revature.configs;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.revature.beans.Box;

/*
 * This class will contain the information necessary to
 * help create the Spring IOC Container
 */
@Component	//This class should be managed by the 
//Spring IOC Container
@Configuration
/*
 * A way to tell Spring what type of class or
 * role this serves within the Spring IOC (ApplicationContext)
 */
public class AppConfig {

	@Bean	//belongs on a method, it says
	//that this method is user to return a Bean.
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Box getSingleBox() {
		System.out.println("Getting you a box");
		return new Box(15);
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Box getProtoBox() {
		System.out.println("Getting you a second box");
		return new Box(20);
	}
}
