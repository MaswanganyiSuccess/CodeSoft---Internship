/*
 * This program simulates an ATM interface where users can perform operations such as checking balance,
 * depositing money, and withdrawing money from their bank account.
 *
 * Author: Maswanganyi Successfull
 */

package Task3;

import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the bank account with an initial balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Method to get the current balance of the bank account
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the bank account
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit successful. New balance: " + balance);
    }

    // Method to withdraw money from the bank account
    // Returns true if withdrawal is successful, false otherwise
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to check the balance of the bank account
    public void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    // Method to deposit money into the bank account
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Method to withdraw money from the bank account
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter initial balance for the bank account
        System.out.print("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        BankAccount bankAccount = new BankAccount(initialBalance);

        // Create an ATM object with the bank account
        ATM atm = new ATM(bankAccount);

        boolean running = true;
        // Main loop to display ATM options and handle user input
        while (running) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            // Switch statement to handle different user options
            switch (option) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    running = false; // Exit the loop if user chooses to exit
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }

        scanner.close(); // Close scanner to prevent resource leak
    }
}
