package Lectures.CPSC_225.Classes;

public class SavingAccount extends Account {
    private static double annualInterestRate;
    private int cnt;
    private final int MAX_TRANSECTIONs = 2;

    public SavingAccount(String _name, int _id, double _balance) {
        super(_name, _id, _balance);
    }
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        SavingAccount.annualInterestRate = annualInterestRate / 100;
    }

    // Method
    public double getMonthlyInterestRate() {
        return SavingAccount.annualInterestRate / 12;
    }

    public double getMonthlyInterest() {
        return super.getBalance() * this.getMonthlyInterestRate();   
    }

    private boolean IsValid() {
        if (cnt == MAX_TRANSECTIONs) {
            return false;
        }
        else {
            cnt++;
            return true;
        }
    }
    @Override
    public void withdraw(double amount) {
        // TODO Auto-generated method stub
        if (IsValid() && super.IsValid(amount, 'W')) {
            
            setBalance(this.getBalance() - amount);
            transactions.add(new Transaction('W', amount, super.getBalance(), "[Saving Account : The balance " + amount + " is withdrawed]"));
        }
        
    }
    @Override
    public void deposit(double amount) {
        // TODO Auto-generated method stub
        if (IsValid() && super.IsValid(amount, 'D')) {
            setBalance(this.getBalance() + amount);
            transactions.add(new Transaction('D', amount, super.getBalance(), "[Saving Account : The balance " + amount + " is saved]"));
        }
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        String str = super.toString();
        str += "\nThe monthly interest: " + this.getMonthlyInterest();
        return str;
    }
}
