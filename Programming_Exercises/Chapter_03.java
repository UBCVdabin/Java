package Programming_Exercises;

import java.util.Scanner;

import Commons.*;

public class Chapter_03 {
    private static void Question_01(Scanner s) {
        double a, b, c, D;

        System.out.print("Enter a, b, c: ");

        a = s.nextDouble();
        b = s.nextDouble();
        c = s.nextDouble();
        
        D = Math.pow(b, 2) - (4 * a * c);

        if (D > 0) {
            D = Math.pow(D, 0.5);

            double root_A, root_B;

            root_A = (-b + D) / (2 * a);
            root_B = (-b - D) / (2 * a);

            System.out.println("The equation has two roots " + Util.MyRound(root_A, Util._5TH) + " and " + Util.MyRound(root_B, Util._5TH));
        }
        else if (D < 0) {
            System.out.println("The equation has no real roots");           

        }
        else {
            D = Math.pow(D, 0.5);

            double root = (-b) / (2 * a);

            System.out.println("The equation has one root " + root);
        }

    }

    private static void Question_02(Scanner s) {
        int number1 = Util.RandInt(1, 9, true, true);
        int number2 = Util.RandInt(1, 9, true, true);
        int number3 = Util.RandInt(1, 9, true, true);     

        System.out.print("What is " + number1 + " + " + number2 + " + " + number3 +" ? "); 

        int answer = s.nextInt();

        System.out.println(                                             
        number1 + " + " + number2 + " + " + number3 + " = " + answer + " is " +
        (number1 + number2 + number3 == answer));
    }

    private static void Question_03(Scanner s) {
        double a, b, c, d, e, f;
        System.out.print("Enter a, b, c, d, e, f: ");

        a = s.nextDouble();
        b = s.nextDouble();
        c = s.nextDouble();
        d = s.nextDouble();
        e = s.nextDouble();
        f = s.nextDouble();


        double x, y, detA;

        detA = a * d - b * c;

        if (Util.DblEquals(detA, 0, Util._8TH_DP)) {
            System.out.println("The equation has no solution.");
        }
        else {
            x = (e * d - f * b) / detA;
            y = (a * f - e * c) / detA;

            System.out.println("x is " + x + " and y is " + y);
        }
    }

    private static void Question_04(Scanner s) {
        int month = Util.RandInt(1, 12);

        System.out.println(month + " is " + MyCalendar.MonthofIntToString(month));
    }

    private static void Question_05(Scanner s) {
        int today, dayAfter, future_Day;

        System.out.print("Enter today's day: ");
        today = s.nextInt();

        System.out.print("Enter the number of days elapsed since today: ");
        dayAfter = s.nextInt();

        future_Day = (today + dayAfter) % 7;

        System.out.println("Today is " + MyCalendar.DayofIntToString(today) + " and the future day is " + MyCalendar.DayofIntToString(future_Day));
    }

    private static void Question_06(Scanner s) {
        System.out.print("Enter weight in pounds: ");
        double pounds = s.nextInt();

        System.out.print("Enter feet: ");
        int feet = s.nextInt();

        System.out.print("Enter inches: ");
        int inches = s.nextInt();

        double kilograms = pounds * Util.P_to_K;
        double meters = feet * Util.F_to_M + inches * Util.I_to_M;

        double bmi = kilograms / Math.pow(meters, 2);

        System.out.println("BMI is " + bmi);   

        if (bmi < 18.5)
            System.out.println("Underweight");
        else if (bmi < 25)
            System.out.println("Normal");
        else if (bmi < 30)
            System.out.println("Overweight");
        else 
            System.out.println("Obese");
    }

    private static void Question_07(Scanner s) {
        System.out.print("Enter an amount in double, for example 11.56: ");
        double amount = s.nextDouble();

        EX_TB.ComputeChange(amount);
    }

    private static void Question_08(Scanner s) {
        int number1, number2, number3;

        System.out.print("Enter integers A,B and C: ");

        number1 = s.nextInt();
        number2 = s.nextInt();
        number3 = s.nextInt();

        
        if (number1 > number2) {
            int temp = number1;
            number1 = number2; 
            number2 = temp;
        }

        if (number1 > number3) {
            int temp = number1;
            number1 = number3; 
            number3 = temp;
        }
        if (number2 > number3) {
            int temp = number2;
            number2 = number3; 
            number3 = temp;
        }
        
        System.out.println("Increasing Order : " + number1 + " < " + number2 + " < " + number3);
    }

    private static void Question_09(Scanner s) {
        int ISBN, temp, sum = 0, lastDigit;
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        temp = ISBN = s.nextInt();

  

        for (int i = 1; i <= 9; i++) {
            sum += temp / (int)Math.pow(10, 9 - i) * i;
            temp %= (int)Math.pow(10, 9 - i);
        }
        lastDigit = sum % 11;
        System.out.println("The ISBN-10 number is " + ISBN + (lastDigit == 10 ? "X" : lastDigit));
    }

    private static void Question_10(Scanner s) {
        // 1. Generate two random single-digit integers
        int number1 = Util.RandInt(1, 99);                                       
        int number2 = Util.RandInt(1, 99);

        // 2. If number1 < number2, swap number1 with number2
        if (number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        } 

        // 3. Prompt the student to answer "What is number1 - number2?"
        System.out.print("What is " + number1 + " - " + number2 + "? ");
        int answer = s.nextInt(); 

        // 4. Grade the answer and display the result
         if (number1 - number2 == answer)
            System.out.println("You are correct!");
        else {
            System.out.println("Your answer is wrong.");
            System.out.println(number1 + " - " + number2 + " should be " + (number1 - number2));
        }
    }

    private static void Question_11(Scanner s) {
        int month, year;
        System.out.print("Enter month, year: ");
        
        month = s.nextInt();
        year = s.nextInt();
        
        if (year < 0 || month < 0 || month > 12) {
            System.out.println("Invalid Date");
            return;        
        }

        System.out.println(MyCalendar.MonthofIntToString(month)  + " " + year + " has " + MyCalendar.GetDayofMonth(month, year) + " days");
    }

    private static void Question_12(Scanner s) {
        int num, palindrome;
        System.out.print("Enter a three-digit integer: ");
        num = s.nextInt();

        palindrome = Util.Palindrome(num);

        System.out.println(num + " is " + (num == palindrome ? "" : "not ") + "a palindrome");
    }

    private static void Question_13(Scanner s) {
        // Prompt the user to enter filing status
        System.out.print("(0-single filer, 1-married jointly or " +
            "qualifying widow(er), 2-married separately, 3-head of " +
            "household) Enter the filing status: ");
        
        int status = s.nextInt();                                  
        
        // Prompt the user to enter taxable income 
        System.out.print("Enter the taxable income: ");                
        double income = s.nextDouble();
        
        // Compute tax                                                 
        double tax = 0;
        
        if (status == 0) { // Compute tax for single filers          
            if (income <= 8350)
                tax = income * 0.10;
            else if (income <= 33950)
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <= 82250)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (income - 33950) * 0.25;
            else if (income <= 171550)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            else if (income <= 372950)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                    (income - 171550) * 0.33;
            else
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 +
                    (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
        }
        else if (status == 1) { // Left as an exercise 
            // Compute tax for married file jointly or qualifying widow(er)
            if (income <= 16700)
                tax = income * 0.10;
            else if (income <= 67900)
                tax = 16700 * 0.10 + (income - 16700) * 0.15;
            else if (income <= 137050)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                    (income - 67900) * 0.25;
            else if (income <= 208850)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                    (137050 - 67900) * 0.25 + (income - 82250) * 0.28;
            else if (income <= 372950)
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                    (137050 - 67900) * 0.25 + (208850 - 82250) * 0.28 + 
                    (income - 208850) * 0.33;
            else
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                      (82250 - 33950) * 0.25 + (208850 - 82250) * 0.28 + 
                      (372950 - 208850) * 0.33 + (income - 372950) * 0.35; 
        }
        else if (status == 2) { // Compute tax for married separately 
                // Left as an exercise in Programming Exercise 3.13
            if (income <= 8350)
                tax = income * 0.10;
            else if (income <= 33950)
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            else if (income <= 68525)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + 
                    (income - 33950) * 0.25;
            else if (income <= 104425)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + 
                    (68525 - 33950) * 0.25 + (income - 68525) * 0.28;
            else if (income <= 186475)
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + 
                    (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + 
                    (income - 104425) * 0.33;
            else
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + 
                      (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + 
                      (186475 - 104425) * 0.33 + (income - 186475) * 0.35;        
        }
        else if (status == 3) { // Compute tax for head of household
                // Left as an exercise in Programming Exercise 3.13
            if (income <= 11950)
                tax = income * 0.10;
            else if (income <= 45500)
                tax = 11950 * 0.10 + (income - 11950) * 0.15;
            else if (income <= 117450)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (income - 45500) * 0.25;
            else if (income <= 190200)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
            else if (income <= 372950)
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + 
                    (income - 190200) * 0.33;
            else
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + 
                    (372950 - 190200) * 0.33 + (income - 372950) * 0.35;        
        }
        else { 
            System.out.println("Error: invalid status");
            System.exit(1);
        }
        
        System.out.println("Tax is " + (int)(tax * 100) / 100.0);
    }
    
    private static void Question_14(Scanner s) {
        int coin = Util.RandInt(0, 1);

        System.out.print("Does the coin display the head or tail?\n Enter your guess [i.g 0(=head), 1(=tail)] :");
        int userGuess = s.nextInt();
        
        if (coin == userGuess)
            System.out.println("You are correct!");
        else
            System.out.println("You are wrong..");
    }

    private static void Question_15(Scanner s) {
        int lottery = Util.RandInt(000, 999);

        int d1 = Util.FindDigitNumber(lottery, Util._1ST);
        int d2 = Util.FindDigitNumber(lottery, Util._2ND);
        int d3 = Util.FindDigitNumber(lottery, Util._3RD);
        
        System.out.print("Enter your lottery pick (three digits): ");
        int guess = s.nextInt();

        int g1 = Util.FindDigitNumber(guess, Util._1ST);
        int g2 = Util.FindDigitNumber(guess, Util._2ND);
        int g3 = Util.FindDigitNumber(guess, Util._3RD);


        System.out.println("The lottery number is " + lottery);

        if (guess == lottery) {
            System.out.println("Exact match: you win $10,000");
        }
        else if ((d1 == g1 && d2 == g3 && d3 == g2) || (d1 == g2 && d2 == g1 && d3 == g3)  || 
                (d1 == g2 && d2 == g3 && d3 == g1)  || (d1 == g3 && d2 == g1 && d3 == g2)  || 
                (d1 == g3 && d2 == g2 && d3 == g1)) {
            System.out.println("Match all digits: you win $3,000");
        }
        else if (d1 == g1 || d1 == g2 || d1 == g3 || d2 == g1 || d2 == g2 || d2 == g3 || d3 == g1 || d3 == g2 || d3 == g3) {
            System.out.println("Match one digit: you win $1,000");
        }
        else {
            System.out.println("Sorry, no match");
        }
    }

    private static void Question_16(Scanner s) {
        int x = Util.RandInt(1, 50);
        int y = Util.RandInt(1, 100);

        System.out.println("The rectangle is centered at (0, 0) with width " + x * 2 +  " and height " + y * 2 + ".");
    }

    private static void Question_17(Scanner s) {
        int computer = Util.RandInt(0, 2);

        System.out.print("scissor (0), rock (1), paper (2): ");

        int yourChoice = s.nextInt();

        if (yourChoice > 2 || yourChoice < 0) {
            System.out.println("Invalid input...");
            return;
        }

        if (computer == 0) {
            if (yourChoice == 0) {
                System.out.println("The computer is scissor. You are scissor too. It is a draw.");  
            }
            else if (yourChoice == 1) {
                System.out.println("The computer is scissor. You are rock. You win");
            }
            else {
                System.out.println("The computer is scissor. You are paper. You lost");
            }
        }

        else if (computer == 1) {
            if (yourChoice == 0) {
                System.out.println("The computer is rock. You are scissor. You lost");  
            }
            else if (yourChoice == 1) {
                System.out.println("The computer is rock. You are rock too. It is a draw");
            }
            else {
                System.out.println("The computer is rock. You are paper. You won");
            }
        }
        else {
            if (yourChoice == 0) {
                System.out.println("The computer is paper. You are scissor. You won");
            }
            else if (yourChoice == 1) {
                System.out.println("The computer is paper. You are rock. You lost");
            }
            else {
                System.out.println("The computer is paper. You are paper too. It is a draw");
            }
        }
    }

    private static void Question_18(Scanner s) {
        System.out.print("Enter the weight of the package: ");
        double cost, weight = s.nextDouble();

        // 참고: 두 개의 double 형 변수들을 비교할 때 컴퓨터 상에서는 비교가 불가능함 (제한된 메모리로 인한 비교 불가) 
        // 그러나 컴파일러는 소수점 14자리까지 비교 가능해준다.
        if (weight <= 0) {
            System.out.println("Invalid input.");
            return;
        }
        else if (weight > 0 && weight < 5.5) {
            cost = weight * 1;
        }
        else if (weight >= 5.5 && weight < 8.5) {
            cost = weight * 3;
        }
        else if (weight >= 8.5 && weight < 10.5) {
            cost = weight * 10;
        }
        else if (weight >= 10.5 && weight <= 20) {
            cost = weight * 20;
        }
        else {
            System.out.println("The package cannot be shipped.");
            return;
        }
        System.out.println("The shipping cost is " + Util.MyRound(cost, Util._2ND));
    }

    private static void Question_19(Scanner s) {
        double a, b, c, temp;
        
        System.out.print("Enter three edges for a triangle: ");
        
        a = s.nextDouble();
        b = s.nextDouble();
        c = s.nextDouble(); 

        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        
        if (a < c) {
            temp = a;
            a = c;
            c = temp;
        }        
        if (a < b + c) {
            System.out.println("The perimeter is " + (a + b + c));
        }
        else {
            System.out.println("The input is invalid");
        }
    }

    private static void Question_20(Scanner s) {
        System.out.print("Enter the temperature in Fahrenheit: ");

        double windChillIndex, fahrenheit = s.nextDouble(); 
        
        if (fahrenheit < -58 || fahrenheit > 41) {
            System.out.println("Temperature must be between -58F and 41F");
            return;
        }
        
        System.out.print("Enter the wind speed miles per hour: ");
        int speed = s.nextInt();
            
        if (speed < 2) {
            System.out.println("Speed must be greater than or equal to 2");  
            return;
        }
            
        windChillIndex = Util.GetWindChill(fahrenheit, speed);       
        System.out.println("The wind chill index is " + Util.MyRound(windChillIndex, Util._5TH));
    }

    private static void Question_21(Scanner s) {
        int year, month, day; 
        
        System.out.print("Enter year (e.g., 2012): ");
        year = s.nextInt();

        System.out.print("Enter month (1-12): ");
        month = s.nextInt();

        System.out.print("Enter the day of the month (1-31): ");
        day = s.nextInt();

        if (year < 0 || month < 1 || month > 12 || day < 1 || day > 31) {
            System.out.println("Invalid input...");
        }

        if (!MyCalendar.CheckLeapYear(year) && month == 2 && day > 28) {
            System.out.println("The year " + year + " is a not leap year...");
        }
   
        System.out.println("Day of the week is " + MyCalendar.DayofIntToString_Zeller(MyCalendar.GetDayOfTheWeek(year, month, day)));
    }

    private static void Question_22(Scanner s) {
        double x, y, dist, radius = 10.0;

        System.out.print("Enter a point with two coordinates: ");

        x = s.nextDouble();
        y = s.nextDouble();

        dist = Util.GetDistance(x, y);

        if (dist <= radius) {
            System.out.println("Point (" + x + ", " + y + ") is in the circle");
        }
        else {
            System.out.println("Point (" + x + ", " + y + ") is not in the circle");
        }
    }

    private static void Question_23(Scanner s) {
        double x, y, width = 5, height = 2.5;

        System.out.print("Enter a point with two coordinates: ");
        
        x = s.nextDouble();
        y = s.nextDouble();

        if (Math.abs(x) > width || Math.abs(y) > height) {
            System.out.println("Point (" + x + ", " + y + ") is not in the rectangle");
        }
        else {
            System.out.println("Point (" + x + ", " + y + ") is in the rectangle");
        }
    }

    private static void Question_24(Scanner s) {
        int card = Util.RandInt(1, 52);

        System.out.println("The card you picked is the " + Util.GetRankOfCard(card) + " of " + Util.GetSuitOfCard(card));
    }

    private static void Question_25(Scanner s) {
        double x, y, x1, y1, x2, y2, x3, y3, x4, y4;
        double a, b, c, d, e, f, slope;
        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        
        x1 = s.nextDouble();
        y1 = s.nextDouble();
        x2 = s.nextDouble();
        y2 = s.nextDouble();
        x3 = s.nextDouble();
        y3 = s.nextDouble();
        x4 = s.nextDouble();
        y4 = s.nextDouble();

        a = (y1 - y2);
        b = -(x1 - x2);
        c = (y3 - y4);
        d = -(x3 - x4);
        
        e = ((y1 - y2) * x1 - (x1 - x2) * y1);
        f = ((y3 - y4) * x3 - (x3 - x4) * y3);
        
        
        slope = b * c - a * d;
        x = ( d * e - b * f ) / (a * d - b * c );
        y = ( a * f - e * c ) / ( a * d - b * c );
        
        if (slope == 0) {
            if (e == f) {
                System.out.println("The two lines are the same");
            }
            else {
                System.out.println("The two lines are parallel");
            }
        }
        else {
            System.out.println("The intersecting point is at (" + Util.MyRound(x, Util._5TH) +  ", " + Util.MyRound(y, Util._5TH) + ")");
        }
    }

    private static void Question_26(Scanner s) {
        System.out.print("Enter an integer: ");
        int num = s.nextInt();
        
        System.out.println("Is 10 divisible by 5 and 6? " + (num % 5 == 0 && num % 6 == 0));
        System.out.println("Is 10 divisible by 5 or 6? " + (num % 5 == 0 || num % 6 == 0));
        System.out.println("Is 10 divisible by 5 or 6, but not both? " + ((num % 5 == 0 || num % 6 == 0) && !(num % 5 == 0 && num % 6 == 0)));
    }

    private static void Question_27(Scanner s) {
        double x, y, y1;

        System.out.print("Enter a point's x- and y-coordinates: ");

        x = s.nextDouble();
        y = s.nextDouble();

        // y = ax + b;
        y1 = (-1.0 / 2.0) * x + 100;

        if((x >= 0 && x <= 200) && (y >= 0 && y <= y1)) {
            System.out.println("The point is in the triangle");
        }
        else {
            System.out.println("The point is not in the triangle");
        }
    }

    private static void Question_28(Scanner s) {
        double x1, x2, y1, y2, w1, w2, h1, h2;
        double xDistance, yDistance;

        System.out.print("Enter r1's center x-, y-coordinates, width, and height: ");
        
        x1 = s.nextDouble();
        y1 = s.nextDouble();
        w1 = s.nextDouble();
        h1 = s.nextDouble();

        System.out.print("Enter r2's center x-, y-coordinates, width, and height: ");
        
        x2 = s.nextDouble();
        y2 = s.nextDouble();
        w2 = s.nextDouble();
        h2 = s.nextDouble();

        xDistance = Math.abs(x1 - x2);
        yDistance = Math.abs(y1 - y2);
        
        if (xDistance <= (w1 - w2) / 2 && yDistance <= (h1 - h2) / 2) {
            System.out.println("r2 is inside r1");
        }
        else if (xDistance <= (w1 + w2) / 2 && yDistance <= (h1 + h2) / 2) {
            System.out.println("r2 overlaps r1");
        }
        else {
            System.out.println("r2 does not overlap r1");
        }
    }

    private static void Question_29(Scanner s) {
        double x1, x2, y1, y2, radius1, radius2, distance;
        
        System.out.print("Enter circle1's center x-, y-coordinates, and radius: ");
        x1 = s.nextDouble();
        y1 = s.nextDouble();
        radius1 = s.nextDouble();

        System.out.print("Enter circle2's center x-, y-coordinates, and radius: ");
        x2 = s.nextDouble();
        y2 = s.nextDouble();
        radius2 = s.nextDouble();

        distance = Util.GetDistance(x1, y1, x2, y2);

        
        if (radius1 >= (distance + radius2)) {
            System.out.println("circle2 is inside circle1");
        }
        else if (radius1 > (distance - radius2)) {
            System.out.println("circle2 overlaps circle1");
        }
        else {
            System.out.println("circle2 does not overlap circle1");
        }
    }

    private static void Question_30(Scanner s) {
        System.out.print("Enter the time zone offset to GMT: ");
        int GMT = s.nextInt();

        EX_TB.ShowCurrentTime(GMT);
    }

    private static void Question_31(Scanner s) {
        System.out.print("Enter the exchange rate from dollars to RMB: ");
        double amount, exchange, RMB = s.nextDouble();
        
        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        int covertMode = s.nextInt();
        

        if (covertMode == 0) {
            System.out.print("Enter the dollar amount: ");
            amount = s.nextDouble();
            exchange = amount * RMB;
            System.out.println("$"+ amount + " is " + Util.MyRound(exchange, Util._2ND) + " yuan");
        }
        else if (covertMode == 1) {
            System.out.print("Enter the RMB amount: ");
            amount = s.nextDouble();
            exchange = amount / RMB;
            System.out.println(amount + " yuan is $" + Util.MyRound(exchange, Util._2ND));
        }
        else {
            System.out.println("Incorrect Input...");
        }
    }

    private static void Question_32(Scanner s) {
        double x0, y0, x1, y1, x2, y2;

        System.out.print("Enter three points for p0, p1, and p2: ");

        x0 = s.nextDouble();
        y0 = s.nextDouble();
        x1 = s.nextDouble();
        y1 = s.nextDouble();
        x2 = s.nextDouble();
        y2 = s.nextDouble();

        PrintPointPosition(x0, y0, x1, y1, x2, y2);
    }

    private static void Question_33(Scanner s) {
        double w1, w2, p1, p2;
        double price_W_For_P1, price_W_For_P2;
        System.out.print("Enter weight and price for package 1: ");

        w1 = s.nextDouble();
        p1 = s.nextDouble();

        System.out.print("Enter weight and price for package 2: ");
        w2 = s.nextDouble();
        p2 = s.nextDouble();

        price_W_For_P1 = p1 / w1;
        price_W_For_P2 = p2 / w2;

        if (price_W_For_P1 > price_W_For_P2) {
            System.out.println("Package 2 has a better price");
        }
        else if (price_W_For_P1 < price_W_For_P2) {
            System.out.println("Package 1 has a better price");
        }
        else {
            System.out.println("Two packages have the same price");
        }
    }

    private static void Question_34(Scanner s) {
        double x0, y0, x1, y1, x2, y2, pos;

        System.out.print("Enter three points for p0, p1, and p2: ");

        x0 = s.nextDouble();
        y0 = s.nextDouble();
        x1 = s.nextDouble();
        y1 = s.nextDouble();
        x2 = s.nextDouble();
        y2 = s.nextDouble();

        PrintPointPosition(x0, y0, x1, y1, x2, y2);
    }

    private static void PrintPointPosition(double x0, double y0, double x1, double y1, double x2, double y2) {
        double pos = Util.GetPointPosition(x0, y0, x1, y1, x2, y2);
        
        if(pos < 0) {
            System.out.println("p2 is on the right side of the line");
        }
        else if (pos > 0) {
            System.out.println("p2 is on the left side of the line");
        }
        else {
            if (x2 >= x0 && x2 <= x1 && y2 >= y0 && y2 <= y1) {
                System.out.println("(" + x2 + ", " + y2 + ") is on the line segment from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
            }
            else {
                System.out.println("(" + x2 + ", " + y2 + ") is not on the line segment from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
            }
        }
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
        // Question_24(s);
        // Question_25(s);
        // Question_26(s);
        // Question_27(s);
        // Question_28(s);
        // Question_29(s);
        // Question_30(s);
        // Question_31(s);
        // Question_32(s);
        // Question_33(s);
        // Question_34(s);

        s.close();
    }
}
