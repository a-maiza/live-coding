package com.viveris.banking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    // TODO: déclarer les attributs (titulaire, solde, historique)
    private final String name;
    private Double balance;
    private final List<Operation> history;

    // TODO: constructeur — valider le nom et le solde initial
    public BankAccount(String name, Double balance) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null or blank");
        }
        if (balance == null || balance < 0) {
            throw new IllegalArgumentException("balance cannot be negative");
        }
        this.name = name;
        this.balance = balance;
        this.history = new ArrayList<>();
    }

    /**
     * Dépose un montant sur le compte.
     *
     * @param amount montant à déposer (doit être > 0)
     * @throws IllegalArgumentException si le montant est invalide
     */
    public void deposit(Double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.balance += amount;
        Operation deposit = new Operation(OperationType.DEPOSIT, amount);
        this.history.add(deposit);
    }

    /**
     * Retire un montant du compte.
     *
     * @param amount montant à retirer (doit être > 0)
     * @throws IllegalArgumentException si le montant est invalide
     * @throws InsufficientFundsException si le solde est insuffisant
     */
    public void withdraw(Double amount) throws InsufficientFundsException {
        if (amount <= 0 ) {
            throw new IllegalArgumentException("Amount cannot be negative");
        } else if (amount > balance) {
            throw new InsufficientFundsException("Solde insuffisant : solde=" + balance + ", retrait demandé=" + amount);
        }
        this.balance -= amount;
        Operation withdraw = new Operation(OperationType.WITHDRAWAL, amount);
        history.add(withdraw);
    }

    /**
     * Retourne le solde actuel.
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Retourne une vue non modifiable de l'historique des opérations.
     */
    public List<Operation> getHistory() {
        return Collections.unmodifiableList(history);
    }

    // TODO: toString() optionnel
    @Override
    public String toString() {
        return "BankAccount{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", history=" + history +
                '}';
    }
}
