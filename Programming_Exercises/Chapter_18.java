package Programming_Exercises;

import java.util.Scanner;

import Commons.*;

public class Chapter_18 {
    private static int fibCnt = 0;
    private static int hanoiCnt = 0;
    public static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        else {
            return num * factorial(--num);
        }
    }

    private static void Question_01(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        System.out.println(factorial(n));
    }

    public static int fib(int term) {
        fibCnt++;
        if (term == 0 || term == 1) {
            return term;
        }
        else {
            return fib(--term) + fib(--term);
        }
    }

    private static void Question_02(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        System.out.println(fib(n));
    }

    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        else {
            return gcd(n, m % n);
        }
    }

    private static void Question_03(Scanner s) {
        int m, n;

        System.out.print("Enter two integers: ");
        m = s.nextInt();
        n = s.nextInt();

        System.out.println("The GCD is " + gcd(m, n));
    }

    private static void PrintSumSeries(int n, char ch) {
        int initial = 1;
        PrintSumSeries(n, initial, ch);
    }

    private static void PrintSumSeries(int n, int endpoint, char ch) {
        if (n < endpoint) {
            return;
        }
        else {
            switch (ch) {
                case '1':
                    System.out.println("m(" + endpoint + ") = " + SumSeries_01(1, endpoint));
                    break;
                case '2':
                    System.out.println("m(" + endpoint + ") = " + SumSeries_02(1, endpoint));
                    break;
                case '3':
                    System.out.println("m(" + endpoint + ") = " + SumSeries_03(1, endpoint));
                    break;             
                default:
                    break;
            }
            PrintSumSeries(n, ++endpoint, ch);
        }
    }

    private static double SumSeries_01(int term, int endpoint) {
        double res = 1.0 / term;
        if (term == endpoint) {
            return res;
        }
        else {
            return res + SumSeries_01(++term, endpoint);
        }  
    }

    private static double SumSeries_02(int term, int endpoint) {
        double res = (double)term / (2 * term + 1);
        if (term == endpoint) {
            return res;
        }
        else {
            return res + SumSeries_02(++term, endpoint);
        }  
    }

    private static double SumSeries_03(int term, int endpoint) {
        double res = (double)term / (term + 1);
        if (term == endpoint) {
            return res;
        }
        else {
            return res + SumSeries_03(++term, endpoint);
        }  
    }

    private static void Question_04(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        PrintSumSeries(n, '1');
    }

    private static void Question_05(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        PrintSumSeries(n, '2');
    }

    private static void Question_06(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        PrintSumSeries(n, '3');
    }

    private static void Question_07(Scanner s) {
        fibCnt = 0;

        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        System.out.println(fib(n));
        System.out.println("The number of times the fib method is called is " + fibCnt);
    }

    public static void reverseDisplay(int value) {
        int reminder = value % 10;

        if (value / 10 == 0) {
            System.out.println(reminder);
        }
        else {
            System.out.print(reminder);
            reverseDisplay(value / 10);
        }
    }

    private static void Question_08(Scanner s) {
        int n;
        System.out.print("Enter an integer: ");
        n = s.nextInt();

        reverseDisplay(n);
    }

    public static void reverseDisplay(String value) {
        char ch = value.charAt(value.length() - 1);

        if (value.length() == 1) {
            System.out.println(ch);
        }
        else {
            System.out.print(ch);
            reverseDisplay(value.substring(0, value.length() - 1));
        }
    }

    private static void Question_09(Scanner s) {
        String str;
        System.out.print("Enter a String: ");
        str = s.nextLine();

        reverseDisplay(str);
    }

    public static int count(String str, char a) {
        int count = str.charAt(0) == a ? 1 : 0;
        if (str.length() == 1) {
            return count;
        }
        else {
            return count + count(str.substring(1), a);
        }
    }

    private static void Question_10(Scanner s) {
        String str;
        char ch;

        System.out.print("Enter a String: ");
        str = s.nextLine();

        System.out.print("Enter a character: ");
        ch = s.nextLine().charAt(0);

        System.out.println("The number of occurrences for the character in the string is "
                    + count(str, ch));  
    }

    public static int sumDigits(long n) {
        int res = (int)(n % 10);

        if (n / 10 == 0) {
            return res;
        }
        else {
            return res + sumDigits(n / 10);
        }
    }
    private static void Question_11(Scanner s) {
        long n;

        System.out.print("Enter an integer: ");
        n = s.nextLong();

        System.out.println(sumDigits(n));
    }

    public static void reverseDisplay(String value, int high) {
        char ch = value.charAt(high);
        if (high == 0) {
            System.out.println(ch);
        }
        else {
            System.out.print(ch);
            reverseDisplay(value, --high);
        }
    }

    private static void Question_12(Scanner s) {
        int high;
        String str;
        
        System.out.print("Enter a String: ");
        str = s.nextLine();

        System.out.print("Enter a high index: ");
        high = s.nextInt();

        if (high >= str.length() || high < 0) {
            System.out.println("Invalid Input...");
            return;
        }
        reverseDisplay(str, high);
    }

    private static int findLargestInteger(int[] arr, int idx) {
        int element = arr[idx];
        if (arr.length - 1 == idx) {
            return element;
        }
        else {
            int nextElement = findLargestInteger(arr, ++idx);
            return element > nextElement ? element : nextElement;
        }
    }

    private static void Question_13(Scanner s) {
        int [] arr = new int[8];
        System.out.print("Enter a list of eight integers: ");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("The largest number is " + findLargestInteger(arr, 0));
    }
  
    private static void Question_14(Scanner s) {
        String str;
        System.out.print("Enter a String: ");
        str = s.nextLine();

        System.out.println("The number of occurrences for the uppercase letters in the string is " 
                        + StringUtils.GetNumOfUpperLettersRecursive(str));
    }

    public static int count(String str, char a, int high) {
        int count = str.charAt(high) == a ? 1 : 0;
        if (high == 0) {
            return count;
        }
        else {
            return count + count(str, a, --high);
        }
    }

    private static void Question_15(Scanner s) {
        String str;
        char ch;
        int high;

        System.out.print("Enter a String: ");
        str = s.nextLine();

        System.out.print("Enter a character: ");
        ch = s.nextLine().charAt(0);

        System.out.print("Enter a high index: ");
        high = s.nextInt();

        if (high >= str.length() || high < 0) {
            System.out.println("Invalid Input...");   
            return;
        }

        System.out.println("The number of occurrences for the character in the string is "
                    + count(str, ch, high));  
    }

    public static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {
        char ch = chars[high];
        int count = ch >= 'A' && ch <= 'Z' ? 1 : 0;
        
        if (high == 0) {
            return count;
        }
        else {
            return count + count(chars, --high);
        }
    }

    private static void Question_16(Scanner s) {
        char[] arr;
        System.out.print("Enter a list of characters in one line: ");
        arr = s.nextLine().toCharArray();

        System.out.println("The number of occurrences for the uppercase letters in the string is " 
                        + count(arr));
    }

    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {
        char ch1 = chars[high];
        int count = ch1 == ch ? 1 : 0;
        
        if (high == 0) {
            return count;
        }
        else {
            return count + count(chars, --high);
        }
    }

    private static void Question_17(Scanner s) {
        char[] arr;
        char ch;
        System.out.print("Enter a list of characters in one line: ");
        arr = s.nextLine().toCharArray();

        System.out.print("Enter a character: ");
        ch = s.nextLine().charAt(0);

        System.out.println("The number of occurrences for the uppercase letters in the string is " 
                        + count(arr, ch));
    }

    public static void moveDisks(int n, char fromTower, char toTower, char auxTower) {
        hanoiCnt++;
        if (n == 1) {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
        }
        else {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }


    private static void Question_18(Scanner s) {
        int n;
        System.out.print("Enter number of disks: ");
        n = s.nextInt();

        // Find the solution recursively
        System.out.println("The moves are:");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("The number of moves needed to move n disks from tower A to tower B is " + hanoiCnt);
    }

    private static void Question_19(Scanner s) {
    }

    private static void Question_20(Scanner s) {
    }

    public static String dec2Bin(int value) {
        String digit = Integer.toString(value % 2);
        if (value / 2 == 0) {
            return digit;
        }
        else {
            return dec2Bin(value / 2) + digit;
        }
    }

    private static void Question_21(Scanner s) {
        System.out.print("Enter an integer: ");
        int value = s.nextInt();

        System.out.println(dec2Bin(value));
    }

    public static String dec2Hex(int value) {
        String digits = Util.dec2HexChar(value % 16);
        if (value < 16) {
            return digits;
        }
        else {
            return dec2Hex(value / 16) + digits;
        }
        
        /*
        String HexString = "";
        while (value != 0) {
            HexString = value % 16 + HexString;
            value = value / 16;
        }
        return HexString;
        */
    }

    private static void Question_22(Scanner s) {
        System.out.print("Enter an integer: ");
        int value = s.nextInt();

        System.out.println(dec2Hex(value));
    }

    public static int bin2Dec(String binaryString) {
        int num = Character.digit(binaryString.charAt(0), 10) * (int)Math.pow(2, binaryString.length() - 1); 

        if (binaryString.length() == 1) {
            return num;
        }
        else {
            return num + bin2Dec(binaryString.substring(1));
        }
    }

    private static void Question_23(Scanner s) {
        String str;

        System.out.print("Enter a binary string: ");
        str = s.nextLine();

        System.out.println(bin2Dec(str));
    }

    public static int hex2Dec(String binaryString) {
        int num = Util.char2HexDec(binaryString.charAt(0)) * (int)Math.pow(16, binaryString.length() - 1); 

        if (binaryString.length() == 1) {
            return num;
        }
        else {
            return num + bin2Dec(binaryString.substring(1));
        }
    }

    private static void Question_24(Scanner s) {
        String str;

        System.out.print("Enter a hex string: ");
        str = s.nextLine();

        System.out.println(hex2Dec(str));
    }

    public static String SwapElementForString(String s, int firstIdx, int lastIdx) {
        if (firstIdx == lastIdx) {
            return s;
        }

        String newString = "";
        char firstChar = s.charAt(firstIdx);
        char lastChar = s.charAt(lastIdx);
        
        newString += Character.toString(lastChar);
        
        newString += s.substring(firstIdx + 1, lastIdx);
        newString += Character.toString(firstChar);
        newString += s.substring(lastIdx + 1, s.length());
        return newString;
        
    }
    public static void displayPermutation(String s) {
        for (int i = 0; i < s.length(); i++) {
            //System.out.println(SwapElementForString(s, 0, i));
            displayPermutation("", SwapElementForString(s, 0, i));
        }             
    }

    public static void displayPermutation(String s1, String s2) {
        char ch = s2.charAt(0);
        s1 += Character.toString(ch);

        s2 = s2.substring(1);

        if (s2.length() == 0) {
            System.out.println(s1);
        }

        for (int i = 0; i < s2.length(); i++) {
            displayPermutation(s1, SwapElementForString(s2, 0, i));
        }
    }

    private static void Question_25(Scanner s) {
        displayPermutation("ABCD");
    }

    private static void Question_26(Scanner s) {
    }

    private static void Question_27(Scanner s) {
    }

    private static void Question_28(Scanner s) {
    }

    private static void Question_29(Scanner s) {
    }

    private static void Question_30(Scanner s) {
    }

    private static void Question_31(Scanner s) {
    }

    private static void Question_32(Scanner s) {
    }

    private static void Question_33(Scanner s) {
    }

    private static void Question_34(Scanner s) {
    }

    private static void Question_35(Scanner s) {
    }

    private static void Question_36(Scanner s) {
    }

    private static void Question_37(Scanner s) {
    }

    private static void Question_38(Scanner s) {
    }

    private static void Question_39(Scanner s) {
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
        Question_19(s);
        Question_20(s);
        // Question_21(s);
        // Question_22(s);
        // Question_23(s);
        // Question_24(s);
        // Question_25(s);
        Question_26(s);
        Question_27(s);
        Question_28(s);
        Question_29(s);
        Question_30(s);
        Question_31(s);
        Question_32(s);
        Question_33(s);
        Question_34(s);
        Question_35(s);
        Question_36(s);
        Question_37(s);
        Question_38(s);
        Question_39(s);

        s.close();
    }
}
