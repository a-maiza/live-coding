package com.viveris.banking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    void setUp() {
        // TODO: initialiser un compte de test
    }

    @Test
    void deposit_should_increase_balance() {
        // TODO
    }

    @Test
    void withdraw_should_decrease_balance() throws InsufficientFundsException {
        // TODO
    }

    @Test
    void withdraw_should_throw_when_insufficient_funds() {
        // TODO: vérifier que InsufficientFundsException est levée
    }

    @Test
    void deposit_should_throw_when_amount_is_zero_or_negative() {
        // TODO
    }

    @Test
    void history_should_not_be_modifiable_from_outside() throws InsufficientFundsException {
        // TODO: vérifier que la liste retournée est bien immutable
    }

    @Test
    void constructor_should_throw_when_name_is_blank() {
        // TODO
    }
}
