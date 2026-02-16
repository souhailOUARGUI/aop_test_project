package org.example.aop_test_project.test;

import org.example.aop_test_project.metier.Compte;
import org.example.aop_test_project.metier.IMetier;
import org.example.aop_test_project.metier.MetierImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class AopTestProjectApplication {

    public static void main(String[] args) {
      SpringApplication.run(AopTestProjectApplication.class, args);
        new AopTestProjectApplication().start();
    }
    private void start(){
        System.out.println("demarrage de l'application");
        Scanner scaner = new Scanner(System.in);
        System.out.println("Code:");
        Long code = scaner.nextLong();

        System.out.println("Solde:");
        double solde = scaner.nextDouble();

        IMetier metier = new MetierImpl();
        metier.addCompte(new Compte(code,solde));

        while (true){
            try {
                System.out.println("*****************");
                System.out.println(metier.getCompte(code).toString());
                System.out.println("Type Opéraion:");
                String typeOp= scaner.next();
                if (typeOp.equals("quitter")) break;
                System.out.println("Montant:");
                double mt= scaner.nextDouble();
                if (typeOp.equals("v")) metier.verser(code,mt);
                if (typeOp.equals("r")) metier.retirer(code,mt);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("fin de l'application");

        }



    }

}
