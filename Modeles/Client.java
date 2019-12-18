package Banque.Modeles;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class Client {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Compte[] getComptes() {
        return comptes;
    }

    public void setComptes(Compte[] comptes) {
        this.comptes = comptes;
    }

    private UUID id;
    private String nom;
    private Compte[] comptes;

    public Client(String nom, Compte[] comptes) {
        id = UUID.randomUUID();
        this.nom = nom;
        this.comptes = comptes;
    }

    public Client(UUID id) {
        this.id = id;
        this.nom = "compareObject";
        this.comptes = null;
    }

    public Compte getCompte(UUID id) {
        Compte compareObject = new Compte(id);

        for (Compte compte: comptes) {
            if (compte.equals(compareObject)) {
                return compte;
            }
        }
        return null;
    }

    void ajouterCompte(Compte compte) {
        if (comptes == null) {
            // Creation du tableau de comptes
            comptes = new Compte[1];
            comptes[0] = compte;
        } else {
            comptes = Arrays.copyOf(comptes, comptes.length + 1);
            comptes[comptes.length - 1] = compte;
        }
    }

    void supprimerCompte(UUID id) {
        // On va recreer le tableau de comptes en enlevant le compte a supprimer. temp est le tableau temporaire ou on met
        // au fur et a mesure les comptes.
        Compte compareObject = new Compte(id);
        Compte[] temp = new Compte[0];

        for (Compte compte : comptes) {
            if (compte.equals(compareObject)) {
                continue;
            }
            temp = Arrays.copyOf(comptes, temp.length + 1);
        }

        this.comptes = temp;
    }

    public boolean hasAccount(Compte x) {
        for (Compte compte :comptes) {
            if(x.equals(compte)) return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
