package Programming_Exercises;

import java.util.Scanner;

import Commons.EX_TB;
import Commons.Util;


public class Chapter_02 {

    private static void Question_01(Scanner s) {
        System.out.print("Enter a degree in Celsius: ");
        double celsius = s.nextDouble();
        double fahrenheit = (9.0 / 5.0) * celsius + 32;

        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }

    private static void Question_02(Scanner s) {
        System.out.print("Enter the radius and length of a cylinder: ");
        double radius = s.nextDouble();
        int length = s.nextInt();
        
        double area = Math.pow(radius, 2) * Math.PI;
        double volume = area * length; 

        System.out.println("The are is " + Util.MyRound(area, Util._4TH));
        System.out.println("The volume is " + Util.MyRound(volume, Util._1ST));
    }

    private static void Question_03(Scanner s) {
        System.out.print("Enter a value for feet: ");

        double feet = s.nextDouble();
        double meters = Util.MyRound(feet * Util.F_to_M, Util._4TH);

        System.out.println(feet + " feet is " + meters + " meters");
    }

    private static void Question_04(Scanner s) {
        System.out.print("Enter a number in pounds: ");

        double pounds = s.nextDouble();
        double kilograms = Util.MyRound(pounds * Util.P_to_K, Util._3RD);

        System.out.println(pounds + " pounds is " + kilograms + " kilograms");
    }

    private static void Question_05(Scanner s) {
        System.out.print("Enter the subtotal and a gratuity rate: ");
        
        int subtotal = s.nextInt();
        double gratuityRate = s.nextInt() / 100.0;
        double gratuity = subtotal * gratuityRate;
        double total = subtotal + gratuity;

        System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
    }

    private static void Question_06(Scanner s) {
        System.out.print("Enter a number between 0 and 1000: ");
        int number = s.nextInt();
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("The sum of the digits is " + sum);
    }

    private static void Question_07(Scanner s) {
        System.out.print("Enter the number of minutes: ");
        long minutes = s.nextLong();
        long perDay = 60 * 24; 
        long totalDays = minutes / perDay;

        long years = totalDays / 365;
        long days = totalDays % 365;

        System.out.println(minutes + " minutes is approximately " + years + " years and " + days + " days");
    }

    private static void Question_08(Scanner s) {
        System.out.print("Enter the time zone offset to GMT: ");
        int GMT = s.nextInt();

        EX_TB.ShowCurrentTime(GMT);
    }

    private static void Question_09(Scanner s) {
        System.out.println("Enter v0, v1, and t: ");

        double v0 = s.nextDouble();
        double v1 = s.nextDouble();
        double t = s.nextDouble();

        double a = (v1 - v0) / t; 

        System.out.println("The average accelearation is " + Util.MyRound(a, Util._4TH));
    }
    private static void Question_10(Scanner s) {
        System.out.print("Enter the amount of water in kilograms: ");
        double M = s.nextDouble();

        System.out.print("Enter the initial temperature: ");
        double initialTemperature = s.nextDouble();

        System.out.print("Enter the final temperature: ");
        double finalTemperature = s.nextDouble();

        double Q = M * (finalTemperature - initialTemperature) * 4184; 
        System.out.println("The energy needed is " + Util.MyRound(Q, Util._1ST));
    }

    private static void Question_11(Scanner s) {
        System.out.print("Enter the number of years: ");
        int y = s.nextInt();

        long totalSecond = y * 60 * 60 * 24 * 365;

        int birth = (int)(totalSecond / 7);
        int death = (int)(totalSecond / 13);
        int immigrant = (int)(totalSecond / 45);
        
        int population = 312032485 + birth - death + immigrant;
        System.out.println("The population in "+ y + " years is "+ population);
    }

    private static void Question_12(Scanner s) {
        System.out.print("Enter speed and acceleration: ");

        int speed = s.nextInt();
        double a = s.nextDouble();

        double length = Math.pow(speed, 2) / (2 * a);

        System.out.println("The minimum runway length for this airplane is " + Util.MyRound(length, Util._3RD));
    }

    private static void Question_13(Scanner s) {
        System.out.print("Enter the monthly saving amount: ");
        int savingAmount = s.nextInt();
        double savingAccount = 0;
        double annualInterestRate = 5 / 100.0;
        double monthlyInterestRate = annualInterestRate / 12;

        for(int i = 0; i < 6; i++) {
            savingAccount = (savingAmount + savingAccount) * (1 + monthlyInterestRate);
        }

        System.out.println("After the sixth month, the account value is " + Util.MyRound(savingAccount, Util._2ND));
    }

    private static void Question_14(Scanner s) {
        System.out.print("Enter weight in pounds: ");
        double pounds = s.nextDouble();

        System.out.print("Enter height in inches: ");
        int inches = s.nextInt();

        double meters = inches * Util.I_to_M;
        double kilograms = pounds * Util.P_to_K; 

        double BMI = kilograms / Math.pow(meters, 2);

        System.out.println("BMI is " + Util.MyRound(BMI, Util._4TH));
    }

    private static void Question_15(Scanner s) {
        double x1, x2, y1, y2;
        System.out.print("Enter x1 and y1: ");
        x1 = s.nextDouble();
        y1 = s.nextDouble();

        System.out.print("Enter x2 and y2: ");
        x2 = s.nextDouble();
        y2 = s.nextDouble();

        double d = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        
        System.out.println("The distance between the two point is " + d);
    }

    private static void Question_16(Scanner s) {
        System.out.print("Enter the length of the side: ");

        double side = s.nextDouble();
        double area = 3 * Math.sqrt(3) * Math.pow(side, 2) / 2;

        System.out.println("The area of the hexagon is " + Util.MyRound(area, Util._4TH));
    }

    private static void Question_17(Scanner s) {
        System.out.print("Enter the temperature in Fahrenheit between -58°F and 41°F: ");
        double fahrenheit = s.nextDouble();
        System.out.print("Enter the wind speed (>=2) in miles per hour: ");
        int speed = s.nextInt();
        
        double windChill = Util.GetWindChill(fahrenheit, speed);
        
        System.err.println("The wind Chill index is " + Util.MyRound(windChill, Util._5TH));
    }

    private static void Question_18(Scanner s) {
        System.out.println(" a       | b       | pow(a,b)       ");

        for (int i = 1; i <= 5; i++) {
            System.out.println(" " + i + "       | " + (i + 1) + "       | " + (int)Math.pow(i, i + 1));
        }
    }

    private static void Question_19(Scanner s) {
        double x1, y1, x2, y2, x3, y3; 

        System.out.print("Enter the coordinates of three points separated by spaces like x1 y1 x2 y2 x3 y3: ");

        x1 = s.nextDouble();
        y1 = s.nextDouble();
        x2 = s.nextDouble();
        y2 = s.nextDouble();
        x3 = s.nextDouble();
        y3 = s.nextDouble();

        double area = Util.GetAreaOfTriangleUsingPoints(x1, y1, x2, y2, x3, y3);

        System.out.println("The area of the triangle is " + Util.MyRound(area, Util._1ST));
    }

    private static void Question_20(Scanner s) {
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
        int balance = s.nextInt();
        double annualInterestRate = s.nextDouble() / 100;
        
        double interest = balance * annualInterestRate / 12;
        System.out.println("The interest is " + Util.MyRound(interest, Util._5TH));
    }

    private static void Question_21(Scanner s) {
        System.out.print("Enter investment amount: ");
        double amount = s.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestRate = s.nextDouble() / 100.0;
        double monthlyInterestRate = annualInterestRate / 12;

        System.out.print("Enter number of years: ");
        int year = s.nextInt();

        double futureValue = amount * Math.pow(1 + monthlyInterestRate, year * 12);
        System.out.println("Future value is $" + Util.MyRound(futureValue, Util._2ND));
    }

    private static void Question_22(Scanner s) {
         
        System.out.print("Enter an amount in double, for example 1156 (=$11.56): ");
        double amount = s.nextDouble();

        EX_TB.PrintChange(amount);
       
    }

    private static void Question_23(Scanner s) {
        System.out.print("Enter the driving distance: ");
        double d = s.nextDouble();

        System.out.print("Enter miles per gallon: ");
        double m_per_g = s.nextDouble();

        System.out.print("Enter price per gallon: ");
        double p_per_g = s.nextDouble();

        double cost = d / m_per_g * p_per_g;

        System.out.println("The cost of driving is $" + Util.MyRound(cost, Util._2ND));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Question_01(s);
        // Question_02(s);
        // Question_03(s);
        // Question_04(s);
        // Question_05(s);
        // Question_06(s);
        // Question_07(s);
        // Question_08(s);
        // Question_09(s);
        // Question_10(s);
        // Question_11(s);
        // Question_12(s);
        // Question_13(s);
        // Question_14(s);
        // Question_15(s);
        // Question_16(s);
        // Question_17(s);
        // Question_18(s);
        // Question_19(s);
        // Question_20(s);
        // Question_21(s);
        // Question_22(s);
        // Question_23(s);

        s.close();
    }
}
