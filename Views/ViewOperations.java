package Banque.Views;

import java.util.Scanner;

public class ViewOperations {
    public double printGetDepot() {
        Scanner s = new Scanner(System.in);
        System.out.print("Montant de votre dépot : ");
        return s.nextDouble();
    }

    public double printGetRetrait() {
        Scanner s = new Scanner(System.in);
        System.out.print("Montant de votre retrait : ");
        return -s.nextDouble();
    }
}
