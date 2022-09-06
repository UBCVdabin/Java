package Lectures.CPSC_225;
import java.util.Scanner;

import Lectures.CPSC_225.Classes.MyStack;


public class Wk_03 {
    
    public static void Question_01(Scanner s) {
        int max = 0, cnt = 0;
        int[] arr = {5, 4, 3, 2, 3};

        // 2  + n + n + n - 1  = 3n + 1
        for (int i = 0; i < arr.length - 1; i++) {
            // 3 * n
            int val = arr[i];

            // 2 (n(n - 1) / 2)
            for (int j = i + 1; j < arr.length; j++) {
                if (val == arr[j]) {
                    cnt++;
                }
            }

            if (cnt > max) {
                cnt = max;
            }
        }

        if (cnt > max) {
            cnt = max;
        }
    }

    /**
     * Stack
     */
    private static void Question_02(Scanner s) {
        MyStack<Double> st = new MyStack<>();

        for (int i = 0; i < 10; i++) {
            st.Push(i * 2.0);
        }

        System.out.println(st.GetTopItem());

        for(int i = 0; i < 10; i++) {
            System.out.println("Just removed: " + st.Pop());
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        Question_01(s);
        Question_02(s);

        s.close();;
    }

}
