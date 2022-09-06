package Lectures.CPSC_225.Classes;

import java.util.Date;

public abstract class Account {
    private int id;
    private String name;
    private double balance;
    private Date dateCreated;
    java.util.ArrayList<Transaction> transactions = new java.util.ArrayList<>();

    public Account(String _name, int _id, double _balance) {
        this.name = _name;
        this.id = _id;
        this.balance = _balance;
      
        dateCreated = new Date();
    }


    public abstract void withdraw(double amount);
    public abstract void deposit(double amount);

    boolean IsValid(double amount, char ch) {
        if (amount < 0) {
            return false;
        }

        boolean res = false;
        
        switch (ch) {
            // deposit
            case 'D':
                res = true;
            break;
            // withdraw
            case 'W':
                if (this.balance >= amount)
                    res = true;
                break;
        
            default:
                break;
        }
        return res;
    }

    // Accessor
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    
    public java.util.ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Mutator
    public void setId(int id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        String str = "User: " + this.name;
        str += "\nThe balance: " + this.balance;
        str += "\nThe date when this account was created: " + dateCreated.toString();
        return str;
    }
}
