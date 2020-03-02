package com.revature.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private int counter = 0;

	//This method is the advice and will 'advise' another method
	@Before("logMethod()")	//when does this advice method execute
	public void logInfo() {
		System.out.println("This many calls have been made: " + ++counter);
	}
	
	@After("logMethod()")
	public void logInfoAfter() {
		System.out.println("I print after a method call is made.");
	}
	
	/*
	 * @Before - before the method executes
	 * @After - after the method executes
	 * @AfterThrowing - only after the method throws an exception
	 * @Around - the most powerful type of advice and allows
	 * you to control the method before and after execution.
	 */
	
	
	//This pointcut expression applies to all methods in this class.
	@Pointcut("execution(* com.revature.controllers.AssociateController.*(..))")
	public void logMethod() {
		//This is a Hook method. Does nothing.
	}
}
