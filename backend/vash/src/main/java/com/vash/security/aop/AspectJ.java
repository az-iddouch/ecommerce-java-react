package com.vash.security.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class AspectJ {

	
	@Around("@annotation(LogExecutionTime)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
	Long start = System.currentTimeMillis();
	Object proceed = joinPoint.proceed();
	Long executionTime = System.currentTimeMillis() - start;
	log.info(">>>>signature de la methode "+joinPoint.getSignature() + " executed in " + executionTime/1000 + "s");
	return proceed;
	} 
	
}