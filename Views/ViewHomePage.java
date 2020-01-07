package Banque.Views;

import java.util.Scanner;

public class ViewHomePage {
    public int print() {
        Scanner s = new Scanner(System.in);
        System.out.println("\n[1] Creer compte");
        System.out.println("[2] Consulter compte");
        System.out.println("[3] Deposer");
        System.out.println("[4] Retirer");
        System.out.println("[9] Quitter");
        return s.nextInt();
    }
}
