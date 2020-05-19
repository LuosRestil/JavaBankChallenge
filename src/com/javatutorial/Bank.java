package com.javatutorial;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Branch> branches = new ArrayList<Branch>();

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addBranch(String name) {
        branches.add(new Branch(name));
        return true;
    }

    public boolean addCustomer(String branchName, String customerName, double initialTransaction) {
        if (branchExists(branchName)) {
            Branch branch = branches.get(getBranchIndex(branchName));
            return branch.addCustomer(customerName, initialTransaction);
        } else {
            System.out.println(String.format("No branch with name \"%s\" exists. Please try again.", branchName));
            return false;
        }
    }

    public void printCustomersByBranch(String branchName) {
        if (branchExists(branchName)) {
            Branch branch = branches.get(getBranchIndex(branchName));
            branch.printCustomers();
        } else {
            System.out.println(String.format("No branch with name \"%s\" exists.", branchName));
        }
    }

    public void printCustomersAndTransactionsByBranch(String branchName) {
        if (branchExists(branchName)) {
            Branch branch = branches.get(getBranchIndex(branchName));
            branch.printCustomersAndTransactions();
        } else {
            System.out.println(String.format("No branch with name \"%s\" exists.", branchName));
        }
    }

    private int getBranchIndex(String branchName){
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branches.indexOf(branch);
            }
        }
        return -1;
    }

    private boolean branchExists(String branchName){
        return getBranchIndex(branchName) > -1;
    }

    public void makeTransaction(String branchName, String customerName, double transactionAmount) {
        if (branchExists(branchName)) {
            Branch branch = branches.get(getBranchIndex(branchName));
            branch.makeTransaction(customerName, transactionAmount);
        } else {
            System.out.println(String.format("No branch with name \"%s\" found.", branchName));
        }
    }

    public void getCustomerTransactionsAndBalance(String branchName, String customerName) {
        if (branchExists(branchName)) {
            Branch branch = branches.get(getBranchIndex(branchName));
            branch.getCustomerTransactionsAndBalance(customerName);
        } else {
            System.out.println(String.format("No branch with name \"%s\" found.", branchName));
        }
    }

}
