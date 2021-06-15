package com.jags.tickets.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

	private static Logger LOGGER = LoggerFactory.getLogger(AroundAspect.class);

	/*@Around("execution(* com.jags.tickets.service.*.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		LOGGER.info(">>> Entering {}", joinPoint);
		joinPoint.proceed();
		LOGGER.info("<<< Completed {}: Time Taken is {}ms", joinPoint, System.currentTimeMillis() - startTime);
	}*/

}
