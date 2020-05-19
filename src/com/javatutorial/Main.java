package com.javatutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Bank bank = new Bank();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        while (!quit) {
            System.out.println("***** MENU *****");
            System.out.println("1 - Add branch");
            System.out.println("2 - Add customer to branch");
            System.out.println("3 - Get customer transactions and balance");
            System.out.println("4 - Print customers by branch");
            System.out.println("5 - Print customers and transactions by branch");
            System.out.println("6 - Make transaction");
            System.out.println("7 - Quit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch(option) {
                case 1:
                    addBranch();
                    break;
                case 2:
                    addCustomerToBranch();
                    break;
                case 3:
                    getCustomerTransactionsAndBalance();
                    break;
                case 4:
                    printCustomersByBranch();
                    break;
                case 5:
                    printCustomersAndTransactionsByBranch();
                    break;
                case 6:
                    makeTransaction();
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("I don't understand that selection. Please try again.");
            }

        }
    }

    private static void addBranch(){
        System.out.print("Add branch - Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.addBranch(branchName);
    }

    private static void addCustomerToBranch(){
        System.out.print("Add customer - Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Add customer - Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Add customer - Enter initial transaction amount (no currency symbols): ");
        double initialTransaction = scanner.nextDouble();
        scanner.nextLine();
        bank.addCustomer(branchName, customerName, initialTransaction);
    }

    private static void printCustomersByBranch(){
        System.out.print("Customers by branch - Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.printCustomersByBranch(branchName);
    }
    private static void printCustomersAndTransactionsByBranch(){
        System.out.print("Customers by branch w/ transactions - Enter branch name: ");
        String branchName = scanner.nextLine();
        bank.printCustomersAndTransactionsByBranch(branchName);
    }
    private static void makeTransaction(){
        System.out.print("Make transaction - Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.print("Make transaction - Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Make transaction - Enter transaction amount (no currency symbols): ");
        double transactionAmount = scanner.nextDouble();
        scanner.nextLine();
        bank.makeTransaction(branchName, customerName, transactionAmount);
    }
    private static void getCustomerTransactionsAndBalance(){
        System.out.print("Customer info - Enter branch: ");
        String branchName = scanner.nextLine();
        System.out.print("Customer info - Enter customer name: ");
        String customerName = scanner.nextLine();
        bank.getCustomerTransactionsAndBalance(branchName, customerName);
    }
}
