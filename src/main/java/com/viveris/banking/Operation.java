package com.viveris.banking;

public class Operation {

    // TODO: déclarer les attributs nécessaires (type, montant)
    private final OperationType operationType;
    private final double amount;

    // TODO: constructeur
    public Operation(OperationType operationType, double amount) {
        this.operationType = operationType;
        this.amount = amount;
    }

    // TODO: getters
    public OperationType getOperationType() {
        return operationType;
    }

    public double getAmount() {
        return amount;
    }

    // TODO: toString() pour affichage lisible

    @Override
    public String toString() {
        return "Operation{" +
                "operationType=" + operationType +
                ", amount=" + amount +
                '}';
    }
}
