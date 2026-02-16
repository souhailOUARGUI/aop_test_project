package org.example.aop_test_project.aspects;

public aspect FirstAspect {
    pointcut pc1():execution(* org.example.aop_test_project.test.AopTestProjectApplication.main(..));
    before():pc1(){
        System.out.println("Before main AspectJ syntax ...");
    }

}
