package Modeles;

import java.util.Arrays;
import java.util.UUID;

public class Clients {
    private static Client[] clients = null;

    public static Client getClient(UUID id) {
        Client compareObject = new Client(id);

        for (Client client : clients) {
            if (client.equals(compareObject)) {
                return client;
            }
        }
        return null;
    }

    public static void ajouterClient(Client client) {
                // Test : Est ce qu'on a des clients ? Si oui on ajoute un client, sinon on créer le tableau des clients
            if (clients == null) {
                // Creation du tableau de clients
                clients = new Client[1];
                clients[0] = client;
            } else {
                clients = Arrays.copyOf(clients, clients.length + 1);
                clients[clients.length - 1] = client;
            }
    }

    public static boolean exist(Client x) {
        for (Client client :clients) {
            if(x.equals(client)) return true;
        }
        return false;
    }
}
