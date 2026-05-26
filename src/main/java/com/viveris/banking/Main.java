package com.viveris.banking;

public class Main {

    public static void main(String[] args) {
        // --- Cas nominal ---
        BankAccount account = new BankAccount("Maiza", 100.0);
        account.deposit(1000.0);
        try {
            account.withdraw(200.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
        System.out.println("Solde : " + account.getBalance());
        account.getHistory().forEach(System.out::println);

        System.out.println("---");

        // --- Retrait supérieur au solde ---
        try {
            account.withdraw(10000.0);
        } catch (InsufficientFundsException e) {
            System.out.println("Caught InsufficientFundsException : " + e.getMessage());
        }

        // --- Montant invalide (zéro) ---
        try {
            account.deposit(0.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException (dépôt 0) : " + e.getMessage());
        }

        // --- Montant invalide (négatif) ---
        try {
            account.deposit(-5.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException (dépôt négatif) : " + e.getMessage());
        }

        // --- Nom invalide ---
        try {
            new BankAccount("", 100.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException (nom vide) : " + e.getMessage());
        }

        // --- Solde initial négatif ---
        try {
            new BankAccount("Dupont", -50.0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException (solde négatif) : " + e.getMessage());
        }

        // --- Vérifier que l'historique est non modifiable ---
        try {
            account.getHistory().clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught UnsupportedOperationException : historique bien protégé");
        }
    }
}
