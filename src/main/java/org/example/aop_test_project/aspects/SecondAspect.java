package org.example.aop_test_project.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class SecondAspect {
    @Pointcut("execution(public static void main(String[]))")
    public void pc1(){}
    @Before("pc1()")
    public void beforeMain(){
        System.out.println("before main from Aspectj class syntax  ");
    }
    @After("pc1()")
    public void aftereMain(){
        System.out.println("after main from Aspectj class syntax  ");
    }
}
