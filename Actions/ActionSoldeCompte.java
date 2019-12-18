package Banque.Actions;

import Banque.Modeles.Client;
import Banque.Modeles.Clients;
import Banque.Modeles.Compte;

import java.util.UUID;

public class ActionSoldeCompte {
    double getSolde(UUID clientID, UUID compteID) {
        double solde = Integer.MAX_VALUE;
        Client client = null;

        if (Clients.exist(new Client(clientID))) {
            client = Clients.getClient(clientID);
            if (client.hasAccount(new Compte(compteID))) {
                solde = client.getCompte(compteID).getSolde();
            }
        }
        return solde;
    }
}
