package Classes;

import java.util.Date;

public class Account {
    private int id;
    private String name;
    private double balance;
    private static double annualInterestRate;
    private Date dateCreated;
    private java.util.ArrayList<Transaction> transactions = new java.util.ArrayList<>();
    public Account() {
        new Account("none", 0, 0);
    }

    public Account(String _name, int _id, double _balance) {
        this.name = _name;
        this.id = _id;
        this.balance = _balance;
    
        dateCreated = new Date();
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
    public static double getAnnualInterestRate() {
        return annualInterestRate;
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
    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate / 100;
    }

    // Method
    public double getMonthlyInterestRate() {
        return Account.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return this.balance * this.getMonthlyInterestRate();   
    }

    public void withdraw(double amount) {
        if(IsValid(amount, 'W')) {
            this.balance -= amount;
            transactions.add(new Transaction('W', amount, balance, ""));
        }        
    }

    public void deposit(double amount) {
        if (IsValid(amount, 'D')) {
            this.balance += amount;
            transactions.add(new Transaction('D', amount, balance, ""));
        }
    }
    
    private boolean IsValid(double amount, char ch) {
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

    @Override
    public String toString() {
        String str = "The balance: " + this.balance;
        str += "\nThe monthly interest: " + this.getMonthlyInterest();
        str += "\nThe date when this account was created: " + dateCreated.toString();
        return str;
    }
}
