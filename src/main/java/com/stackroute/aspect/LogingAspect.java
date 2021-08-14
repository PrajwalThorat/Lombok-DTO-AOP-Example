package com.stackroute.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogingAspect.class);
	
	@Pointcut("execution(* com.stackroute.controller.MyController.*(..))")
	public void pointCutMethod() {
		
	}
	
	@Before("pointCutMethod()")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.info("**********Before************");
		logger.warn("Method Name : {}" , joinPoint.getSignature().getName());
		logger.warn("Method Args : {}" , Arrays.toString(joinPoint.getArgs()));
		logger.info("*********End Before*********");
	}
	
	 @After("pointCutMethod()")
	    public void afterAdvice(JoinPoint joinPoint){
	        logger.info("****************After************");
	      /*  logger.debug("Method Name : {}", joinPoint.getSignature().getName());
	        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));*/

	        logger.debug("Method Name : {}", joinPoint.getSignature().getName());
	        logger.debug("Method Args: {}", Arrays.toString(joinPoint.getArgs()));
	        logger.info("****************End of After************");
	    }

}
