package com.viveris.banking;

public class Main {

    public static void main(String[] args) throws InsufficientFundsException {
        // TODO: tester les cas nominaux
        //   - créer un compte avec un solde initial
        //   - déposer de l'argent
        //   - retirer de l'argent
        //   - afficher le solde et l'historique
        BankAccount bankAccount = new BankAccount("maiza", 100.0);
        bankAccount.deposit(1000.0);
        bankAccount.withdraw(100.0);
        bankAccount.getHistory().forEach(System.out::println);

        // TODO: tester les cas limites
        //   - retrait supérieur au solde
        //   - montant négatif ou zéro
        //   - nom null ou vide
        bankAccount.withdraw(10000.0);
        bankAccount.deposit(-5.0);
    }
}
