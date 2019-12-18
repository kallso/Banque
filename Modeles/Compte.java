package Banque.Modeles;

import java.util.Arrays;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Compte {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreation() {
        return creation;
    }

    public void setCreation(Date creation) {
        this.creation = creation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Operation[] getOperations() {
        return operations;
    }

    public void setOperations(Operation[] operations) {
        this.operations = operations;
    }

    private UUID id;
    private Date creation;
    private double solde;
    private Operation[] operations = null;

    public Compte(double solde) {
        this.solde = solde;
        id = UUID.randomUUID();
        creation = new Date();
    }

    public Compte(UUID id) {
        this.solde = 0;
        this.id = id;
        creation = new Date();
    }

    void ajouterOp(Operation op) {
        if (operations == null) {
            // Creation du tableau d'opérations
            operations = new Operation[1];
            operations[0] = op;
        } else {
            operations = Arrays.copyOf(operations, operations.length + 1);
            operations[operations.length - 1] = op;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Compte compte = (Compte) o;
        return Objects.equals(id, compte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
