package Banque.Actions;

import Banque.Modeles.Client;
import Banque.Modeles.Clients;
import Banque.Modeles.Compte;

import java.util.UUID;

public class ActionSoldeGlobal {
    double getSoldeGlobal(UUID clientID) {
        double soldeGlobal = Integer.MAX_VALUE;
        Client client = null;

        if (Clients.exist(new Client(clientID))) {
            client = Clients.getClient(clientID);
            // On sait qu'on a un client donc on reset solde global pour ne pas renvoyer Integer.Max_VALUE + le total des comptes
            soldeGlobal = 0;
            Compte[] comptes = client.getComptes();

            for (Compte compte: comptes) {
                soldeGlobal += compte.getSolde();
            }
        }
        return soldeGlobal;
    }
}
