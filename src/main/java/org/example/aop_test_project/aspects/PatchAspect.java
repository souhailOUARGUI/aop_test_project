package org.example.aop_test_project.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.aop_test_project.metier.Compte;
import org.example.aop_test_project.metier.MetierImpl;

@Aspect
public class PatchAspect {

    @Around("execution(* org.example.aop_test_project.metier.MetierImpl.retirer(..)) && args(code, mt)")
    public Object patch( ProceedingJoinPoint proceedingJoinPoint, Long code,double mt) throws Throwable {

        MetierImpl metier = (MetierImpl) proceedingJoinPoint.getTarget();
        Compte cp= metier.getCompte(code);
        if (cp.getSolde()>=mt) {
            return proceedingJoinPoint.proceed();
        }
        else {
            {
                throw new RuntimeException("Solde Insuffisant");
            }
        }

    }


}
