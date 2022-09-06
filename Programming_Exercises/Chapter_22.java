package Programming_Exercises;

import java.nio.charset.CharacterCodingException;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Pair;
import Classes.Point2D;
import Commons.Sorts;
import Commons.Util;

public class Chapter_22 {
    private static void Question_01(Scanner s) {
        int sIdx, lIdx;                             // count: 2
        char ch;                                    // count: 1 
        String str, subStr = "";                    // count: 3

        System.out.print("Enter a string: ");     // count: 1 
        str = s.nextLine();                         // count: 2 
        
        sIdx = 0;                                   // count: 1 
        lIdx = str.length();                        // count: 2 
        ch = str.charAt(sIdx);                      // count: 2 

        System.out.print("Maximum consecutive substring is ");  // count: 1 

        for (int i = 1; i < lIdx; i++) {                // count: 2 + n + 2(n - 1)
            if (ch == str.charAt(i)) {                  // count: 2(n - 1)
                if (subStr.length() < i - sIdx) {       // count: 3(n - 1)   
                    subStr = str.substring(sIdx, i);    // count: 2(n - 1)
                    
                    sIdx = i;                           // count: n - 1
                    ch = str.charAt(sIdx);              // count: 2(n - 1)
                }
            }
        }

        if (subStr.length() < lIdx - sIdx) {            // count: 3
            subStr = str.substring(sIdx, lIdx);         // count: 2
        }

        System.out.println(subStr);                     // count: 1

        // total cnt: 11 + 13n
        // O(13n + 11) = O(n)
    }

    private static void Question_02(Scanner s) {
        String str, subStr = "";
        char[] chArr;
        int sIdx, length;
        char ch;
        System.out.print("Enter a string: ");
        
        str = s.nextLine();
        length = str.length();
        sIdx = 0;
        ch = str.charAt(0);
        subStr = Character.toString(ch);

        System.out.print("Maximum increasingly ordered subsequence is ");  // count: 1 

        for (int i = 1; i < length; i++) {             // count: 
            char temp = str.charAt(i);
            
            if (ch < temp) {                           // count: 
                subStr += temp;
                ch = temp;
            }
        }
        System.out.println(subStr);                    // count: 1
    }

    private static void Question_03(Scanner s) {
        String s1, s2;
        int lastIdx, s1_Length, s2_Length;
        char ch;
        
        System.out.print("Enter a string s1: ");
        s1 = s.nextLine();
        s1_Length = s1.length();

        System.out.print("Enter a string s2: ");
        s2 = s.nextLine();
        s2_Length = s2.length();

        ch = s2.charAt(0);

        for (int i = 0; i < s1.length(); i++) {
            char temp = s1.charAt(i);
            lastIdx = i + s2_Length;

            if (temp == ch && lastIdx < s1_Length) {
                String subStr = s1.substring(i, lastIdx);

                if(s2.equals(subStr)) {
                    System.out.println("matched at index " + i);
                    return;
                }
            }
        }

        System.out.println("None");
    }

    // Boyer-Moore algorithm
    private static void Question_04(Scanner s) {
        String s1, s2;
        int lastIdx, s1_Length, s2_Length;
        char ch;
        
        System.out.print("Enter a string s1: ");
        s1 = s.nextLine();
        s1_Length = s1.length();

        System.out.print("Enter a string s2: ");
        s2 = s.nextLine();
        s2_Length = s2.length();

        ch = s2.charAt(0);

        for (int i = 0; i < s1.length(); i++) {
            char temp = s1.charAt(i);
            lastIdx = i + s2_Length;

            if (lastIdx >= s1_Length) {
                break;
            }

            if (temp == ch) {
                boolean isEqual = true;

                for (int j = 0; j < s2_Length; j++) {
                    if (s2.charAt(j) != s1.charAt(i + j)) {
                        isEqual = false;
                        i += j - 1;
                    }
                }

                if(isEqual) {
                    System.out.println("matched at index " + i);
                    return;
                }
            }
        }
        System.out.println("None");
    }

    private static void Question_05(Scanner s) {
        ArrayList<Integer> list = new ArrayList<>();
        
        int mCnt = 0, cnt = 0;
        int idx, num, size, temp;
        int mIdx, mNum;
        System.out.print("Enter a series of numbers ending with 0: ");

        num = s.nextInt();
        while (num != 0) {
            list.add(num);
            num = s.nextInt();
        }

        size = list.size();
        
        if (size == 0) {
            return;
        }

        mIdx = idx = 0;
        mNum = num = list.get(idx);
        mCnt = ++cnt;

        for (int i = 1; i < size; i++) {
            temp = list.get(i);
            if (num != temp) {
                if (cnt > mCnt) {
                    mIdx = idx;
                    mCnt = cnt;
                    mNum = num;
                }
                idx = i;
                num = temp;
                cnt = 1;
                continue;
            }
            cnt++;
        }

        if (cnt > mCnt) {
            mIdx = idx;
            mCnt = cnt;
            mNum = num;
        }
        System.out.println("The longest same number sequence starts at index " + mIdx + " with " + mCnt + " values of " + mNum);
    }

    private static void Question_06(Scanner s) {
        // Find the first 47 Fibonacci numbers
        final int INDEX = 47;
        int[] numbers = new int[INDEX];
        numbers[0] = 0;
        numbers[1] = 1;
        
        // O(n) 
        for (int i = 2; i < INDEX; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        System.out.println("\t\t\t40\t41\t42\t43\t44\t45");
		System.out.println("--------------------------------------------------------------");
		System.out.print("Listing 23.2 GCD1");

        long[] executionTime = new long[6];

		for (int i = 40; i <= 45; i++) {
	        long startTime = System.currentTimeMillis();
            gcd1(numbers[i], numbers[i + 1]);
            executionTime[i - 40] = System.currentTimeMillis() - startTime;
        }

        for (int i = 0; i <= 5; i++) {
            System.out.print("\t" + executionTime[i]);
        }

        System.out.print("\nListing 23.3 GCD2");

		for (int i = 40; i <= 45; i++) {
	    long startTime = System.currentTimeMillis();
			gcd2(numbers[i], numbers[i + 1]);
			executionTime[i - 40] = System.currentTimeMillis() - startTime;
		}

		for (int i = 0; i <= 5; i++) {
			System.out.print("\t" + executionTime[i]);
        }
    }

    /** From Listing 21.2: Find gcd for intergers m and n */
	public static int gcd1(int m, int n) {
		int gcd = 1;

		if (m == n) return m;

		for (int k = 1; k <= m / 2 && k <= n / 2; k++) {
			if (m % k == 0 && n % k == 0)
				gcd = k;
		}

		return gcd;
	}
	
    /** From Listing 21.3: Find gcd for intergers m and n */
	public static int gcd2(int m, int n) {
		if (m % n == 0)
			return n;
		else
			return gcd2(n, m % n);
	}

    /** Return the distance of the closest pair of points */
    // public static Pair getClosestPair(double[][] points) {
    //     double dist;
        
    //     Pair pair = new Pair(p1, p2)
    //     double minDist = Util.GetDistance(points[0][0], points[0][1]);
        
    //     int length_I = points.length;

    //     for (int i = 1; i < length_I; i++) {
    //         dist = Util.GetDistance(points[i][0], points[i][1]);
    //         if (minDist > )
    //     }
    // }

    /** Return the distance of the closest pair of points */
    // public static Pair getClosestPair(Point2D[] points)

    /** Return the distance of the closest pair of points 
     * in pointsOrderedOnX[low..high]. This is a recursive 
    * method. pointsOrderedOnX and pointsOrderedOnY are
    * not changed in the subsequent recursive calls.
    */
    // public static Pair distance(Point2D[] pointsOrderedOnX, int low, int high, Point2D[] pointsOrderedOnY) {

    // }

    /** Compute the distance between two points p1 and p2 */
    public static double distance(Point2D p1, Point2D p2) {
        return Util.GetDistance(p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }

    private static void Question_07(Scanner s) {
    }

    private static void Question_08(Scanner s) {
    }

    private static void Question_09(Scanner s) {
    }

    private static void Question_10(Scanner s) {
    }

    private static void Question_11(Scanner s) {
    }

    private static void Question_12(Scanner s) {
    }

    private static void Question_13(Scanner s) {
    }

    private static void Question_14(Scanner s) {
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
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Question_01(s);
        // Question_02(s);
        // Question_03(s);
        // Question_04(s);
        // Question_05(s);
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
