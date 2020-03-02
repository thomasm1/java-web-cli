package com.revature.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.*;


public class LifeBean implements InitializingBean, DisposableBean {

	public void destroy() throws Exception {
		System.out.println("Destroy method is executed.");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("After properties set method has been executed.");
	}
	
	@PostConstruct
	public void myInit() {
		System.out.println("Called myInit");
	}
	
	@PreDestroy
	public void myTearDown() {
		System.out.println("Called myTearDown");
	}

}
