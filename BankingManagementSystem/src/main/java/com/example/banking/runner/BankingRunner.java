package com.example.banking.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.example.banking.service.BankService;

@Component
public class BankingRunner implements CommandLineRunner {
    private final BankService bankService;

    public BankingRunner(BankService bankService) {
        this.bankService = bankService;
    }

    @Override
    public void run(String... args) {
        System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
        System.out.printf("Initial Balance: ₹%.2f%n", bankService.getBalance());

        try {
            System.out.println("\nDepositing ₹500.00");
            bankService.deposit(500.00);
            System.out.printf("Current Balance: ₹%.2f%n", bankService.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nWithdrawing ₹300.00");
            bankService.withdraw(300.00);
            System.out.printf("Current Balance: ₹%.2f%n", bankService.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nWithdrawing ₹2000.00");
            bankService.withdraw(2000.00);
            System.out.printf("Current Balance: ₹%.2f%n", bankService.getBalance());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("\nDepositing ₹0.00");
            bankService.deposit(0.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.printf("%nFinal Balance: ₹%.2f%n", bankService.getBalance());
        System.out.println("===== APPLICATION COMPLETED =====");
    }
}
