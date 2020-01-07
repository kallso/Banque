package Banque.Controller;

import Banque.Modeles.Client;
import Banque.Modeles.Clients;
import Banque.Modeles.Compte;
import Banque.Modeles.Operation;
import Banque.Views.*;

import java.util.UUID;

public class Controller {
    public static void main(String[] args) {
        String newNomClient = new ViewCreationClient().print();
        Client client = new Client(newNomClient, null);
        Clients.ajouterClient(client);
        int choix = 0;

        while(choix != 9) {
            choix = new ViewHomePage().print();
            Compte compte = null;
            ViewCompte pageCompte = new ViewCompte();
            ViewOperations pageOperations = null;
            double montant = 0;
            Operation op = null;

            switch(choix) {
                case 1:
                    // Creer compte
                    String nomCompte = pageCompte.printCreation();
                    compte = new Compte(0, nomCompte);
                    client.ajouterCompte(compte);
                    System.out.println("\n" + compte + "\n");
                    break;
                case 2:
                    // Consulter compte
                    compte = getCompteID(client);
                    pageCompte.printSolde(compte);
                    // Affiche la liste des opérations
                    Operation[] operations = compte.getOperations();

                    if (operations != null) {
                        for (Operation opEl: operations) {
                            System.out.println(opEl);
                        }
                    }
                    break;
                case 3:
                    // Deposer
                    compte = getCompteID(client);
                    pageOperations = new ViewOperations();
                    montant = pageOperations.printGetDepot();
                    op = new Operation(montant);
                    compte.ajouterOp(op);
                    pageCompte.printSolde(compte);
                    break;
                case 4:
                    // Retirer
                    compte = getCompteID(client);
                    pageOperations = new ViewOperations();
                    montant = pageOperations.printGetRetrait();
                    op = new Operation(montant);
                    compte.ajouterOp(op);
                    pageCompte.printSolde(compte);
                    break;
                case 9:
                    // Quitter
                    break;
            }
        }


    }

    static private Compte getCompteID(Client client) {
        Compte[] comptes = client.getComptes();
        int choixCompte = new ViewListComptes().print(comptes);
        if (choixCompte == 0) {
            return null;
        }
        return comptes[choixCompte - 1];
    }
}






















