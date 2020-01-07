package Banque.Views;

import Banque.Modeles.Compte;

import java.util.Scanner;

public class ViewCompte {
    public String printCreation() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nom de votre nouveau compte :");
        return s.nextLine();
    }
    public void printSolde(Compte compte) {
        System.out.println("Le solde de votre compte " + compte.getNom() + " est de " + compte.getSolde() + "€." + "\n");
    }
}
