package com.javatutorial;

import java.util.ArrayList;

public class Branch {
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private String name;

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Branch(String name) {
        this.name = name;
    }

    public boolean addCustomer(String name, double initialTransactionAmount){
        if (customerExists(name)) {
            System.out.println(String.format("Customer \"%s\" already exists.", name));
            return false;
        } else if (initialTransactionAmount < 0){
            System.out.println("New customer initial transaction cannot be negative. Please try again.");
            return false;
        } else {
            Customer newCustomer = new Customer(name);
            customers.add(newCustomer);
            newCustomer.makeTransaction(initialTransactionAmount);
            System.out.println(String.format("New customer \"%s\" added with an initial transaction of $%.2f.", name, initialTransactionAmount));
            return true;
        }
    }

    public void makeTransaction(String customerName, double transactionAmount) {
        if (customerExists(customerName)){
            Customer customer = customers.get(getCustomerLocation(customerName));
            if (transactionAmount < 0 && (Math.abs(transactionAmount) > customer.getBalance())) {
                System.out.println(String.format("Unable to withdraw $%.2f from a balance of $%.2f.", Math.abs(transactionAmount), customer.getBalance()));
                return;
            }
            customer.makeTransaction(transactionAmount);
            System.out.println(String.format("Transaction successful. New balance: $%.2f", customer.getBalance()));
        } else {
            System.out.println(String.format("No customer with name \"%s\" exists at this branch.", customerName));
        }
    }

    public void printCustomers(){
        System.out.println(String.format("%s branch customers: ", name));
        for (Customer customer : customers) {
            System.out.println("\t" + customer.getName());
        }
    }

    public void printCustomersAndTransactions(){
        for (Customer customer: customers) {
            System.out.println(customer.getName());
            for (double transaction : customer.getTransactions()) {
                System.out.println(String.format("\t$%.2f", transaction));
            }
        }
    }

    public String getName() {
        return name;
    }

    public void getCustomerTransactionsAndBalance(String customerName){
        if (customerExists(customerName)) {
            Customer customer = customers.get(getCustomerLocation(customerName));
            ArrayList<Double> customerTransactions = customer.getTransactions();
            double balance = customer.getBalance();
            System.out.println(String.format("%s transactions: ", customerName));
            for (double transaction: customerTransactions) {
                System.out.println(String.format("\t$%.2f", transaction));
            }
            System.out.println(String.format("%s balance:\n\t$%.2f", customerName, balance));
        } else {
            System.out.println(String.format("No customer found with name \"%s\".", customerName));
        }
    }

    private int getCustomerLocation(String name){
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                return customers.indexOf(customer);
            }
        }
        return -1;
    }

    private boolean customerExists(String customerName) {
        return getCustomerLocation(customerName) > -1;
    }
}
