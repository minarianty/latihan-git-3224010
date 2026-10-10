package com.stmik;

public class BankAccount {

    private double balance;

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative"
            );
        }

        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(
                "Amount cannot be negative"
            );
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance"
            );
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}