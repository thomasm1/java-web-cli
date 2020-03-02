package com.revature.aspects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class SecurityAspect {

	@Around("securityMethod()")
	public Object authenicate(ProceedingJoinPoint pjp) throws Throwable {
		
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
		
		String auth = request.getHeader("authorizer");
		
		//auth.equals("pa$$word")
		if(("pa$$word").equals(auth)) {
			Object obj = pjp.proceed();
			return obj;
		} else {
			response.sendError(401);
			return false;
		}
		
		
	}
	
	@Pointcut("@annotation(com.revature.aspects.Authorized)")
	public void securityMethod() {
		
	}
	
}
