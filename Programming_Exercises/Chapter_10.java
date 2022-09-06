package Programming_Exercises;

import java.util.Scanner;
import Classes.*;
import Commons.Util;

public class Chapter_10 {
    private static void Question_01(Scanner s) {
        System.out.println(new Time(7));
        System.out.println(new Time(555550000l));
        System.out.println(new Time(5, 23, 55));
    }

    private static void Question_02(Scanner s) {
        BMI bmi1 = new BMI("John Doe", 18, 145, 5, 10);
        System.out.println("The BMI for " + bmi1.getName() + " is "
          + bmi1.getBMI() + " " + bmi1.getStatus());
        
        BMI bmi2 = new BMI("Peter King", 215, 5, 10);
        System.out.println("The BMI for " + bmi2.getName() + " is "
          + bmi2.getBMI() + " " + bmi2.getStatus());
    }

    private static void Question_03(Scanner s) {
    }

    private static void Question_04(Scanner s) {
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);
        System.out.println(p1.distance(p2));
        System.out.println(MyPoint.distance(p1, p2));
    }

    private static void Question_05(Scanner s) {
    }

    private static void Question_06(Scanner s) {
        final int LIMIT = 120;
        StackOfIntegers stack = new StackOfIntegers();
        
        // Repeatedly find prime numbers
        for (int number = 2; number < LIMIT; number++)
            if (Util.isPrime(number)) {
            stack.push(number);
        }

        // Print the first 30 prime numbers in decreasing order
        System.out.println("The prime numbers less than 120 are \n");
        final int NUMBER_PER_LINE = 10;

        while (!stack.empty()) {
            System.out.print(String.format("%3s", stack.pop()) + " ");

            if (stack.getSize() % NUMBER_PER_LINE == 0)
            System.out.println(); // advance to the new line
        }
    }

    private static void Question_07(Scanner s) {
    }

    private static void Question_08(Scanner s) {
        int[][] bracketsFor2001 = {
            {27050, 65550, 136750, 297350}, // Single filer
            {45200, 109250, 166500, 297350}, // married filing jointly
            {22600, 54625, 83250, 148675}, // married filing separately
            {36250, 93650, 151650, 297350} // head of household
        };
      
        double[] ratesFor2001 = {0.15, 0.275, 0.305, 0.355, 0.391};
      
        int[][] bracketsFor2002 = {
            {6000, 27950, 67700, 141250, 307050}, // Single filer
            {12000 , 46700, 112850, 171950, 307050}, // married filing jointly
            {6000, 23350, 56425, 85975, 153525}, // married filing separately
            {10000, 37450, 96700, 156600, 307050} // head of household
        };
      
        double[] ratesFor2002 = {0.1, 0.15, 0.27, 0.30, 0.35, 0.386};
    
        Tax taxFor2001 = new Tax(0, bracketsFor2001, ratesFor2001, 50000);
        System.out.println("2001 Tax Table");
        System.out.println("taxable\tSingle\tMarried\tMarried  Head of");
        System.out.println("Income\tSingle\tJoint\tSeparate a House");
        for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
            taxFor2001.setTaxableIncome(taxableIncome);
            taxFor2001.setFilingStatus(0);
            int taxForStatus0 = (int)taxFor2001.findTax();
            taxFor2001.setFilingStatus(1);
            int taxForStatus1 = (int)taxFor2001.findTax();
            taxFor2001.setFilingStatus(2);
            int taxForStatus2 = (int)taxFor2001.findTax();
            taxFor2001.setFilingStatus(3);
            int taxForStatus3 = (int)taxFor2001.findTax();
            System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
                taxForStatus1 + "\t" + taxForStatus2 + "\t " +
                taxForStatus3);
        }
      
        Tax taxFor2002 = new Tax(0, bracketsFor2002, ratesFor2002, 50000);
        System.out.println("2002 Tax Table");
        System.out.println("taxable\tSingle\tMarried\tMarried  Head of");
        System.out.println("Income\tSingle\tJoint\tSeparate a House");
        for (int taxableIncome = 50000; taxableIncome <= 60000; taxableIncome += 1000) {
            taxFor2002.setTaxableIncome(taxableIncome);
            taxFor2002.setFilingStatus(0);
            int taxForStatus0 = (int)taxFor2002.findTax();
            taxFor2002.setFilingStatus(1);
            int taxForStatus1 = (int)taxFor2002.findTax();
            taxFor2002.setFilingStatus(2);
            int taxForStatus2 = (int)taxFor2002.findTax();
            taxFor2002.setFilingStatus(3);
            int taxForStatus3 = (int)taxFor2002.findTax();
            System.out.println(taxableIncome + "\t" + taxForStatus0 + "\t" +
                taxForStatus1 + "\t" + taxForStatus2 + "\t " +
                taxForStatus3);
        }
    }
    

    private static void Question_09(Scanner s) {
    }

    private static void Question_10(Scanner s) {
        BasicQueue queue = new BasicQueue();
        
        // Repeatedly find prime numbers
        for (int n = 1; n <= 20; n++) {
            queue.enqueue(n);
        }

        for (int n = 1; n <= 21; n++) {
            System.out.println(queue.dequeue());
        }        
    }

    private static void Question_11(Scanner s) {
    }

    private static void Question_12(Scanner s) {
        // Triangle2D r1 = new Triangle2D(2, 2, 5.5, 4.9, 9.0, 10.3);
        // System.out.println("Area is " + r1.getArea());
        // System.out.println("Perimeter is " + r1.getPerimeter());
        // System.out.println(r1.contains(3, 3));
        // System.out.println(r1.contains(new Triangle2D(4, 5, 10.5, 3.2, -0.5, -10.5)));
        // System.out.println(r1.overlaps(new Triangle2D(3, 5, 2.3, 6.7, 5.5, 8.8)));
    }

    private static void Question_13(Scanner s) {

    }

    private static void Question_14(Scanner s) {
        MyDate date = new MyDate();
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("day: " + date.getDay());
        
        date = new MyDate(561555550000L);
        System.out.println("year: " + date.getYear());
        System.out.println("month: " + date.getMonth());
        System.out.println("day: " + date.getDay());
    }

    private static void Question_15(Scanner s) {
    }

    private static void Question_16(Scanner s) {
    }

    private static void Question_17(Scanner s) {
    }

    private static void Question_18(Scanner s) {
    }

    private static void Question_19(Scanner s) {
    }

    private static void Question_20(Scanner s) {
    }

    private static void Question_21(Scanner s) {
    }

    private static void Question_22(Scanner s) {
    }

    private static void Question_23(Scanner s) {
    }

    private static void Question_24(Scanner s) {
    }

    private static void Question_25(Scanner s) {
    }

    private static void Question_26(Scanner s) {
    }

    private static void Question_27(Scanner s) {
    }

    private static void Question_28(Scanner s) {
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Question_01(s);
        // Question_02(s);
        Question_03(s);
        // Question_04(s);
        Question_05(s);
        // Question_06(s);
        Question_07(s);
        // Question_08(s);
        Question_09(s);
        // Question_10(s);
        Question_11(s);
        Question_12(s);
        Question_13(s);
        Question_14(s);
        Question_15(s);
        Question_16(s);
        Question_17(s);
        Question_18(s);
        Question_19(s);
        Question_20(s);
        Question_21(s);
        Question_22(s);
        Question_23(s);
        Question_24(s);
        Question_25(s);
        Question_26(s);
        Question_27(s);
        Question_28(s);

        s.close();
    }  
}
