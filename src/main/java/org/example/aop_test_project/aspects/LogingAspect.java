package org.example.aop_test_project.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogingAspect {
    private long t1, t2;
    @Pointcut("execution(* *..*(..))")
    public void pc1(){}

    @Before("pc1()")
    public void beforePc1(JoinPoint joinPoint){
        System.out.println("*****************************");
        System.out.println("Avant execution de la méthode"+joinPoint.getSignature());
        t1 = System.currentTimeMillis();
    }

    @After("pc1()")
    public void afterPc1(JoinPoint joinPoint){
        System.out.println("Après execution de la méthode"+joinPoint.getSignature());
        t2 = System.currentTimeMillis();
        System.out.println("Durée d'exec="+(t2-t1));
        System.out.println("*****************************");
    }
}
