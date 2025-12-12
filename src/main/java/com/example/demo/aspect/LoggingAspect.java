package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.example.demo..*(..))")
    public void logBeforeMethod() {
        logger.info("Before method execution...");
    }

    @After("execution(* com.example.demo..*(..))")
    public void logAfterMethod() {
        logger.info("After method execution...");
    }

    @Around("execution(* com.example.demo..*(..))")
    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Before proceeding method: {}", joinPoint.getSignature());
        Object result = joinPoint.proceed();
        logger.info("After proceeding method: {}", joinPoint.getSignature());
        return result;
    }
}