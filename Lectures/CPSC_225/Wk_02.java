package Lectures.CPSC_225;

import Classes.*;
import Lectures.CPSC_225.Classes.*;
import Lectures.CPSC_225.Classes.Transaction;

public class Wk_02 {
    private static void Question_01() {
        System.out.println(new Time(7));
        System.out.println(new Time(555550000l));
        System.out.println(new Time(5, 23, 55));
    }

    private static void Question_02() {
        MyQueue queue = new MyQueue();
            
        // Repeatedly find prime numbers
        for (int n = 1; n <= 6; n++) {
            queue.enqueue(n);
        }

        for (int n = 1; n <= 2; n++) {
            System.out.println(queue.dequeue());
        }

        for (int n = 7; n <= 11; n++) {
            queue.enqueue(n);
        }

        for (int n = 1; n <= 8; n++) {
            System.out.println(queue.dequeue());
        } 
    }

    public static void main(String[] args) {
        // Question_01();
        // Question_02();
        Question_03();
    }

    private static void Question_03() {
        Lectures.CPSC_225.Classes.Account[] account = new Lectures.CPSC_225.Classes.Account[2];

        account[0] = new CheckingAccount("Dabin", 12, 320);
        account[1] = new SavingAccount("Dabin", 13, 800);

        account[0].deposit(100);
        account[0].withdraw(210);

        account[1].deposit(210);
        account[1].withdraw(300);

        account[0].deposit(300);
        account[1].withdraw(100); // fail...

        System.out.println(account[0]);
        java.util.ArrayList<Transaction> list = account[0].getTransactions();
        
        System.out.printf("%-35s%-15s%-15s%-15s\n", "Date", "Type", "Amount", "Balance");
        
        for (int i = 0; i < list.size(); i++) {
          Transaction transaction = (Transaction)(list.get(i));
          System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), 
              transaction.getType(), transaction.getAmount(), transaction.getBalance());
        }  

        System.out.println();

        System.out.println(account[1]);

        list = account[1].getTransactions();
        
        System.out.printf("%-35s%-15s%-15s%-15s\n", "Date", "Type", "Amount", "Balance");
        
        for (int i = 0; i < list.size(); i++) {
          Transaction transaction = (Transaction)(list.get(i));
          System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), 
              transaction.getType(), transaction.getAmount(), transaction.getBalance());
        }  
    }
}
