package Banque.Views;

import java.util.Scanner;

public class ViewCreationClient {
    public String print() {
        Scanner s = new Scanner(System.in);
        System.out.println("Veuillez entrer votre nom afin de creer un compte client : ");
        return s.nextLine();
    }
}
