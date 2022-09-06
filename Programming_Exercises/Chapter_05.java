package Programming_Exercises;

import java.util.Scanner;

import Commons.MyCalendar;
import Commons.StringUtils;
import Commons.Util;

public class Chapter_05 {
    private static void Question_01(Scanner s) {
        int n;
        int cnt_posit = 0, cnt_negat = 0;
        double sum = 0;

        System.out.print("Enter an integer, the input ends if it is 0: ");

        n = s.nextInt();

        while(n != 0) {
            if (n > 0) {
                cnt_posit++;
            }
            else {
                cnt_negat++;
            }
            sum += n;

            n = s.nextInt();
        }

        System.out.println("The number of positives is " + cnt_posit);  
        System.out.println("The number of negatives is " + cnt_negat);
        System.out.println("The total is " + sum);
        System.out.println("The average is " + sum / (cnt_posit + cnt_negat));
    }

    private static void Question_02(Scanner s) {      
        final int NUMBER_OF_QUESTIONS = 10; // Number of questions
        int correctCount = 0; // Count the number of correct answers
        int count = 0; // Count the number of questions
        long startTime = System.currentTimeMillis();
        String output = " "; // output string is initially empty

        while (count < NUMBER_OF_QUESTIONS) {
            // 1. Generate two random single-digit integers
            int number1 = Util.RandInt(1, 15);
            int number2 = Util.RandInt(1, 15);

            // 2. If number1 < number2, swap number1 with number2
            if (number1 < number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }

            // 3. Prompt the student to answer "What is number1 – number2?"
            System.out.print("What is " + number1 + " - " + number2 + "? ");
            int answer = s.nextInt();

            // 4. Grade the answer and display the result
            if (number1 - number2 == answer) {
                System.out.println("You are correct!");
                correctCount++; // Increase the correct answer count
            }
            else
                System.out.println("Your answer is wrong.\n" + number1 + " - " + number2 + 
                                    " should be " + (number1 - number2));

            // Increase the question count
            count++;

            output += "\n" + number1 + " - " + number2 + " = " + answer +
                    ((number1 - number2 == answer) ? " correct": " wrong");
      }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println("Correct count is " + correctCount +
                    "\nTest time is " + testTime / 1000 + " seconds\n" + output);
    }

    private static void Question_03(Scanner s) {
        System.out.println("Kilograms\tPounds");
        
        for (int i = 1; i < 200; i +=2) {
            System.out.println(i + "\t\t" + String.format("%5.1f", Util.MyRound(Util.K_to_P * i, 1)));
        }

    }

    private static void Question_04(Scanner s) {
        System.out.println("Miles\t\tKilometers");
        
        for (int i = 1; i < 11; i ++) {
            System.out.println(i + "\t\t" + String.format("%6.3f", Util.MyRound(Util.M_to_K * i, 3)));
        }
    }

    private static void Question_05(Scanner s) {
        int pounds = 20;

        System.out.println("Kilograms\tPounds\t|  Pounds\tKilograms");
        System.out.println("--------------------------------------------------");

        for (int i = 1; i < 200; i += 2) {
            System.out.print(i + "\t\t" + String.format("%6.1f", Util.MyRound(Util.K_to_P * i, 1)) + "\t|  ");
            System.out.println(pounds + "\t\t" + String.format("%6.2f", Util.MyRound(pounds / Util.K_to_P, 2)));
            pounds += 5;
        }
    }

    private static void Question_06(Scanner s) {
        int pounds = 20;

        System.out.println(String.format("%-15s", "Miles") + 
                        String.format("%-10s", "Kilometers") + "       |      " +
                        String.format("%-15s", "Kilometers") + 
                        String.format("%-10s", "Miles")
                        );
        System.out.println("-----------------------------------------------------------------");
        int miles = 1;
        int kilometers = 20;

        for (int i = 1; i <= 10; i ++) {
            System.out.print(String.format("%-15d", miles) + String.format("%-10.3f", Util.M_to_K * miles) + "       |      ");
            System.out.println(String.format("%-15d", kilometers) + String.format("%-10.3f", kilometers / Util.M_to_K));
            
            miles += 1;
            kilometers += 5;
        }
    }

    private static void Question_07(Scanner s) {
        double tuition = 10000, rate = 0.05, sum = 0;

        for (int i = 1; i <= 10; i++) {
            System.out.println("In " + i + " year, the tuition will be $" + Util.MyRound(tuition * Math.pow((1 + rate), i), 2));
        }

        System.out.println();

        for (int i = 1; i <= 4; i++) {
            sum += tuition * Math.pow((1 + rate), 10 + i); 
        }
        System.out.println("The total cost of four years’ worth of tuition starting after the tenth year is $" + Util.MyRound(sum, 2));
    }

    private static void Question_08(Scanner s) {
        System.out.print("Enter the number of student: ");
        int num = s.nextInt();
        
        if (num < 1) {
            System.out.println("The number of students is at least 1.");
            return;
        }

        int highestScore = 0;

        for (int i = 0; i < num; i++) {
            System.out.print("Enter the score: ");
            int score = s.nextInt();
            highestScore = highestScore < score ? score : highestScore;
        }

        System.out.println("The highest score is " + highestScore);
    }

    private static void Question_09(Scanner s) {
        System.out.print("Enter the number of student: ");
        int num = s.nextInt();
        
        if (num < 1) {
            System.out.println("The number of students is at least 1.");
            return;
        }

        int highestScore = 0;
        int secondHighestScore = 0;

        for (int i = 0; i < num; i++) {
            System.out.print("Enter the score: ");
            int score = s.nextInt();

            if (highestScore < score) {
                secondHighestScore = highestScore;
                highestScore = score;
            }

            secondHighestScore = (secondHighestScore < score && highestScore > score) ? score : secondHighestScore;
        }

        System.out.println("The highest score is " + highestScore);
        System.out.println("The second highest score is " + secondHighestScore);
    }

    private static void Question_10(Scanner s) {
        int count = 1;

        for (int i = 100; i <= 1000; i++) {
            if (i % 5 == 0 && i % 6 == 0) {
                if (count % 10 != 0) {
                    System.out.print(i + " ");
                }
                else {
                    System.out.println(i);
                }
                count += 1;
            }
        }
    }

    private static void Question_11(Scanner s) {
        int count = 1;

        for (int i = 100; i <= 200; i++) {
            if ((i % 5 == 0 || i % 6 == 0) && !(i % 5 == 0 && i % 6 == 0)) {
                if (count % 10 != 0) {
                    System.out.print(i + " ");
                }
                else {
                    System.out.println(i);
                }
                count ++;       
            }
        }
    }

    private static void Question_12(Scanner s) {
        int n = 0;
        while (Math.pow(n, 2) <= 12000) {
            n++;
        }
        System.out.println("The smallest integer n such that n2 is greater than 12,000 is " + n);
    }

    private static void Question_13(Scanner s) {
        int n = 0;
        while (Math.pow(n, 3) <= 12000) {
            n++;
        }
        System.out.println("The largest integer n such that n3 is less than 12,000 is " + (n - 1));
    }

    private static void Question_14(Scanner s) {
        int n1, n2, d;

        System.out.print("Enter first integer: ");
        n1 = s.nextInt();

        System.out.print("Enter second integer: ");
        n2 = s.nextInt();

        d = n1 < n2 ? n1 : n2;

        while (d >= 1) {
            if (n1 % d == 0 && n2 % d == 0) {
                break;
            }
            d -= 1;
        }
        System.out.println("GCD of " + n1 + " and " + n2 + " is " + d);
    }

    private static void Question_15(Scanner s) {
        int count = 1;

        for (int i = 0; i < 128; i++) {
            char ch = (char) i;  
            String display = "";  

            if (Character.isWhitespace(ch)) {  
                // using switch statement  
                switch (ch) {  
                    case '\r':  
                        display = "\\r";  
                        break;  
                    case '\t':  
                        display = "\\t";  
                        break;  
                    case '\n':  
                        display = "\\n";  
                        break;  
                    case '\f':  
                        display = "\\f";  
                        break;  
                    case ' ':  
                        display = "spce";  
                        break;  
                    default:  
                        display = "ws";  
                        break;  
                }  
                // detect characters that are not letters, digits and punctuation   
            } else if (Character.isISOControl(ch)) {  
                // showing control chars  
                display = "ctl";  
            } else {  
                // showing others chars  5
                display = Character.toString(ch);  
            }  

            // print
            if (count % 10 == 0) {
                System.out.println(display);
            }
            else {
                System.out.print(display + " ");
            }
            count++;
        }
    }

    private static void Question_16(Scanner s) {
        System.out.print("Enter an integer: ");
        int integer = s.nextInt();
        int divideNumber = 2;

        while (integer > 1) {
            if (integer % divideNumber == 0) {
                if (integer / divideNumber == 1) {
                    System.out.println(divideNumber);
                }
                else {
                    System.out.print(divideNumber + ", ");
                }

                integer /= divideNumber;
                divideNumber = 2;
            }
            else {
                divideNumber++;
            }    
        }
    }

    private static void Question_17(Scanner s) {
        int lines;
        System.out.print("Enter the number of lines: ");
        lines = s.nextInt();

        for (int i = 1; i <= lines; i++) {
            for (int j = i; j < lines; j++) {
                System.out.print("      ");
            }
            for (int j = i; j > 1; j--) {
                System.out.print(String.format("%-3d   ", j));
            }
            System.out.print(1);
            for (int j = 2; j < i + 1; j++) {
                System.out.print(String.format("   %3d", j));
            }
            for (int j = lines; j > i + 1; j--) {
                System.out.print("      ");
            }
            System.out.println();
        }
    }

    private static String pattern(int startIdx, int lastIdx, boolean isReverse, boolean isSpace) {
        String text = "";

        if (isReverse) {
            for (int i = startIdx; i > lastIdx; i--) {
                if (isSpace) {
                    for (int j = startIdx; j > i; j--) {
                        text += "  ";
                    }
                    for (int j = 1; j <= i; j++) {
                        text += j + " ";
                    }
                }
                else {
                    for (int j = 1; j <= i; j++) {
                        text += j + " ";
                    }
                }
                text += "\n";
            }
        }
        else {
            for (int i = startIdx; i <= lastIdx; i++) {
                if (isSpace) {
                    for (int j = 0; j < lastIdx - i; j++) {
                        text += "  ";
                    }
                    for (int j = i; j > 0; j--) {
                        text += j + " ";
                    }
                }
                else {
                    for (int j = 1; j <= i; j++) {
                        text += j + " ";
                    }
                }
                text += "\n";
            }
        }
        return text;
    }


    private static void Question_18(Scanner s) {
        String text = "";
        int integer;
        System.out.print("Enter an integer: ");
        integer = s.nextInt();

        // pattern 1
        text = pattern(1, integer, false, false);
        System.out.println(text);

        // pattern 2
        text = pattern(integer, 0, true, false);
        System.out.println(text);

        // pattern 3
        text = pattern(1, integer, false, true);
        System.out.println(text);
        
        // pattern 4
        text = pattern(integer, 0, true, true);
        System.out.println(text);
    }

    private static void Question_19(Scanner s) {
        for (int i = 1; i <= 8; i++) {
            for (int j = 0; j < 8 - i; j++) {
                System.out.print("      ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print(String.format("%6d", (int)Math.pow(2, j)));
            }
            for (int j = i - 2; j > -1; j--) {
                System.out.print(String.format("%6d", (int)Math.pow(2, j)));
            }
            System.out.println();
        }
    }

    private static void Question_20(Scanner s) {
        int count = 1;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 2; j <= i; j++) {
                if(i % j == 0) {
                    if(j == i) {
                        System.out.print(String.format("%5d", j));
                        count++;
                    }
                    else {
                        break;
                    }
                }
            }
            if (count % 9 == 0) {
                System.out.println();
                count = 1;
            }
        }
    }

    private static void Question_21(Scanner s) {
        double amount, rate = 5.000;
        int years;
        System.out.print("Loan Amount: ");
        amount = s.nextDouble();
        System.out.print("Number of Years: ");
        years = s.nextInt();

        System.out.println("Interest Rate\t\tMonthly Payment\t\tTotal Paymant\n");

        while (rate <= 8.000) {
            double monthlyInterestRate = rate / 1200;
            double monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            double totalPayment = monthlyPayment * years * 12;

            System.out.println(String.format("%4.3f", rate) + " %\t\t\t" + Util.MyRound(monthlyPayment, 2) + "\t\t\t" + Util.MyRound(totalPayment, 2));
            
            rate += 0.125;
        }
    }

    private static void Question_22(Scanner s) {
        double amount, balance, rate, monthlyInterestRate;
        int years;
        double monthlyPayment;

        System.out.print("Loan Amount: ");
        amount = s.nextDouble();

        System.out.print("Number of Years: ");
        years = s.nextInt();

        System.out.print("Annual Interest Rate: ");
        rate = s.nextDouble();

        monthlyInterestRate = rate / 100 / 12;
        monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));

        balance = amount;

        System.out.println("Monthly Payment: " + (int)(monthlyPayment * 100) / 100.0);
        System.out.println("Total Payment: " + Util.MyRound(monthlyPayment * 12 * years, 2));

        System.out.println(String.format("%-15s", "Payment#") + String.format("%-15s", "Interest") + String.format("%-15s", "Principal") + String.format("%-15s", "Balance"));

        for (int i = 1; i <= years * 12; i++) {
            double interest, principal;
            interest = (int)(monthlyInterestRate * balance * 100) / 100.0;
            principal = (int)((monthlyPayment - interest) * 100) / 100.0;
            balance = (int)((balance - principal) * 100) / 100.0;
            System.out.println(String.format("%-15d", i) + String.format("%-15.2f", interest) + String.format("%-15.2f", principal) + String.format("%7.2f", balance));
        }
    }

    private static void Question_23(Scanner s) {
        double sum = 0;

        for (int i = 1; i <= 50000; i++) {
            sum += (double)1 / i;
        }
        System.out.println(sum);
    }
    
    private static void Question_24(Scanner s) {
        double sum = 0;

        for (int i = 1; i <= 97; i += 2) {
            sum += (double)i / (i + 2);
        }
        System.out.println(sum);
    }

    private static void Question_25(Scanner s) {
        double pi = 0;

        //#item = 0

        for (int i = 1; i <= 100000; i++) {
            pi += Math.pow(-1, i+1) / (2 * i - 1);

            if (i == 10000 || i == 20000 || i == 30000 || i == 40000 || 
                i == 50000 || i == 60000 || i == 70000 || i == 80000 || 
                i == 90000 || i == 100000) {
                    System.out.println("The PI is " + String.format("%16.15f", 4 * pi) + " for i = " + i);
            }
        }
    }

    private static void Question_26(Scanner s) {
        double e = 1;
        double term = 1;
        for (int i = 1; i <= 100000; i++) {
            term /= i;
            e += term;

            if (i == 10000 || i == 20000 || i == 30000 || i == 40000 || 
            i == 50000 || i == 60000 || i == 70000 || i == 80000 || 
            i == 90000 || i == 100000) {
                System.out.println("The e is " + e + " for i = " + i);
            }
        }
    }

    private static void Question_27(Scanner s) {
        int count = 1;
        for (int y = 2001; y <= 2100; y++) {
            if (MyCalendar.CheckLeapYear(y)) {
                if (count % 10 == 0) {
                    System.out.println(y);
                }
                else {
                    System.out.print(y + " ");
                }
                count++;
            }
        }
    }

    private static void Question_28(Scanner s) {
        int year;
        System.out.print("Enter year (e.g., 2008): ");
        year = s.nextInt();

        for (int m = 1; m <= 12; m++) {
            System.out.println(MyCalendar.MonthofIntToString(m) + " 1, " + year + " is " + MyCalendar.DayofIntToString_Zeller(MyCalendar.GetDayOfTheWeek(year, m, 1)));
        }
    }

    private static void Question_29(Scanner s) {
        int year;
        System.out.print("Enter year (e.g., 2008): ");
        year = s.nextInt();

        System.out.println();

        for (int m = 1; m <= 12; m++) {
            int days = MyCalendar.GetDayofMonth(m, year);

            String str_Month = MyCalendar.MonthofIntToString(m) + " " + year;
            System.out.println(StringUtils.center(str_Month, 40));
            System.out.println("---------------------------------------");

            for (int i = 0; i < 7; i++) {
                System.out.print(MyCalendar.DayofIntToString(i).substring(0, 3) + "   ");
            }
            System.out.println();    
            
            int startIdx = (MyCalendar.GetDayOfTheWeek(year, m, 1) + 6) % 7;

            for (int i = 0; i < startIdx; i++) {
                System.out.print("      ");
            }

            for (int i = 1; i <= days; i++) {
                if (startIdx == 7) {
                    System.out.println();
                    startIdx = 1;
                }
                else {
                    startIdx++;
                }
                System.out.print(String.format("%2d", i) + "    ");
            }
            System.out.println();
        }   
    }

    private static void Question_30(Scanner s) {
        double account, amount, annualRate, monthlyRate;
        int month;

        System.out.print("Enter the monthly saving amount: ");
        amount = s.nextDouble();

        System.out.print("Enter the annual interest rate: ");
        annualRate = s.nextDouble();

        System.out.print("Enter the number of months: ");
        month = s.nextInt();

        monthlyRate = annualRate / 12 / 100;
        account = 0;

        for (int i = 0; i < month; i++) {
            account = Util.MyRound((amount + account) * (1 + monthlyRate), 3);
        }
        System.out.println("After the " + month + " month, the account value is " + String.format("%-7.3f", account));
    }

    private static void Question_31(Scanner s) {
        double amount, annualRate, CDValue;
        int month;
        System.out.print("Enter the initial deposit amount: ");
        amount = s.nextDouble();

        System.out.print("Enter annual percentage yield: ");
        annualRate = s.nextDouble();

        System.out.print("Enter maturity period (number of months): ");
        month = s.nextInt();

        CDValue = amount;
        System.out.println("Month\tCD Value");

        for (int i = 1; i <= month; i++) {
            CDValue = CDValue + CDValue * annualRate / 1200;
            System.out.println(String.format("%-5d", i) + String.format("%11.2f",CDValue));
        }
    }

    private static void Question_32(Scanner s) {
        int lotterydigit1 = Util.RandInt(0, 9);
        int lotterydigit2 = Util.RandInt(0, 9);

        while (lotterydigit1 == lotterydigit2) {
            lotterydigit2 = Util.RandInt(0, 9);
        }
        System.out.println("the lottery number is " + lotterydigit1 + lotterydigit2);
    }

    private static void Question_33(Scanner s) {
        for (int i = 1; i < 10000; i++) {
            int sum = 0;

            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }               
            if (sum == i) {
                System.out.println(i +  " is perfect number.");
            }
        }
    }

    private static void Question_34(Scanner s) {
        // 2  -> user wins 
        // -2 -> computer wins
        int standard = 0;

        while (standard < 2 && standard > -2) {
            int yourChoice;
            int computer = Util.RandInt(0, 2);

            System.out.print("scissor (0), rock (1), paper (2): ");
            yourChoice = s.nextInt();
            
            if (computer == 0) {
                if (yourChoice == 0) {
                    System.out.println("The computer is scissor. You are scissor too. It is a draw.");
                }
                else if (yourChoice == 1) {
                    System.out.println("The computer is scissor. You are rock. You win");
                    standard += 1;
                }
                
                else {
                    System.out.println("The computer is scissor. You are paper. You lost");
                    standard -= 1;
                }
            }
            else if (computer == 1) {
                if (yourChoice == 0) {
                    System.out.println("The computer is rock. You are scissor. You lost.");
                    standard -= 1;
                }
                else if (yourChoice == 1) {
                    System.out.println("The computer is rock. You are rock too. It is a draw. ");
                }
                else {
                    System.out.println("The computer is rock. You are paper. You won.");
                    standard += 1;
                }      
            }
            else {
                if (yourChoice == 0) {
                    System.out.println("The computer is paper. You are scissor. You won.");
                    standard += 1;
                }
                else if (yourChoice == 1) {
                    System.out.println("The computer is paper. You are rock. You lost.");
                    standard -= 1;
                }           
                else {
                    System.out.println("The computer is paper. You are paper too. It is a draw.");
                }
            }
        }
    }

    private static void Question_35(Scanner s) {
        double sum = 0;
        
        for (int i = 1; i <= 624; i++) {
            sum += 1 / (Math.sqrt(i) + Math.sqrt(i+1));
        } 
        System.out.println(sum);
    }

    private static void Question_36(Scanner s) {
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

    private static void Question_37(Scanner s) {
        System.out.print("Enter an integer: ");
        int decimal = s.nextInt();
        String binaryString = "";
        int value = decimal;

        while (value != 0) {
            binaryString = value % 2 + binaryString;
            value = value / 2;
        }

        System.out.println(decimal + "'s BinaryCode representation is " + binaryString);
    }

    private static void Question_38(Scanner s) {
        System.out.print("Enter an integer: ");
        int decimal = s.nextInt();
        String OctalString = "";
        int value = decimal;

        while (value != 0) {
            OctalString = value % 8 + OctalString;
            value = value / 8;
        }

        System.out.println(decimal + "'s OctalCode representation is " + OctalString);
  
    }

    private static double GetCommission(int salesAmount) {
        if (salesAmount >= 0 && salesAmount <= 5000) {
            return salesAmount * 0.08;
        }
        else if (salesAmount > 5000 && salesAmount <= 10000) {
            return 5000 * 0.08 + (salesAmount - 5000) * 0.10;
        }
        else {
            return 5000 * 0.08 + 5000 * 0.10 + (salesAmount - 10000) * 0.12;
        }
    }


    private static void Question_39(Scanner s) {
        double sales = 0; 
        System.out.print("Enter target salary: ");
        double targetSalary = s.nextDouble() - 5000; // base = 5000;

        int salesAmount = 0;

        while (sales < targetSalary) {
            salesAmount += 1;
            sales = salesAmount + GetCommission(salesAmount);
        }
        System.out.println("the minimum number of sales you have to generate in order to make $" + (targetSalary + 5000) + " is $" + (double)salesAmount);
    }

    private static void Question_40(Scanner s) {
        int hcnt = 0, tcnt = 0;
        System.out.println("Does the coin display the head or tail?[i.g 0(=head), 1(=tail)]");
        System.out.print("-> In order to look at the coin, please press an enter key.");
        s.nextLine();

        for (int i = 0; i < 1000000; i++) {
            int coin = Util.RandInt(0, 1);
            
            if (coin == 0) {
                hcnt++;
            }
            else {
                tcnt++;
            }
        }
        System.out.println("The number of head of coin is " + hcnt);
        System.out.println("The number of tail of coin is " + tcnt);
    }

    private static void Question_41(Scanner s) {
        int count = 1;
        int largestNumber, number;

        System.out.print("Enter a number (0: for end of input): ");
        number = s.nextInt();

        if (number == 0) {
            return;
        }

        largestNumber = number;

        while (number != 0) {
            number = s.nextInt();

            if (number == largestNumber) {
                count++;
            }
            else if (number > largestNumber) {
                largestNumber = number;
                count = 1;
            }
            else {
                continue;
            }
        }
        System.out.println("The largest number is " + largestNumber);
        System.out.println("The occurrence count of the largest number is " + count);
    }

    private static void Question_42(Scanner s) {
        double sales = 0; 
        System.out.print("Enter target salary: ");
        double targetSalary = s.nextDouble() - 5000; // base = 5000;
        int salesAmount;

        for (salesAmount = 0; sales < targetSalary; salesAmount++) {
            salesAmount += 1;
            sales = salesAmount + GetCommission(salesAmount);
        }
        System.out.println("The minimum number of sales you have to generate in order to make $" + (targetSalary + 5000) + " is $" + (double)salesAmount);
        System.out.println("The commission is going to be " + GetCommission(salesAmount));
    }

    private static void Question_43(Scanner s) {
        int n, count = 0;

        System.out.print("Enter an integer: ");
        n = s.nextInt();

        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(i + " " + j);
                count++;
            }
        }
        System.out.println("The total number of all combinations is " + count);
    }

    private static void Question_44(Scanner s) {
        System.out.print("Enter an integer: ");
        int value = s.nextInt();
        
        System.out.print("The 16 bits are ");
        int mask = 1;
        for (int i = 15; i >= 0; i--) {
          int temp = value >> i;
          int bit = temp & mask;
          System.out.print(bit);
        }
    }

    private static void Question_45(Scanner s) {
        double sum = 0, pow = 0, mean, deviation;

        System.out.print("Enter ten numbers: ");

        for (int i = 0; i < 10; i++) {
            double num = s.nextDouble();
            sum += num;
            pow += Math.pow(num, 2);
        }
        
        mean = sum / 10;
        deviation =  Math.sqrt(( pow - Math.pow(sum, 2) / 10 ) / 9); 

        System.out.println("The mean is " + String.format("%3.2f", mean));
        System.out.println("The standard deviation is " + String.format("%6.5f", deviation));
    }

    private static void Question_46(Scanner s) {
        String str;
        System.out.print("Enter a string: ");
        str = s.nextLine();

        System.out.println("The reversed string is " + StringUtils.GetReversedString(str));
    }

    private static void Question_47(Scanner s) {
        String str;
        int sum, lastDigit;
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        str = s.nextLine();

        if (str.length() != 12 || StringUtils.isNumeric(str)) {
            System.out.println(str + " is an invalid input");
            return;
        }
        sum = 0;
        for (int i = 0; i < 12; i++) {
            int num = Character.getNumericValue(str.charAt(i));
            if (i % 2 == 0) {
                sum += num;
            }
            else {
                sum += num * 3;
            }
        }
        lastDigit = 10 - sum % 10;
        System.out.println("The ISBN-13 number is " + str + (lastDigit == 10 ? 0 : lastDigit));
    }

    private static void Question_48(Scanner s) {
        System.out.print("Enter a string: ");
        String str = s.nextLine();
    
        for (int i = 0; i < str.length(); i += 2)
          System.out.print(str.charAt(i));
      
        System.out.println();
    }

    private static void Question_49(Scanner s) {
        String str;
        System.out.print("Enter a string: ");
        str = s.nextLine();

        System.out.println("The number of vowels is " + StringUtils.GetNumberOfVowels(str));
        System.out.println("The number of consonants is " + StringUtils.GetNumberOfConsonants(str));
    }

    private static void Question_50(Scanner s) {
        String str;
        System.out.print("Enter a string: ");
        str = s.nextLine();

        System.out.println("The number of uppercase letters is " + StringUtils.GetNumOfUppercaseLetters(str));
    }

    private static void Question_51(Scanner s) {
        String s1, s2;
        int idx = 0;
        System.out.print("Enter the first string: ");
        s1 = s.nextLine();

        System.out.print("Enter the second string: ");
        s2 = s.nextLine();

        if (s1.length() > s2.length()) {
            for (int i = 0; i < s2.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    break;
                }
                idx++;
            }
        }
        else {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    break;
                }
                idx++;
            }
        }
        System.out.println("The common prefix is " + s1.substring(0, idx));
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
        // Question_35(s);
        // Question_36(s);
        // Question_37(s);
        // Question_38(s);
        // Question_39(s);
        // Question_40(s);
        // Question_41(s);
        // Question_42(s);
        // Question_43(s);
        // Question_44(s);
        // Question_45(s);
        // Question_46(s);
        // Question_47(s);
        // Question_48(s);
        // Question_49(s);
        // Question_50(s);
        // Question_51(s);
   
        s.close();;
    }
}
