package Lectures.CPSC_225.Classes;

public class CheckingAccount extends Account {

    public CheckingAccount(String _name, int _id, double _balance) {
        super(_name, _id, _balance);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void withdraw(double amount) {
        // TODO Auto-generated method stub
        if (super.IsValid(amount, 'W')) {
            
            setBalance(this.getBalance() - amount);
            transactions.add(new Transaction('W', amount, super.getBalance(), "[Checking Account : The balance " + amount + " is withdrawed]"));
        }
        
    }
    @Override
    public void deposit(double amount) {
        // TODO Auto-generated method stub
        if (super.IsValid(amount, 'D')) {
            setBalance(this.getBalance() + amount);
            transactions.add(new Transaction('D', amount, super.getBalance(), "[Checking Account : The balance " + amount + " is saved]"));
        }
    }


    
}
