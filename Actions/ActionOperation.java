package Banque.Actions;

import Banque.Modeles.Client;
import Banque.Modeles.Clients;
import Banque.Modeles.Compte;
import Banque.Modeles.Operation;

import java.util.UUID;

public class ActionOperation {
    void Depot(double montant, UUID clientID, UUID compteID) {
        Client client = null;

        if (montant < 0) return;

        if (Clients.exist(new Client(clientID))) {
            client = Clients.getClient(clientID);
            if (client.hasAccount(new Compte(compteID))) {
                // Ajouter l'operation au compte
                Operation operation = new Operation(montant);
                Compte compte = client.getCompte(compteID);
                compte.ajouterOp(operation);
                // Mettre a jour le solde
                double solde = client.getCompte(compteID).getSolde();
                solde += montant;
            }
        }
    }

    void Retrait(double montant, UUID clientID, UUID compteID) {
        Client client = null;

        if (montant < 0) return;

        if (Clients.exist(new Client(clientID))) {
            client = Clients.getClient(clientID);
            if (client.hasAccount(new Compte(compteID))) {
                // Ajouter l'operation au compte
                Operation operation = new Operation(montant);
                Compte compte = client.getCompte(compteID);
                compte.ajouterOp(operation);
                // Mettre a jour le solde
                double solde = client.getCompte(compteID).getSolde();
                solde -= montant;
            }
        }

    }
}
