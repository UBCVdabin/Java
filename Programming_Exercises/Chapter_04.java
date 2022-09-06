package Programming_Exercises;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import Commons.MyCalendar;
import Commons.Util;

public class Chapter_04 {
    private static void Question_01(Scanner s) {
        double length, area;

        System.out.print("Enter the length from the center to a vertex: ");
        length = s.nextDouble();

        length = 2 * length * Math.sin(Math.PI / 5);
        area = Util.GetAreaPolygon(5, length);

        System.out.println("The area of the pentagon is " + Util.MyRound(area, 2));
    }

    private static void Question_02(Scanner s) {
        double latitude_1, latitude_2, longitude_1, longitude_2, dist;

        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
        latitude_1 = s.nextDouble();
        longitude_1 = s.nextDouble();

        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        latitude_2 = s.nextDouble();
        longitude_2 = s.nextDouble();

        dist = Util.GetDistanceFromEarth(latitude_1, longitude_1, latitude_2, longitude_2);

        System.out.println("The distance between the two points is " + dist + " km");
    }

    private static void Question_03(Scanner s) {
        double x_Atlanta, y_Atlanta, x_Charlotte, y_Charlotte, x_Orlando, y_Orlando, x_Savannah, y_Savannah;
        double d1, d2, d3, d4, d5, a1, a2;
        x_Atlanta = 33.7489954;
        y_Atlanta = -84.3879824;
        x_Charlotte = 35.2270869;
        y_Charlotte = -80.8431267;
        x_Savannah = 32.0835407;
        y_Savannah = -81.0998342;
        x_Orlando = 28.5383355;
        y_Orlando = -81.3792365;

        d1 = Util.GetDistanceFromEarth(x_Atlanta, y_Atlanta, x_Charlotte, y_Charlotte);
        d2 = Util.GetDistanceFromEarth(x_Charlotte, y_Charlotte, x_Savannah, y_Savannah);
        d3 = Util.GetDistanceFromEarth(x_Atlanta, y_Atlanta, x_Savannah, y_Savannah);
        d4 = Util.GetDistanceFromEarth(x_Orlando, y_Orlando, x_Savannah, y_Savannah);
        d5 = Util.GetDistanceFromEarth(x_Orlando, y_Orlando, x_Atlanta, y_Atlanta);

        a1 = Util.GetAreaOfTriangleUsingSides(d1, d2, d3);
        a2 = Util.GetAreaOfTriangleUsingSides(d3, d4, d5);
        
        System.out.println("The Area is " + (a1 + a2));
    }

    private static void Question_04(Scanner s) {
        double length, area;

        System.out.print("Enter the side: ");
        length = s.nextDouble();

        area = Util.GetAreaPolygon(6, length);

        System.out.println("The area of the hexagon is " + Util.MyRound(area, 2));
 
    }

    private static void Question_05(Scanner s) {
        int n;
        double side, area;
        
        System.out.print("Enter the number of sides: ");
        n = s.nextInt();
        
        System.out.print("Enter the side: ");
        side = s.nextDouble();

        area = Util.GetAreaPolygon(n, side);

        System.out.println("The area of the polygon is " + area);
    }

    //#region 
    private static int[] GenerateRandomPoint(int radius) {
        int[] point = new int[2];
        
        int x = Util.RandInt(-40, 40);
        int y = Util.RandInt(-40, 40);
        

        while (Math.pow(x, 2) + Math.pow(y, 2) != Math.pow(radius, 2)) {
            x = Util.RandInt(-40, 40);
            y = Util.RandInt(-40, 40);
        }
        point[0] = x;
        point[1] = y;

        return point;
    }

    private static boolean Check_GeneratedPoint(int[] g_Point, ArrayList<int[]> plist) {
        for (int i = 0; i < plist.size(); i++) {
            int [] p = plist.get(i);
            
            if (g_Point[0] == p[0] && g_Point[1] == p[1]) {
                return true;
            }
        }
        return false;
    }


    
    private static void Question_06_Temp(Scanner s) {
        // My method: x^2 + y^2 = r^2
        final int r = 40;
        ArrayList <int[]> plist = new ArrayList<int[]>();
        double[] dist = new double[3];
        double[] angle = new double[3];
        double total_dist = 0;
        int largestDistIdx = -1;
        for (int i = 0; i < 3; i++) {
            int[] g_Point = GenerateRandomPoint(r);

            while (Check_GeneratedPoint(g_Point, plist)) {
                g_Point = GenerateRandomPoint(r);
            }

            plist.add(g_Point); 
        }
        // plist = new ArrayList<int[]>();
        // plist.add(new int[] {-40, 0});
        // plist.add(new int[] {40, 0});
        // plist.add(new int[] {0, 40});
        for (int i = 0; i < 3; i++) {
            dist[i] = GetDistanceUsingTwoPoint(plist, (i+1) % 3, (i+2) % 3);
            total_dist += dist[i];          
        }
    
        if (total_dist < (3 * r)) {
            largestDistIdx = GetLargestDistIdx(dist);
            angle = SetAngles(dist, r, largestDistIdx);
        }
        else {
            angle = SetAngles(dist, r, largestDistIdx);
        }

        for (int i = 0; i < 3; i++) {
            int[] point = plist.get(i);
            System.out.println("The Point " + (char)(65 + i) + ": (" + point[0] + ", " + point[1] + ")");
            System.out.println("The Angle " + (char)(65 + i) + ": " + angle[i]);
        }
    }

    private static double[] SetAngles(double[] dist, int r, int idx) {
        double[] angle = new double[3];

        for (int i = 0; i < 3; i++) {
            angle[i] = Math.toDegrees(Math.asin(dist[i] / (2 * r)));

            if (idx == i) {
                angle[i] = 180 - angle[i];
            }
        }
        return angle;
    }

    private static int GetLargestDistIdx(double[] dist) {
        int idx = 0;
        double value = dist[0];
        for (int i = 1; i < 3; i++) {
            if (value < dist[i]) {
                idx = i;
                value = dist[i];
            }        
        }
        return idx;
    }

    // 사인 법칙으로 각 구하기 위해 두 점 사이 거리 구하기
    private static double GetDistanceUsingTwoPoint(ArrayList<int[]> plist, int i, int j) {
        int [] pointA = new int[2];
        int [] pointB = new int[2];

        pointA = plist.get(i);
        pointB = plist.get(j);
        return Util.GetDistance(pointA[0], pointA[1], pointB[0], pointB[1]);
    }
    //#endregion

    private static void Question_06(Scanner s) {
        double r = 40;
   
        System.out.println("Three random points are ");
        
        double angle = Util.RandInt(0, 359);
        double x = r * Math.cos(angle * Math.PI / 180);
        double y = r * Math.sin(angle * Math.PI / 180);
        System.out.println("(" + x + ", " + y + ")");
    
        angle = Util.RandInt(0, 359);
        x = r * Math.cos(angle * Math.PI / 180);
        y = r * Math.sin(angle * Math.PI / 180);
        System.out.println("(" + x + ", " + y + ")");
    
        angle = Util.RandInt(0, 359);
        x = r * Math.cos(angle * Math.PI / 180);
        y = r * Math.sin(angle * Math.PI / 180);
        System.out.println("(" + x + ", " + y + ")");
    }

    private static void Question_07(Scanner s) {
        double radius, angle, a_Interval;
        System.out.print("Enter the radius of the bounding circle: ");
        radius = s.nextDouble();

        a_Interval = 360.0 / 5;
        angle = 90 - a_Interval;
        System.out.println("The coordinates of five points on the pentagon are");

        for (int i = 0; i < 5; i++) {
            double x, y;
            x = radius * Math.cos(Math.toRadians(angle));
            y = radius * Math.sin(Math.toRadians(angle));
            System.out.println("(" + Util.MyRound(x, 2) + ", " + Util.MyRound(y, 2) + ")");
            angle += a_Interval;
        }
    }

    private static void Question_08(Scanner s) {
        System.out.print("Enter an ASCII code: ");
        
        int codeNum = s.nextInt();

        if (codeNum > 127 || codeNum < 0) {
            System.out.println("The ASCII Code does not exist..");
            return;
        }

        System.out.println("The character for ASCII code " + codeNum + " is " + Character.toString(codeNum));
    }

    private static void Question_09(Scanner s) {
        System.out.print("Enter a character: ");
        
        char code = s.nextLine().charAt(0);

        System.out.println("The Unicode for the character " + code + " is " + (int)code);
    }

    private static void Question_10(Scanner s) {
        String set1 =
        " 1 3 5 7\n" +
        " 9 11 13 15\n" +
        "17 19 21 23\n" +
        "25 27 29 31";

      String set2 =
        " 2 3 6 7\n" +
        "10 11 14 15\n" +
        "18 19 22 23\n" +
        "26 27 30 31";

      String set3 =
        " 4 5 6 7\n" +
        "12 13 14 15\n" +
        "20 21 22 23\n" +
        "28 29 30 31";

      String set4 =
        " 8 9 10 11\n" +
        "12 13 14 15\n" +
        "24 25 26 27\n" +
        "28 29 30 31";

      String set5 =
        "16 17 18 19\n" +
        "20 21 22 23\n" +
        "24 25 26 27\n" +
        "28 29 30 31";

      int day = 0;


      // Prompt the user to answer questions
      System.out.print("Is your birthday in Set1?\n");
      System.out.print(set1);
      System.out.print("\nEnter N for No and Y for Yes: ");
      char answer = s.nextLine().charAt(0);

      if (Character.toUpperCase(answer) == 'Y')
        day += 1;

      // Prompt the user to answer questions
      System.out.print("\nIs your birthday in Set2?\n");
      System.out.print(set2);
      System.out.print("\nEnter N for No and Y for Yes: ");
      answer = s.nextLine().charAt(0);

      if (Character.toUpperCase(answer) == 'Y')
        day += 2;

      // Prompt the user to answer questions
      System.out.print("\nIs your birthday in Set3?\n");
      System.out.print(set3);
      System.out.print("\nEnter N for No and Y for Yes: ");
      answer = s.nextLine().charAt(0);

      if (Character.toUpperCase(answer) == 'Y')
        day += 4;

      // Prompt the user to answer questions
      System.out.print("\nIs your birthday in Set4?\n");
      System.out.print(set4);
      System.out.print("\nEnter N for No and Y for Yes: ");
      answer = s.nextLine().charAt(0);

      if (Character.toUpperCase(answer) == 'Y')
        day += 8;

      // Prompt the user to answer questions
      System.out.print("\nIs your birthday in Set5?\n");
      System.out.print(set5);
      System.out.print("\nEnter N for No and Y for Yes: ");
      answer = s.nextLine().charAt(0);

      if (Character.toUpperCase(answer) == 'Y')
        day += 16;

      System.out.println("\nYour birthday is " + day + "!");
    }

    // 16진수 -> 2진수
    private static void Question_11(Scanner s) {
        int n;
        System.out.print("Enter a decimal value (0 to 15): ");
        n = s.nextInt();

        if (n > 15 || n < 0 ) {
            System.out.println(n + " is an invalid input");
            return;
        }

        System.out.println("The hex value is " + Integer.toHexString(n).toUpperCase());
    }

    private static void Question_12(Scanner s) {
        int n;
        System.out.print("Enter a hex digit: ");

        try {
            n = s.nextInt(16);
            System.out.println("The binary value is " + Integer.toBinaryString(n));
        }
        catch (Exception e) {
            System.out.println("An invalid input...");
        }
    }

    private static void Question_13(Scanner s) {
        char ch;
        String result = "";
        System.out.print("Enter a letter: ");
        ch = s.nextLine().charAt(0);

        if (!Character.isAlphabetic(ch)) {
            result = "an invalid input";
        }

        else if (Character.toUpperCase(ch) == 'A' ||
            Character.toUpperCase(ch) == 'E' ||
            Character.toUpperCase(ch) == 'I' ||
            Character.toUpperCase(ch) == 'O' ||
            Character.toUpperCase(ch) == 'U') {
            result = "a vowel";
        }
        else {
            result = "a consonant";
        }
        
        System.out.println(ch + " is " + result);
    }

    private static void Question_14(Scanner s) {
        char ch;
        int num;
        System.out.print("Enter a letter grade: ");

        ch = Character.toUpperCase(s.nextLine().charAt(0));

        switch (ch) {
            case 'A':
                num = 4;
                break;
            case 'B':
                num = 3;    
                break;
            case 'C':
                num = 2;
                break;
            case 'D':
                num = 1;
                break;
            case 'F':
                num = 0;
                break;
            default:
                System.out.println(ch + " is an invalid grade");
                return;
        }

        System.out.println("The numeric value for grade " + ch + " is " + num);
    }

    private static void Question_15(Scanner s) {
        char ch;
        int num;
        System.out.print("Enter a letter: ");
        ch = Character.toLowerCase(s.nextLine().charAt(0));

        if (ch >= 'a' && ch <= 'c') {
            num = 2;
        }
        else if (ch >= 'd' && ch <= 'f') {
            num = 3;
        }
        else if (ch >= 'g' && ch <= 'i') {
            num = 4;
        }
        else if (ch >= 'j' && ch <= 'l') {
            num = 5;
        }
        else if (ch >= 'm' && ch <= 'o') {
            num = 6;
        }
        else if (ch >= 'p' && ch <= 's') {
            num = 7;
        }
        else if (ch >= 't' && ch <= 'u') {
            num = 8;
        }
        else if (ch >= 'w' && ch <= 'z') {
            num = 9;
        }
        else {
            System.out.println(ch + " is an invalid input");
            return;
        }
        System.out.println("The corresponding number is " + num);
    }

    private static void Question_16(Scanner s) {
        char ch = (char)Util.RandInt('A', 'Z');

        System.out.println("A random uppercase letter is " + ch);
    }

    private static void Question_17(Scanner s) {
        int year, numOfMonth;
        String month;
        
        System.out.print("Enter a year: ");
        year = s.nextInt();
        s.nextLine();

        System.out.print("Enter a month: ");
        month = s.nextLine();
        
        if (month.equals("Jan")) {
            numOfMonth = 1;
        }
        else if (month.equals("Feb")) {
            numOfMonth = 2;
        }
        else if (month.equals("Mar")) {
            numOfMonth = 3;
        }
        else if (month.equals("Apr")) {
            numOfMonth = 4;
        }
        else if (month.equals("May")) {
            numOfMonth = 5;
        }
        else if (month.equals("Jun")) {
            numOfMonth = 6;
        }
        else if (month.equals("Jul")) {
            numOfMonth = 7;
        }
        else if (month.equals("Aug")) {
            numOfMonth = 8;
        }
        else if (month.equals("Sep")) {
            numOfMonth = 9;
        }
        else if (month.equals("Oct")) {
            numOfMonth = 10;
        }
        else if (month.equals("Nov")) {
            numOfMonth = 11;
        }
        else if (month.equals("Dec")) {
            numOfMonth = 12;
        }
        else {
            System.out.println(month + " is not a correct month name");
            return;
        }

        System.out.println(month + " " + year + " has " + MyCalendar.GetDayofMonth(numOfMonth, year) + " days");
    }

    private static void Question_18(Scanner s) {
        String input, result = "";
        char major, year;
        System.out.print("Enter two characters: ");
        input = s.nextLine();

        major = Character.toUpperCase(input.charAt(0));
        year = input.charAt(1);

        if (major == 'M') {
            result += "Mathematics";
        }
        else if (major == 'C') {
            result += "Computer Science";
        }
        else if (major == 'I') {
            result += "Information Technology";
        }
        else {
            System.out.println("Invalid input");
            return;
        }

        if (year == '1') {
            result += " Freshman";
        }
        else if (year == '2') {
            result += " Sophomore";
        }
        else if (year == '3') {
            result += " Junior";
        }
        else if (year == '4') {
            result += " Senior";
        }
        else {
            System.out.println("Invalid input");
            return;
        }
        System.out.println(result);
    }

    private static void Question_19(Scanner s) {
        String str_ISBN;
        int ISBN, temp, sum = 0, lastDigit;
        System.out.print("Enter the first 9 digits of an ISBN a string: ");
        str_ISBN = s.nextLine();
        temp = ISBN = Integer.parseInt(str_ISBN);

        if (str_ISBN.length() != 9) {
            System.out.println("Invalid input...");
            return;
        }

        for (int i = 1; i <= 9; i++) {
            sum += temp / (int)Math.pow(10, 9 - i) * i;
            temp %= (int)Math.pow(10, 9 - i);
        }
        lastDigit = sum % 11;
        System.out.println("The ISBN-10 number is " + ISBN + (lastDigit == 10 ? "X" : lastDigit));
    }

    private static void Question_20(Scanner s) {
        String str;
        System.out.print("Enter a string: ");

        str = s.nextLine();

        System.out.println("The length of String is " + str.length());
        System.out.println("Its first character is " + str.charAt(0));
    }

    private static void Question_21(Scanner s) {
        String str, pattern = "^\\d{3}-\\d{2}-\\d{4}$";
        System.out.print("Enter a SSN: ");
        str = s.nextLine();
        
        if (Pattern.matches(pattern, str)) {
            System.out.println(str + " is a valid social security number");
        }
        else {
            System.out.println(str + " is an invalid social security number");;
        }    
    }

    private static void Question_22(Scanner s) {
        String str1, str2;

        System.out.print("Enter string s1: ");
        str1 = s.nextLine();

        System.out.print("Enter string s2: ");
        str2 = s.nextLine();

        if (str1.contains(str2)) {
            System.out.println(str2 + " is a substring of " + str1);
        }
        else {
            System.out.println(str2 + " is not a substring of " + str1);
        }
    }

    private static void Question_23(Scanner s) {
        String name;
        int hour;
        double rate, federalTaxRate, stateTaxRate;
        double grossPay, federalTax, stateTax, totalDeduction, netPay;

        System.out.print("Enter employee\'s name: ");
        name = s.nextLine();

        System.out.print("Enter number of hours worked in a week: ");
        hour = s.nextInt();

        System.out.print("Enter hourly pay rate: ");
        rate = s.nextDouble();

        System.out.print("Enter federal tax withholding rate: ");
        federalTaxRate = s.nextDouble();

        System.out.print("Enter state tax withholding rate: ");
        stateTaxRate = s.nextDouble();

        grossPay = rate * hour;
        federalTax = grossPay * federalTaxRate;
        stateTax = grossPay * stateTaxRate;
        totalDeduction = federalTax + stateTax;
        netPay = grossPay - totalDeduction;

        // In bank system, they apply banker's rounding.. ref) https://wiki.c2.com/?BankersRounding
        // But, regarding this question, I would like to use math.floor to eliminate the last digit.
        // I would allow students who use round method to get score. 

        federalTax = Math.floor(federalTax  * 100) / 100; 
        stateTax = Math.floor(stateTax  * 100) / 100; 
        totalDeduction = Math.floor(totalDeduction  * 100) / 100; 
        netPay = Math.floor(netPay  * 100) / 100; 

        System.out.println("\nEmployee Name: " + name);
        System.out.println("Hours Worked: " + (double)hour);
        System.out.println("Pay Rate: $" + rate);
        System.out.println("Gross Pay: $" + grossPay);
        System.out.println("Deductions:");
        System.out.println("\tFederal Withholding (" + federalTaxRate * 100 + "%): $" + federalTax);
        System.out.println("\tState Withholding (" + stateTaxRate * 100 + "%): $" +  stateTax);
        System.out.println("\tTotal Deduction:  $" + totalDeduction);
        System.out.println("Net Pay: $" + netPay);
    }
    
    private static void Question_24(Scanner s) {
        String city_1, city_2, city_3;

        System.out.print("Enter the first city: ");
        city_1 = s.nextLine();

        System.out.print("Enter the second city: ");
        city_2 = s.nextLine();

        System.out.print("Enter the third city: ");
        city_3 = s.nextLine();

        if (city_1.compareTo(city_2) > 0) {
            String temp = city_1;
            city_1 = city_2;
            city_2 = temp;
        }

        if (city_1.compareTo(city_3) > 0) {
            String temp = city_1;
            city_1 = city_3;
            city_3 = temp;
        }

        if (city_2.compareTo(city_3) > 0) {
            String temp = city_2;
            city_2 = city_3;
            city_3 = temp;
        }

        System.out.println("The three cities in alphabetical order are " + city_1 + " " + city_2 + " " + city_3);
    }

    private static void Question_25(Scanner s) {
        String plateNumber = GeneratePlateNumber();

        while (!IsPlateNumber(plateNumber)) {
            plateNumber = GeneratePlateNumber();
        }

        System.out.println("The vehicle plate number is " + plateNumber);
    }

    private static boolean IsPlateNumber(String pNumber) {
        int countOfLetter = 0, countOfDigit = 0;
        
        for (int i = 0; i < pNumber.length(); i++) {
            if (pNumber.charAt(i) >= 'A' && pNumber.charAt(i) <= 'Z') {
                countOfLetter++;
            }
            else {
                countOfDigit++;
            }
        }

        if (countOfLetter != 3 && countOfDigit != 4) {
            return false;
        }

        return true;
    }

    private static String GeneratePlateNumber() {
        String pNumber = "";
        String elements = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        for (int i = 0; i < 7; i++) {
            int idx = Util.RandInt(0, elements.length(), true, false);
            pNumber += elements.charAt(idx);
        }

        return pNumber;
    }

    private static void Question_26(Scanner s) {
        String str_Amount;

        System.out.print("Enter an amount in double, for example ($11.56): ");
        str_Amount = s.nextLine();
        
        System.out.println("Your amount " + str_Amount + " consists of"); 
        System.out.println(" " + str_Amount.substring(0, str_Amount.indexOf('.')) + " dollars");
        System.out.println(" " + str_Amount.substring(str_Amount.indexOf('.') + 1) + " cents");
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

        s.close();
    }
}
