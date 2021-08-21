package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
        public void annotatedMethod() {
    }

    @AfterReturning(pointcut = "annotatedMethod()", returning = "obj")
    public void logActionSuccess(JoinPoint jp, Object obj) {
        logger.info("SUCCESS >>> " + jp.getSignature());
    }

    @AfterThrowing(pointcut = "annotatedMethod()", throwing = "e")
    public void logActionSuccess(JoinPoint jp, Throwable e) {
        logger.info("FAILED !!! " + e.getLocalizedMessage());
    }

}
