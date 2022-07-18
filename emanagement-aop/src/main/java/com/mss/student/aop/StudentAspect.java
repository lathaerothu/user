package com.mss.student.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component

public class StudentAspect {

	@Before(value = "execution(* com.mss.student.aop.StudentdataService.*(..))")
	public void startMethod(JoinPoint joinPoint)
	{	
	 System.out.println("START"+joinPoint.getSignature().getName());
		//log.info("START"+joinPoint.getSignature().getName());
	}
	
	@After(value = "execution(* com.mss.student.aop.StudentdataService.*(..))")
	public void endMethod(JoinPoint joinPoint)
	{
		System.out.println("END"+joinPoint.getSignature().getName());
		//log.info("END"+joinPoint.getSignature().getName());
	}

	
@Around(value = "execution(* com.mss.student.aop.StudentdataService.*(..))")
	public void aroundMethod(JoinPoint joinPoint)    
	{	
	 System.out.println("sucessfully "+joinPoint.getSignature().getName());
	}
	
}




