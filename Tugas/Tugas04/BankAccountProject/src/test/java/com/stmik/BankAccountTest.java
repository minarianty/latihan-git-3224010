package com.stmik;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount();
    }

    @Test
    public void testInitialBalance() {
        // Arrange dan Act
        double result = account.getBalance();

        // Assert
        assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testDepositPositiveAmount() {
        // Arrange
        double amount = 100000.0;

        // Act
        account.deposit(amount);

        // Assert
        assertEquals(100000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositNegativeAmount() {
        // Arrange
        double amount = -50000.0;

        // Act dan Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> account.deposit(amount)
        );

        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawPositiveAmount() {
        // Arrange
        account.deposit(200000.0);

        // Act
        account.withdraw(50000.0);

        // Assert
        assertEquals(150000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawNegativeAmount() {
        // Arrange
        account.deposit(100000.0);

        // Act dan Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(-20000.0)
        );

        assertEquals(100000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawExceedsBalance() {
        // Arrange
        account.deposit(100000.0);

        // Act dan Assert
        assertThrows(
            IllegalArgumentException.class,
            () -> account.withdraw(150000.0)
        );

        assertEquals(100000.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawExactBalance() {
        // Arrange
        account.deposit(100000.0);

        // Act
        account.withdraw(100000.0);

        // Assert
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositZeroAmount() {
        // Arrange
        account.deposit(0.0);

        // Act
        double result = account.getBalance();

        // Assert
        assertEquals(0.0, result, 0.001);
    }
}