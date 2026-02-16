package org.example.aop_test_project.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

@Aspect
@Component
public class LogingAspect {
    private long t1, t2;

    Logger logger = Logger.getLogger(this.getClass().getName());

    public LogingAspect() throws IOException {
        logger.addHandler(new FileHandler("log.xml"));

    }

    @Pointcut("execution(* *..*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void beforePc1(JoinPoint joinPoint){
        logger.info("*****************************");
        logger.info("Avant execution de la méthode"+joinPoint.getSignature());
        t1 = System.currentTimeMillis();
    }

    @After("pc1()")
    public void afterPc1(JoinPoint joinPoint){
        logger.info("Après execution de la méthode"+joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        logger.info("Durée d'exec="+(t2-t1));
        logger.info("*****************************");
    }
}
