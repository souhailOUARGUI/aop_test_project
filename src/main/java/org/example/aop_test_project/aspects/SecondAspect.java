package org.example.aop_test_project.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;


@Aspect
public class SecondAspect {
    @Pointcut("execution(public static void man(String[]))")
    public void pc1(){}
//    @Before("pc1()")
//    public void beforeMain(){
//        System.out.println("before main from Aspectj class syntax  ");
//    }
//    @After("pc1()")
//    public void aftereMain(){
//        System.out.println("after main from Aspectj class syntax  ");
//    }

    @Around("pc1()")
    public void aroundMain(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("before main from around code advice ...");
        //execute main
        Object o = proceedingJoinPoint.proceed();
        System.out.println("after main from around code advice ...");

    }
}
