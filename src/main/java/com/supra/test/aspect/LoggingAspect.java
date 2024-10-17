package com.supra.test.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

/**
 * Aspect for logging execution of service and controller methods.
 */
@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Logs the input, output, and processing time of methods in the UserController and UserService classes.
     *
     * @param joinPoint the join point for the method execution
     * @return the result of the method execution
     * @throws Throwable if the method execution fails
     */
    @Around("execution(* com.supra.test.controller.UserController.*(..)) || execution(* com.supra.test.service.UserService.*(..))")
    public Object logExecution(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();

        // Log the method name and its input arguments
        logger.info("Method {} started with arguments: {}", joinPoint.getSignature().toString(), joinPoint.getArgs());

        // Proceed with the method execution
        Object result = joinPoint.proceed();

        // Log the output and the execution time
        Instant end = Instant.now();
        logger.info("Method {} completed with result: {} in {} ms", joinPoint.getSignature().toString(), result, Duration.between(start, end).toMillis());

        return result;
    }
}


