package Programming_Exercises;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Classes.*;
import Commons.Util;

//#region
class Loan {
    public Loan() {

    }
    // 시그니쳐는 fun(int a) 를 나타냄
    // 중요 !) Return 타입은 시그니쳐에 포함되지 않음...
    public int fun() {
        return 0;
    }
    public double fun(int a) {
        return 0.0;
    }
}
//#endregion


public class Chapter_11 {
    private static void Question_01(Scanner s) {
    }

    private static void Question_02(Scanner s) {
        // Person person = new Person("Peter");
        // Student student = new Student("Susan");
        // // Employee employee = new Employee("Eva");
        // // Faculty faculty = new Faculty("Frank");
        // // Staff staff = new Staff("Shane");
        
        // System.out.println(person);
        // // System.out.println(student);
        // // System.out.println(employee);
        // // System.out.println(faculty);
        // // System.out.println(staff);
    }

    private static void Question_03(Scanner s) {
    }

    private static void Question_04(Scanner s) {
        // ArrayList<Integer> list = new ArrayList<>();

        // System.out.print("Enter integers (input ends with 0): ");
        // int value;
        
        // do {
        //   value = s.nextInt(); // Read a value from the input
          
        //   if (value != 0) 
        //     list.add(value); // Add the value if it is not in the list
        // } while (value != 0);
    
        // // Display the maximum number
        // System.out.print("The maximum number is " + Util.Max(list));
    }

    private static void Question_05(Scanner s) {
    }

    private static void Question_06(Scanner s) {
        // ArrayList<Object> list = new ArrayList<>();
        // list.add(new Loan());
        // list.add("ABC");
        // list.add(new Date());
    
        // for (int i = 0; i < list.size(); i++)
        //   System.out.println(list.get(i));
    }

    private static void Question_07(Scanner s) {
    }

    private static void Question_08(Scanner s) {
        Account.setAnnualInterestRate(5.5);

        Account account = new Account("George", 1122, 1000);
        account.deposit(30);
        account.deposit(40);
        account.deposit(50);
        
        account.withdraw(5);
        account.withdraw(4);
        account.withdraw(2);
        
        System.out.println("Name: " + account.getName());
        System.out.println("Annual interest rate: " + Account.getAnnualInterestRate());
        System.out.println("Balance: " + account.getBalance());
        
        java.util.ArrayList<Transaction> list = account.getTransactions();
        
        System.out.printf("%-35s%-15s%-15s%-15s\n", "Date", "Type", "Amount", "Balance");
        
        for (int i = 0; i < list.size(); i++) {
          Transaction transaction = (Transaction)(list.get(i));
          System.out.printf("%-35s%-15s%-15s%-15s\n", transaction.getDate(), 
              transaction.getType(), transaction.getAmount(), transaction.getBalance());
        }  
    }

    private static void Question_09(Scanner s) {
    }

    private static void Question_10(Scanner s) {
        // MyStack stack = new MyStack();
        
        // for (int i = 0; i < 5; i++)
        //   stack.push(s.nextLine());
        
        // System.out.println(stack.getSize() + " strings are: ");
        // while (!stack.isEmpty())
        //   System.out.println(stack.pop());
    }

    private static void Question_11(Scanner s) {
    }

    private static void Question_12(Scanner s) {
        // ArrayList<Double> list = new ArrayList<Double>();
        // System.out.print("Enter five double values: ");
        // for (int i = 0; i < 5; i++)
        //   list.add(s.nextDouble());
    
        // System.out.println("The sum is " + Util.Sum(list));
    }

    private static void Question_13(Scanner s) {
    }

    private static void Question_14(Scanner s) {
        // System.out.print("Enter five integers for list1: ");
        // ArrayList<Integer> list1 = new ArrayList<>();
        // for (int i = 0; i < 5; i++)
        //   list1.add(s.nextInt());
        
        // System.out.print("Enter five integers for list2: ");
        // ArrayList<Integer> list2 = new ArrayList<>();
        // for (int i = 0; i < 5; i++)
        //     list2.add(s.nextInt());
        
        // ArrayList<Integer> list3 = Util.add(list1, list2);
          
        // System.out.print("The combined list is ");
        // for (int i = 0; i < list3.size(); i++) 
        //     System.out.print(list3.get(i) + " ");
    }

    private static void Question_15(Scanner s) {
    }

    private static void Question_16(Scanner s) {
        ArrayList<Integer> list = new ArrayList<Integer>();
    
        int number1 = (int) (Math.random() * 10);
        int number2 = (int) (Math.random() * 10);

        // Create a Scanner
        System.out.print("What is " + number1 + " + " + number2 + "? ");
        int answer = s.nextInt();
        list.add(answer);
      
        while (number1 + number2 != answer) {
            System.out.print("Wrong. Try again. What is " + number1 + " + " + number2 + "? ");
            answer = s.nextInt();
            
            if (list.contains(answer)) {
                System.out.println("You already entered " + answer);
            }
            else {
                list.add(answer);
            }
        }
    }

    private static void Question_17(Scanner s) {
    }

    private static void Question_18(Scanner s) {
    }

    private static void Question_19(Scanner s) {
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Question_01(s);
        Question_02(s);
        Question_03(s);
        Question_04(s);
        Question_05(s);
        Question_06(s);
        Question_07(s);
        Question_08(s);
        Question_09(s);
        Question_10(s);
        Question_11(s);
        Question_12(s);
        Question_13(s);
        Question_14(s);
        Question_15(s);
        Question_16(s);
        Question_17(s);
        Question_18(s);
        Question_19(s);

        s.close();
    }
}
