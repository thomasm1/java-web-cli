package com.revature.configs;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.revature.beans.BlueberryJelly;
import com.revature.beans.Donut;
import com.revature.beans.Jelly;
import com.revature.beans.PeanutButterJelly;

@Configuration
public class DonutConfig {

	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public Jelly getBlueberryJelly() {
		
		Jelly blueberry = new BlueberryJelly();
		blueberry.setFlavor("Blueberry");
		
		return blueberry;
	}
	
	@Bean
	public Jelly getPeanutButterJelly() {
		
		Jelly peanutbutter = new PeanutButterJelly();
		/*
		 * This is an example of Setter injection
		 * The object was created and then its
		 * field(s) was(were) set using the setter.
		 */
		peanutbutter.setFlavor("Peanut Butter with a baseball bat");
		
		return peanutbutter;
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Donut getBlueberryDonut() {
		/*
		 * Constructor injection
		 * All donuts require a Jelly
		 * Jelly is a dependency
		 * we can pass in that dependency when we first create the
		 * object in its constructor.
		 */
		return new Donut("Blueberry Blast", 2.75, this.getBlueberryJelly());
	}
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public Donut getPeanutButterDonut() {
		Donut pbdonut = new Donut();
		
		//Setter injection
		pbdonut.setName("Baseball Bat");
		pbdonut.setCost(3.25);
		pbdonut.setJelly(this.getPeanutButterJelly());
		
		return pbdonut;
	}
	
}
