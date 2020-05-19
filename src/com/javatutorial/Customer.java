package com.javatutorial;

import java.util.ArrayList;

public class Customer {
    private ArrayList<Double> transactions = new ArrayList<Double>();
    private String name;
    private double balance = 0;

    public Customer(String name) {
        this.name = name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public String getName() {
        return name;
    }

    public void makeTransaction(double amount) {
        transactions.add(amount);
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
