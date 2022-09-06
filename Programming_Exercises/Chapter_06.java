package Programming_Exercises;

import java.util.Scanner;

import Commons.MyCalendar;
import Commons.StringUtils;
import Commons.Util;

public class Chapter_06 {
    public static int getPentagonalNumber(int n) {
        return n * (3 * n - 1) / 2;
    }

    private static void Question_01(Scanner s) {
        for (int i = 1; i <= 100; i++) {
            if (i % 10 == 0) {
                System.out.println(String.format("%7d", getPentagonalNumber(i)));
            }
            else {
                System.out.print(String.format("%7d", getPentagonalNumber(i)) + " ");
            }
        }
    }
    public static int sumDigits(long n) {
        if (n / 10 == 0) {
            return (int)n;
        }
        else {
            return (int)(n % 10) + sumDigits(n / 10);
        }
    }

    private static void Question_02(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        System.out.println("The sum of all its digits is " + sumDigits(n));
    }



    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {
        return number == Util.Reverse(number);
    }

    private static void Question_03(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        System.out.println("The integer is " + (isPalindrome(n) ? "" : "not ") + "a palindrome");
    }

    private static void Question_04(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        System.out.println("An integer in reverse order is " + Util.Reverse(n));
    }
    public static void displaySortedNumbers(double num1, double num2, double num3) {
        double temp;

        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if (num1 > num3) {
            temp = num1;
            num1 = num3;
            num3 = temp;
        }
        if (num2 > num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }
        System.out.println("The sorted numbers are " + num1 + " " + num2 + " " + num3);
    }

    private static void Question_05(Scanner s) {
        System.out.print("Enter three numbers: ");
        double a, b, c;

        a = s.nextDouble();
        b = s.nextDouble();
        c = s.nextDouble();

        displaySortedNumbers(a, b, c);
    }

    public static void displayPattern(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.print("   ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(String.format("%2d", j) +" ");
            }
            System.out.println();
        }
    }
    private static void Question_06(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        displayPattern(n);
    }

    public static double futureInvestmentValue(double investmentAmount, double monthlyInterestRate, int years) {
        return investmentAmount * Math.pow(1 + monthlyInterestRate, 12 * years);
    }

    private static void Question_07(Scanner s) {
        double amount, rate;
        
        System.out.print("The amount invested: ");
        amount = s.nextDouble();

        System.out.print("Annual interest rate: ");
        rate = s.nextDouble();

        System.out.println("Years     Future Value");

        for (int i = 1; i <= 30; i++) {
            System.out.println(String.format("%2d", i) + String.format("%20.2f", futureInvestmentValue(amount, rate / 1200, i)));
        }
    }

    private static double celsiusToFahrenheit(double celsius) {
        return (9.0 / 5) * celsius + 32;
    }
    private static double fahrenheitToCelsius(double fahrenheit) {
        return (5.0 / 9) * (fahrenheit - 32);
    }

    private static void Question_08(Scanner s) {
        System.out.println("Celsius      Fahrenheit  |  Fahrenheit      Celsius");

        for (int i = 10; i > 0; i--) {
            System.out.println(String.format("%5.1f", 30.0 + i) + "          " + 
                               String.format("%5.1f", celsiusToFahrenheit(30 + i)) + "     |    " +
                               String.format("%5.1f", 20.0 + (i * 10)) + "         " + 
                               String.format("%5.2f", fahrenheitToCelsius(20 + (i * 10))));
        }
    }

    private static double footToMeter(double foot) {
        return 0.305 * foot;
    }
    private static double meterToFoot(double meter) {
        return meter / 0.305;
    }

    private static void Question_09(Scanner s) {
        System.out.println("  Feet         Meters    |     Meters        Feet");

        for (int i = 1; i <= 10; i++) {
            System.out.println(String.format("%5.1f", (double)i) + "          " + 
                               String.format("%5.3f", footToMeter(i)) + "     |    " +
                               String.format("%5.1f", 15.0 + (i * 5)) + "         " + 
                               String.format("%6.3f", meterToFoot(15 + (i * 5))));
        }
    }

    // Check whether number is prime 
    private static boolean isPrime(int num) {
        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }
        
    private static void Question_10(Scanner s) {
        int cnt = 0, N = 10000;
        
        for (int num = 2; num < N; num++) {
            if (isPrime(num)) {
                cnt++;
            }
        }

        System.out.println("The number of prime number below " + N + " is " + cnt);
    }

    private static double GetCommission(double salesAmount) {
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

    private static void Question_11(Scanner s) {
        for (int i = 1; i < 20; i++) {
            System.out.println(5000 + i * 5000 + " \t\t " + GetCommission(5000 + i * 5000));
        }
    }

    public static void printChars(char ch1, char ch2, int numberPerLine) {
        int cnt = 1;
        for (int i = (int)ch1; i <= (int)ch2; i++) {
            if (cnt++ % numberPerLine == 0) {
                System.out.println((char)i);
            } 
            else {
                System.out.print((char)i + " ");
            }
        }
    }

    private static void Question_12(Scanner s) {
        printChars('a', 'z', 10);
    }

    private static double sumSeries(int index) {
        double sum = 0;

        for (int i = 1; i <= index; i++) {
            sum += (double)i / (i + 1);
        }
        return sum;
    }

    private static void Question_13(Scanner s) {
        System.out.println("i\t\tm(i)");
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + "\t\t" + String.format("%6.4f", sumSeries(i)));
        }
    }

    private static double EstimatePI(int index) {
        double sum = 0;

        for (int i = 1; i <= index; i++) {
            sum += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return 4 * sum;
    }

    private static void Question_14(Scanner s) {
        System.out.println("i\t\tm(i)");
        for (int i = 1; i < 1000; i += 100) {
            System.out.println(i + "\t\t" + String.format("%5.4f", EstimatePI(i)));
        }
    }
    public static double computeTax(int status, double income) {
        double tax = 0;
    
        // Compute tax for single filers
        if (status == 0) {
            if (income <= 8350) {
                tax = income * 0.10;
            }
            
            else if (income <= 33950) {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            }
            else if (income <= 82250) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            }
            else if (income <= 171550) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (income - 82250) * 0.28;
            }
            else if (income <= 372950) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + 
                (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + 
                (income - 171550) * 0.33;
            }
            else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 + (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 + (income - 372950) * 0.35;
            }
        }
    
        // Compute tax for married file jointly
        else if (status == 1) {
            if (income <= 16700) {
                tax = income * 0.10;
            }
            else if (income <= 67900) {
                tax = 16700 * 0.10 + (income - 16700) * 0.15;
            }
            else if (income <= 137050) {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                (income - 67900) * 0.25;
            }
                
            else if (income <= 208850) {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                    (137050 - 67900) * 0.25 + (income - 82250) * 0.28;
            }
                
            else if (income <= 372950) {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                    (137050 - 67900) * 0.25 + (208850 - 82250) * 0.28 +
                    (income - 208850) * 0.33;
            }   
            else {
                tax = 16700 * 0.10 + (67900 - 16700) * 0.15 + 
                    (82250 - 33950) * 0.25 + (208850 - 82250) * 0.28 + 
                    (372950 - 208850) * 0.33 + (income - 372950) * 0.35;
            }
        } 

        // Compute tax for married separately
        else if (status == 2) {
            if (income <= 8350) {
                tax = income * 0.10;
            }
            else if (income <= 33950) {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            }
            else if (income <= 68525) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (income - 33950) * 0.25;
            }
            else if (income <= 104425) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (68525 - 33950) * 0.25 + (income - 68525) * 0.28;        
            }    
            else if (income <= 186475) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 +
                    (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 +
                    (income - 104425) * 0.33;
            }
            else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + 
                    (68525 - 33950) * 0.25 + (104425 - 68525) * 0.28 + 
                    (186475 - 104425) * 0.33 + (income - 186475) * 0.35;
            }
        }

        // Compute tax for head of household
        else {
            if (income <= 11950) {
                tax = income * 0.10;
            }
            else if (income <= 45500) {
                tax = 11950 * 0.10 + (income - 11950) * 0.15;
            }
            else if (income <= 117450) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (income - 45500) * 0.25;
            }
            else if (income <= 190200) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 +
                    (117450 - 45500) * 0.25 + (income - 117450) * 0.28;
            }
            else if (income <= 372950) {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + 
                    (income - 190200) * 0.33;
            }   
            else {
                tax = 11950 * 0.10 + (45500 - 11950) * 0.15 + 
                    (117450 - 45500) * 0.25 + (190200 - 117450) * 0.28 + 
                    (372950 - 190200) * 0.33 + (income - 372950) * 0.35;
            }
        }
        return Util.MyRound(tax, 0);
    }
    private static void Question_15(Scanner s) {
        System.out.println("Taxable\t\tSingle\t\tMarried Joint\tMarried\t\tHead of");
        System.out.println("Income\t\t\t\tor Qualifying\tSeparate\tHouse hold");
        System.out.println("       \t\t\t\tWidow(er)");    
   
        for (int i = 50000; i <= 60000; i += 50) {
            System.out.println(i +"\t\t" + (int)computeTax(0, i) + "\t\t" + (int)computeTax(1, i) + "\t\t" + (int)computeTax(2, i) + "\t\t" + (int)computeTax(3, i));
        }       
    }
    public static int numberOfDaysInAYear(int year) {
        if (MyCalendar.CheckLeapYear(year)) {
            return 366;
        }
        else {
            return 365;
        }
    }

    private static void Question_16(Scanner s) {
        for (int year = 2010; year <= 2020; year++) {
            System.out.println(year + " has " + numberOfDaysInAYear(year));
        }
    }

    public static void printMatrix(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(Util.RandInt(0, 1) + " ");
            }
            System.out.println();
        }
    }
    private static void Question_17(Scanner s) {
        int n;
        System.out.print("Enter n: ");
        n = s.nextInt();

        printMatrix(n);
    }
    private static boolean IsValidPassword(String s) {
        int cntChar = 0, cntDigits = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.toUpperCase(ch) >= 'A' && Character.toUpperCase(ch) <= 'Z') {
                cntChar++;
            }
            else if (Character.toUpperCase(ch) >= '0' && Character.toUpperCase(ch) <= '9') {
                cntDigits++;
            }
        }
        if (cntChar >= 8 && cntDigits >= 2) {
            return true;
        }
        return false;
    }

    private static void Question_18(Scanner s) {
        String str;
        System.out.print("Enter a password: ");
        str = s.nextLine();

        System.out.println((IsValidPassword(str) ? "Valid" : "Invalid") + " Password");
    }
    /** Return true if the sum of every two sides is
     * greater than the third side. */
    public static boolean isValid(double side1, double side2, double side3) {
        if (side1 > side2) {
            double temp = side1;
            side1 = side2;
            side2 = temp;
        }
        if (side1 > side3) {
            double temp = side1;
            side1 = side3;
            side3 = temp;
        }
        if (side2 > side3) {
            double temp = side2;
            side2 = side3;
            side3 = temp;
        }

        if (side1 + side2 > side3) {
            return true;
        }
        else {
            return false;
        }
    }
    /** Return the area of the triangle. */
    public static double area(double side1, double side2, double side3) {
        return Util.GetAreaOfTriangleUsingSides(side1, side2, side3);
    }
    private static void Question_19(Scanner s) {
        double s1, s2, s3;
        System.out.print("Enter three sides for triangle: ");
        s1 = s.nextDouble();
        s2 = s.nextDouble();
        s3 = s.nextDouble();

        if (isValid(s1, s2, s3)) {
            System.out.println("The area of a triangle is " + Util.MyRound(area(s1, s2, s3), 2));
        }
        else {
            System.out.println("Invalid input...");
        }        
    }

    public static int countLetters(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (StringUtils.CheckAlphabet(ch)) {
                cnt++;
            }
        }
        return cnt;
    }

    private static void Question_20(Scanner s) {
        String str;
        System.out.print("Enter a string: ");
        str = s.nextLine();
        System.out.println("The number of letters is " + countLetters(str));
    }

    public static int getNumber(char uppercaseLetter) {
        char ch = uppercaseLetter;
        int num;

        if (ch >= 'A' && ch <= 'C') {
            num = 2;
        }
        else if (ch >= 'D' && ch <= 'F') {
            num = 3;
        }
        else if (ch >= 'G' && ch <= 'I') {
            num = 4;
        }
        else if (ch >= 'J' && ch <= 'L') {
            num = 5;
        }
        else if (ch >= 'M' && ch <= 'O') {
            num = 6;
        }
        else if (ch >= 'P' && ch <= 'S') {
            num = 7;
        }
        else if (ch >= 'T' && ch <= 'U') {
            num = 8;
        }
        else {
            num = 9;
        }
        return num;
    }

    private static void Question_21(Scanner s) {
        char ch;
        System.out.print("Enter a letter: ");
        ch = Character.toUpperCase(s.nextLine().charAt(0));

        if (ch < 'A' || ch > 'Z') {
            System.out.println(ch + " is an invalid input");
        }
        else {
            System.out.println("The corresponding number is " + getNumber(ch));
        }
    }

    // 바빌로니안 방법과, 뉴턴-랩슨 공식이 있다. 
    public static double sqrt(long n) {
        double lastGuess = 1; 
        double nextGuess = (lastGuess + n / lastGuess) / 2;; 
        while (!Util.DblEquals(nextGuess, lastGuess, Util._6TH_DP)) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
        }
        
        return nextGuess;
    }

    // 6.22 루트 구하는 공식 (바빌로니안 방법)
    private static void Question_22(Scanner s) {  
        long n;
        System.out.print("Enter an integer: ");
        n = s.nextLong();

        System.out.println("The approximated square root of " + n + " is " + sqrt(n));
    }

    public static int count(String str, char a) {
        int count = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == a) {
                count++;
            }
        }
        return count;
    }

    private static void Question_23(Scanner s) {
        String str;
        char ch; 
        System.out.print("Enter a string: ");
        str = s.nextLine();
        
        System.out.print("Enter a character: ");
        ch = s.nextLine().charAt(0);

        System.out.println("The number of occurrences of the character " + ch + " in the string is " + count(str, ch));
        //System.out.println(count("Welcome", 'e'));
    }

    /** Get the total number of days from Jan 1 to the month in the year*/
    static int getTotalDaysInMonths(int year, int month) {
        int total = 0;

        // Add days from Jan to the month
        for (int i = 1; i <= month; i++)
        total = total + getNumOfDaysInMonth(year, i);

        return total;
    }

    /** Get the number of days in a month */
    static int getNumOfDaysInMonth(int year, int month) {
        if (month == 1 || month==3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month == 12)
        return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
        return 30;

        if (month == 2)
        if (isLeapYear(year))
            return 29;
        else
            return 28;

        return 0; // If month is incorrect.
    }

    /** Determine if it is a leap year */
    static boolean isLeapYear(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
        return true;

        return false;
    }

    /** Get the total number of days from Jan 1, 1970 to the specified year*/
    static int getTotalDaysInYears(int year) {
        int total = 0;

        // Get the total days from 1970 to the specified year
        for (int i = 1970; i <= year; i++)
        if (isLeapYear(i))
        total = total + 366;
        else
        total = total + 365;

        return total;
    }

    private static void Question_24(Scanner s) {
        // Obtain the total milliseconds since the midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain the total seconds since the midnight, Jan 1, 1970
        long totalSeconds = (totalMilliseconds / 1000);

        // Compute the current second in the minute in the hour
        int currentSecond = (int)(totalSeconds % 60);

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        int currentMinute = (int)(totalMinutes % 60);

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        int currentHour = (int)(totalHours % 24);

        // Compute the total days
        int totalDays = (int)(totalHours / 24);
        if (currentHour > 0) totalDays++;

        // Obtain Year
        int currentYear = 2000;
        do {
        currentYear++;
        } while (getTotalDaysInYears(currentYear) < totalDays);

        // Obtain Month
        int totalNumOfDaysInTheYear = totalDays -
        getTotalDaysInYears(currentYear - 1);
        int currentMonth = 0;
        do {
        currentMonth++;
        } while (getTotalDaysInMonths(currentYear, currentMonth)
        < totalNumOfDaysInTheYear);

        // Obtain Day
        int currentDay = totalNumOfDaysInTheYear -
        getTotalDaysInMonths(currentYear, currentMonth - 1);

        // Display results
        String output = "Current date and time is " +
        currentMonth + "/" + currentDay + "/" + currentYear + " " +
        currentHour + ":" + currentMinute + ":" + currentSecond + " GMT";

        System.out.println(output);
    }

    public static String convertMillis(long millis) {
        long totalSeconds = millis / 1000;
        int hours = (int)(totalSeconds / 3600);
        int minutes = (int)(totalSeconds / 60 % 60);
        int seconds = (int)(totalSeconds % 60);

        return String.format("%02d", hours) + ":" + String.format("%02d", minutes) + ":" + String.format("%02d", seconds); 
    }

    private static void Question_25(Scanner s) {
        System.out.println(convertMillis(5500));
        System.out.println(convertMillis(100000));
        System.out.println(convertMillis(555550000));
    }

    private static void Question_26(Scanner s) {
        int num = 2, cnt = 1;

        while (cnt <= 100) {
            if (isPrime(num) && isPalindrome(num)) {
                if (cnt % 10 == 0) {
                    System.out.println(num);
                }
                else {
                    System.out.print(num + " ");
                }
                cnt++;
            }    
            num++;  
        }
    }

    private static void Question_27(Scanner s) {
        int num = 2, cnt = 1;

        while (cnt <= 100) {
            if (isPrime(num) && !isPalindrome(num) && isPrime(Util.Reverse(num))) {
                if (cnt % 10 == 0) {
                    System.out.println(num);
                }
                else {
                    System.out.print(num + " ");
                }
                cnt++;
            }    
            num++;  
        }
    }

    private static void Question_28(Scanner s) {
        int p = 2;

        System.out.println(p + "\t2^p - 1");
        while (p <= 31) {
            if (isPrime(p)) {
                System.out.println(p + "\t" + (int)(Math.pow(2, p) - 1));
            }
            p++;
        }
    }
    private static void Question_29(Scanner s) {
        for (int i = 2; i <= 998; i++) {
            if (isPrime(i) && isPrime(i + 2)) {
                System.out.println("(" + i + ", " + (i + 2) + ")");
            }
        }
    }
    private static int getDiceResult() {
        int i1 = Util.RandInt(1, 6);
        int i2 = Util.RandInt(1, 6);
    
        System.out.println("You rolled " + i1 + " + " + i2 + " = " + (i1 + i2));
        return i1 + i2;
    }

    private static void Question_30(Scanner s) {
        int dice = getDiceResult();
        int point;
        if (dice == 7 || dice == 11) {
            System.out.println("You win");
            return;
        }
        else if (dice == 2 || dice == 3 || dice == 12) {
            System.out.println("You lose");
            return;
        }

        point = dice;  
        System.out.println("point is " + point);        
        
        dice = getDiceResult();
        while (dice != 7 && dice != point) {
            dice = getDiceResult();
        }
        if (dice == 7) {
            System.out.println("You lose");
        }
        else {
            System.out.println("You win");
        }
    }
    private static boolean isValid(int num) {
        if (num % 10 == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    private static int sumOfDoubleEvenPlace(long num, int digits) {
        int sum = 0;

        for (int i = 1; i <= digits; i++) {
            if (i % 2 == 0) {
                sum += getDigit(num % 10);
            }
            num /= 10;
        }
        return sum;
    }

    private static long getDigit(long num) {
        long result;
        
        num *= 2;
        result = num;

        if (num >= 10) {
            result /= 10;
            result += num % 10;
        }
        return result;
    }
    private static int sumOfoddPlace(long number, int digits) {
        int sum = 0;

        for (int i = 1; i <= digits; i++) {
            if (i % 2 != 0) {
                sum += number % 10;
            }
            number /= 10;
        }
        return sum;
    }
    private static long getPrefix(long number, int k) {
        return (long)(number / Math.pow(10, k)); 
    }
    private static int getSize(long d) {
        int count = 0;

        while (d > 0) {
            count += 1;
            d /= 10;
        }     
        return count;
    }

    private static boolean prefixMatched(long number, int d) {
        if (getPrefix(number, d) == 4) {
            return true;                                                        // Visa card
        }
        else if (getPrefix(number, d) == 5) {
            return true;                                                        // MarsterCard
        }
        else if (getPrefix(number, d) == 6) {
            return true;                                                        // Discover card
        }
        else if (getPrefix(number, d) == 3 && getPrefix(number, d-1) == 7) {
            return true;                                                        // 37 -> American Express card  
        }
        else {
            return false;
        }                                                     
    }
    private static String getCardMaker(long number, int d) {
        if (getPrefix(number, d) == 4) {
            return "Visa Card";
        }
        else if (getPrefix(number, d) == 5) {
            return "Marster Card";
        }
        else if (getPrefix(number, d) == 6) {
            return "Discover Card";
        }
        else {
            return "American Express Card";
        } 
    }
 
    
    private static void Question_31(Scanner s) {
        System.out.print("Enter card number: ");
        long number = s.nextLong();
        int digits = getSize(number);

        if (digits > 16 || digits < 13) {
            System.out.println("This card is invaild.");
            return;
        }
        
        if (!prefixMatched(number, digits - 1)) {      // n - 1 => 마지막 숫자 제외
            System.out.println("This card is invaild.");
            return;
        }

        if (isValid(sumOfoddPlace(number, digits) + sumOfDoubleEvenPlace(number, digits))) {
            System.out.println("Result      : This Card is Vaild!");
            System.out.println("Card Name   : " + getCardMaker(number, digits - 1));
            System.out.println("Card Number : " + number);
        }
        else {
            System.out.println("This card is invaild.");
        }
    }

    private static void Question_32(Scanner s) {
        int winCount = 0;
        int dice = getDiceResult();
        for (int i = 0; i < 10000; i++) {
            dice = getDiceResult();
            
            if (dice == 7 || dice == 11) {
                winCount += 1;
            }
            else if (dice == 2 || dice == 3 || dice == 12) {
                winCount += 0;
            }
            else {
                int point = dice;
                dice = getDiceResult();
                // System.out.println("point is " + point);
                while (dice != 7 && dice != point) {
                    dice = getDiceResult();
                }
                if (dice != 7) {
                    winCount += 1;
                }
            }
        }                
        System.out.println(winCount);
    }

    private static void Question_33(Scanner s) {
        // Obtain the total milliseconds since the midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain the total seconds since the midnight, Jan 1, 1970
        long totalSeconds = (totalMilliseconds / 1000);

        // Compute the current second in the minute in the hour
        int currentSecond = (int)(totalSeconds % 60);

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        int currentMinute = (int)(totalMinutes % 60);

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        int currentHour = (int)(totalHours % 24);

        // Compute the total days
        int totalDays = (int)(totalHours / 24);
        if (currentHour > 0) totalDays++;

        // Obtain Year
        int currentYear = 2000;
        do {
        currentYear++;
        } while (getTotalDaysInYears(currentYear) < totalDays);

        // Obtain Month
        int totalNumOfDaysInTheYear = totalDays -
        getTotalDaysInYears(currentYear - 1);
        int currentMonth = 0;
        do {
        currentMonth++;
        } while (getTotalDaysInMonths(currentYear, currentMonth) < totalNumOfDaysInTheYear);

        // Obtain Day
        int currentDay = totalNumOfDaysInTheYear -
        getTotalDaysInMonths(currentYear, currentMonth - 1);

        // Display results
        String output = "Current date and time is " +
        MyCalendar.MonthofIntToString(currentMonth)  + " " + currentDay + ", " + currentYear + " " +
        currentHour + ":" + currentMinute + ":" + currentSecond;

        System.out.println(output);
    }

    public static void printMonth(int year, int month) {
        // Print the headings of the calendar
        printMonthTitle(year, month);
    
        // Print the body of the calendar
        printMonthBody(year, month);
    }

    /** Print the month title, e.g., May, 1999 */
    static void printMonthTitle(int year, int month) {
        System.out.println("         " + getMonthName(month)
        + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    /** Print month body */
    static void printMonthBody(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++)
        System.out.print("    ");

        for (i = 1; i <= numberOfDaysInMonth; i++) {
        if (i < 10)
            System.out.print("   " + i);
        else
            System.out.print("  " + i);

        if ((i + startDay) % 7 == 0)
            System.out.println();
        }

        System.out.println();
    }

    /** Get the start day of month/1/year */
    static int getStartDay(int year, int month) {
        return getDayofWeek(year, month, 1);
    }
  
    public static int getDayofWeek(int year, int month, int dayOfMonth) {  
        if (month == 1) {
        month = 13;
        year--;
        }
        else if (month == 2) {
        month = 14;
        year--;
        }
        
        int k = year % 100;
        int j = (int)(year / 100);
        
        int dayOfWeek = (int)(dayOfMonth + (int)((month + 1) * 26.0 / 10) 
        + k + (int)(k / 4.0) + (int)(j / 4.0) + 5 * j) % 7;
        
        return (dayOfWeek + 6) % 7;
    }

    /** Get the number of days in a month */
    static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 ||
        month == 8 || month == 10 || month == 12)
        return 31;

        if (month == 4 || month == 6 || month == 9 || month == 11)
        return 30;

        if (month == 2) return isLeapYear(year) ? 29 : 28;

        return 0; // If month is incorrect
    }

    /** Get the English name for the month */
    static String getMonthName(int month) {
        String monthName = null;
        switch (month) {
        case 1: monthName = "January"; break;
        case 2: monthName = "February"; break;
        case 3: monthName = "March"; break;
        case 4: monthName = "April"; break;
        case 5: monthName = "May"; break;
        case 6: monthName = "June"; break;
        case 7: monthName = "July"; break;
        case 8: monthName = "August"; break;
        case 9: monthName = "September"; break;
        case 10: monthName = "October"; break;
        case 11: monthName = "November"; break;
        case 12: monthName = "December";
        }

        return monthName;
    }
    private static void Question_34(Scanner s) {
        int year, month; 
        
        System.out.print("Enter year (e.g., 2012): ");
        year = s.nextInt();

        System.out.print("Enter month (1-12): ");
        month = s.nextInt();

        // Print calendar for the month of the year
        printMonth(year, month);     
    }

    private static void Question_35(Scanner s) {
        System.out.print("Enter the side: ");
        double side = s.nextDouble();
        
        System.out.println("The area of the pentagon is " + Util.GetAreaPolygon(5, side));
    }

    private static void Question_36(Scanner s) {
        int n;
        System.out.print("Enter the number of sides: ");
        n = s.nextInt();

        System.out.print("Enter the side: ");
        double side = s.nextDouble();
        
        System.out.println("The area of the polygon is " + Util.GetAreaPolygon(n, side));
    }

    public static String format(int number, int width) {
        String res = "";
        int cnt = Util.GetDigits(number);

        for (int i = 0; i < width - cnt; i++) {
            res += '0';
        }
        res += Integer.toString(number);
        return res;
    }
    private static void Question_37(Scanner s) {
        System.out.println(format(34, 4));
        System.out.println(format(34, 5));
        System.out.println(format(34, 1));
    }

    private static void Question_38(Scanner s) {
        int N = 100;

        for (int i = 1; i <= 100; i++) {
            int randInt = Util.RandInt('A', 'Z');
            if (i % 50 == 0) {
                System.out.println((char)randInt);
            }
            else {
                System.out.print((char)randInt + ", ");
            }
        }
            
        for (int i = 1; i <= 100; i++) {
            int randInt = Util.RandInt(0, 9);
            if (i % 50 == 0) {
                System.out.println(randInt);
            }
            else {
                System.out.print(randInt + ", ");
            }
        }
    }
    /** Return true if point (x2, y2) is on the left side of the
     * directed line from (x0, y0) to (x1, y1) */
    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double pos = Util.GetPointPosition(x0, y0, x1, y1, x2, y2);
        
        if (pos > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /** Return true if point (x2, y2) is on the same
     * line from (x0, y0) to (x1, y1) */
    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        double pos = Util.GetPointPosition(x0, y0, x1, y1, x2, y2);
        
        if (pos == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    /** Return true if point (x2, y2) is on the
     * line segment from (x0, y0) to (x1, y1) */
    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        if (x2 >= x0 && x2 <= x1 && y2 >= y0 && y2 <= y1) {
            return true;
        }
        else {
            return false;
        }
        
    }
    private static void PrintPointPosition(double x0, double y0, double x1, double y1, double x2, double y2) {
        if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
                System.out.println("(" + x2 + ", " + y2 + ") is on the line segment from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
            }
            else {
                System.out.println("(" + x2 + ", " + y2 + ") is not on the line segment from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
            }
        }
        else {
            if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
                System.out.println("p2 is on the left side of the line");
            }
            else {
                System.out.println("p2 is on the right side of the line");
            }
        }
    }

    private static void Question_39(Scanner s) {
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

        s.close();
    }
}
