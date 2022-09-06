package Lectures.CPSC_225;

import java.util.ArrayList;
import java.util.Scanner;

import Commons.Sorts;

public class Wk_01 {
    // Question 1
    public static int[] Common(int[] arr1, int[] arr2) {
        
        int cnt = 0, idx = 0;
        int[] res;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    cnt++;
                    break;
                }
            }
        }

        res = new int[cnt];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    res[idx++] = arr1[i];
                    break;
                }
            }
        }
        return res;
    }

    public static int[] Common_1(int[] arr1, int[] arr2) {
        ArrayList<Integer> common = new ArrayList<Integer>(); 

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; i < arr2.length; j++) {
                if (arr1[i] == arr2[j]) {
                    Integer obj = arr1[i];
                    if (common.contains(obj)) {
                        common.add(obj);
                    }
                }
            }
        }
        int[] ret = new int[common.size()]; 
        for (int i = 0; i < common.size(); i++) {
            ret[i] = common.get(i).intValue();
        }
        return ret;
    }

    private static int[] MakeNoDuplicateArr(int[] arr) {
        ArrayList<Integer> aList = new ArrayList<Integer>(); 
        boolean isDuplicate;
        
        for (int i = 0; i < arr.length; i++) {
            isDuplicate = false;

            for (int j = 0; j < aList.size(); j++) {
                if (arr[i] == aList.get(j)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                aList.add(arr[i]);
            }
        }     
        return aList.stream().mapToInt(i -> i).toArray();
    }
    private static void Question_01(Scanner s) {
        int[] arr1 = {1, 2, 3, 4, 4, 444, 44, 4444};
        int[] arr2 = {10, 2, 4, 20, 4, 44};
        
        Sorts.QuickSort(arr1, 0, arr1.length);
        Sorts.QuickSort(arr2, 0, arr2.length);

        arr1 = MakeNoDuplicateArr(arr1);
        arr2 = MakeNoDuplicateArr(arr2);

        int[] common = Common(arr1, arr2);

        for (int i = 0; i < common.length - 1; i++) {
            System.out.print(common[i] + ", ");
        }
        System.out.println(common[common.length - 1]);
    }
    
    // Question 2
    public static int CountSpaces(String s) {
        if (s.length() == 0) {
            return 0;
        }
            
        else {
            int cnt = s.charAt(0) == ' ' ? 1 : 0;
            return cnt + CountSpaces(s.substring(1));
        }
    }

    private static void Question_02(Scanner s) {
        int x = CountSpaces("A B C ");

        System.out.println(x);
    }

    // Question 3
    public static int count(String str, char a, int lowIdx, int highIdx) {
        if (lowIdx == highIdx) {
            return str.charAt(lowIdx) == a ? 1 : 0;
        }
        else {
            return (str.charAt(lowIdx) == a ? 1 : 0) + count(str, a, ++lowIdx, highIdx);
        }
    }

    private static void Question_03(Scanner s) {
        String str;
        char ch;
        int low, high;

        System.out.print("Enter a String: ");
        str = s.nextLine();

        System.out.print("Enter a character: ");
        ch = s.nextLine().charAt(0);

        System.out.print("Enter a low index: ");
        low = s.nextInt();

        System.out.print("Enter a high index: ");
        high = s.nextInt();

        if (low > high || high >= str.length() || low < 0) {
            System.out.println("Invalid Input...");   
            return;
        }

        System.out.println("The number of occurrences for the character in the string is "
                    + count(str, ch, low, high));  
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Question_01(s);
        // Question_02(s);
        Question_03(s);
        
        s.close();
    }
}
