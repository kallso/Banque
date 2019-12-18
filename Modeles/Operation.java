package Banque.Modeles;

import java.util.Date;

public class Operation {
    public double getDiff() {
        return diff;
    }
    public Date getDateModification() {
        return dateModification;
    }

    private double diff;
    private Date dateModification;

    public Operation(double montant) {
        this.diff = montant;
        this.dateModification = new Date();
    }
}
