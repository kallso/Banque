package Banque.Views;

import Banque.Modeles.Compte;

import java.util.Scanner;

public class ViewListComptes {
    public int print(Compte[] comptes) {
        Scanner s = new Scanner(System.in);

        System.out.println("[0] Quitter");
        for (int i = 0; i < comptes.length; i++) {
            System.out.println("[" + (i + 1) + "] " + comptes[i].getNom() + "\n");
        }
        return s.nextInt();
    }

}
