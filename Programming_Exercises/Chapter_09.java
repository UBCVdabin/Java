package Programming_Exercises;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

import Classes.*;
import Commons.Sorts;
import Commons.Util;

public class Chapter_09 {
    private static void Question_01(Scanner s) {
        Rectangle rect = new Rectangle(4, 40);

        System.out.println("The width is " + rect.getWidth());
        System.out.println("The height is " + rect.getHeight());
        System.out.println("The area is " + rect.getArea());
        System.out.println("The perimeter is " + rect.getPerimeter());

        rect = new Rectangle(3.5, 35.9);

        System.out.println("The width is " + rect.getWidth());
        System.out.println("The height is " + rect.getHeight());
        System.out.println("The area is " + rect.getArea());
        System.out.println("The perimeter is " + rect.getPerimeter());
    }

    private static void Question_02(Scanner s) {
        Stock stock = new Stock("ORCL", "Oracle Corporation", 34.5, 34.35);

        System.out.println("The symbol is " + stock.getSymbol());
        System.out.println("The name is " + stock.getName());
        System.out.println("The previous closing price is " + stock.getPreviousClosingPrice());
        System.out.println("The current price is " + stock.getCurrentPrice());
        System.out.println("The Change percentage is " + stock.getChangePercent());
    }

    private static void Question_03(Scanner s) {
        Date date = new Date(10000);
        System.out.println(date.toString());

        date = new Date(100000);
        System.out.println(date.toString());

        date = new Date(1000000);
        System.out.println(date.toString());

        date = new Date(10000000);
        System.out.println(date.toString());

        date = new Date(100000000l);
        System.out.println(date.toString());

        date = new Date(1000000000l);
        System.out.println(date.toString());

        date = new Date(10000000000l);
        System.out.println(date.toString());

        date = new Date(100000000000l);
        System.out.println(date.toString());
    }

    private static void Question_04(Scanner s) {
        Random random = new Random(1000);

        for (int i = 1; i <= 50; i++) {
            if (i % 10 == 0) {
                System.out.println(random.nextInt(100));
            }
            else {
                System.out.print(random.nextInt(100) + ", ");
            }
        }
    }

    private static void Question_05(Scanner s) {
        Date date = new Date(); // your date
        // Choose time zone in which you want to interpret your Date
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("America/Toronto"));
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        System.out.println(year + "-" + month + "-" + day);
    }

    private static void Question_06(Scanner s) {
        int size = 100000;
    
        double[] list = new double[size]; 
        
        for (int i = 0; i < list.length; i++) {
          list[i] = Math.random() * list.length;
        }
    
        StopWatch stopWatch = new StopWatch();
        Sorts.SelectionSort(list);
        stopWatch.stop();
        
        System.out.println("The sort time is " + stopWatch.getElapsedTime()); 
    }

    private static void Question_07(Scanner s) {
    }

    private static void Question_08(Scanner s) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.FAST);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setOn(true);
        System.out.println(fan1.toString());
    
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        fan2.setRadius(5);
        fan2.setColor("blue");
        fan2.setOn(false);
        System.out.println(fan2.toString());
    }

    private static void Question_09(Scanner s) {
        Account.setAnnualInterestRate(4.5);

        Account account = new Account("John", 1122, 20000);
        account.withdraw(2500);
        account.deposit(3000);

        System.out.println(account);
    }

    private static void Question_10(Scanner s) {
        System.out.print("Enter a, b, c: ");
        double a = s.nextDouble();
        double b = s.nextDouble();
        double c = s.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double discriminant = equation.getDiscriminant();

        if (discriminant < 0) {
            System.out.println("The equation has no roots");
        }
        else if (discriminant == 0)
        {
            System.out.println("The root is " + equation.getRoot1());
        }
        else // (discriminant >= 0)
        {
            System.out.println("The roots are " + equation.getRoot1() 
                + " and " + equation.getRoot2());
        }  
    }

    private static void Question_11(Scanner s) {
    }

    private static void Question_12(Scanner s) {
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double x1 = s.nextDouble();
        double y1 = s.nextDouble();
        double x2 = s.nextDouble();
        double y2 = s.nextDouble();
        double x3 = s.nextDouble();
        double y3 = s.nextDouble();
        double x4 = s.nextDouble();
        double y4 = s.nextDouble();

        // Build a 2 by 2 linear equation
        double a = (y1 - y2);
        double b = (-x1 + x2);
        double c = (y3 - y4);
        double d = (-x3 + x4);
        double e = -y1 * (x1 - x2) + (y1 - y2) * x1;
        double f = -y3 * (x3 - x4) + (y3 - y4) * x3;

        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);

        if (equation.isSolvable()) {
          System.out.println("The intersecting point is: (" +
            equation.getX() + ", " + equation.getY() + ")");
        }
        else {
          System.out.println("The two lines do not cross ");
        }
    }

    private static void Question_13(Scanner s) {
    }

    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        // Question_01(s);
        // Question_02(s);
        // Question_03(s);
        // Question_04(s);
        // Question_05(s);
        // Question_06(s);
        Question_07(s);
        // Question_08(s);
        Question_09(s);
        // Question_10(s);
        Question_11(s);
        // Question_12(s);
        Question_13(s);

        s.close();
    }
}
