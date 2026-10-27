package com.example.banking.service;

import org.springframework.stereotype.Service;

@Service
public class BankService {
    private double balance = 1000.00;

    public double deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero!");
        }
        balance += amount;
        return balance;
    }

    public double withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be greater than zero!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance!");
        }
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }
}
