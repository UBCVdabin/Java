package Lab.CPSC_225;

public class Wk3Lab_Dabin_Im_10122964 {
    static boolean HasRepeated(String text) {   
        // ------------------------ Useful ------------------------- 

        // char [] chArray = someString.toCharArray();   O(n)
        // text.length() = O(1)

        // ---------------------------------------------------------

        // ---------------------------- Formula 1 -------------------------
        
        int length_I = text.length() - 1;        // count: 4
        int length_J = text.length();            // count: 3

        // int i = 0                             -> count: 2
        // i < length_I                          -> count: n - 1 + 1 = n
        // i++ => i = i + 1                      -> count: 2(n - 1)
        // ----------------------------------------------------------------

        for (int i = 0; i < length_I; i++) {
            // ---------------------------- Formula 2 -------------------------
                                                                            // (n - 1) ※ Within the loop
            char chI = text.charAt(i);          // count: 3                 =>   but... 3(n - 1) 

            // int j = j + 1                    -> count: 3                 =>   but... 3(n - 1) 

            
            // j < length_J                     -> count: 1 + 2 + ... + n   =>     n(n + 1) / 2 and j > lengh_J   
                                                                        //  =>     but, n - 1   and j > lengh_J  => 1
                                                                        //  =>     (n - 1) n / 2 + 1


            // j++ => j = j + 1                 -> count: 2(n - 1) n / 2    =>     n^2 - n

            // ----------------------------------------------------------------

            // ---------------------------- Formula 3 -------------------------
            for (int j = i + 1; j < length_J; j++) {                        // 1 + 2 + 3 + ... + n = n(n + 1) / 2
                                                                            // but, n - 1
                                                                            // (n - 1) n / 2  ※ Within the loop and the other loop

                char chJ = text.charAt(j);      // count: 3                 =>   but... 3(n - 1) n / 2
                if (chI == chJ) {               // count: 1                 =>   but... (n - 1) n / 2
                    return true;                
                }
            }
            // ----------------------------------------------------------------

        }

        // ---------------------------- Formula 4 -------------------------
        return false;                           // count: 1
        // ----------------------------------------------------------------

        
        // total count:
        // 4 + 3 + 2 + n + 2(n - 1) = 7 + 3n           
        // 3(n - 1) + 3(n - 1) + (n - 1) n / 2 + 1 + n^2 - n = 6n - 6 + n^2/2 - n/2 + 1 + n^2 - n = 3/2n^2 + 9/2n - 5
        // 3(n - 1)n/2 + (n - 1)n/2 = 2n^2 - 2n
        // 1
    
        // 7 + 3n + 3/2n^2 + 9/2n - 5 + 2n^2 - 2n + 1 = 7/2n^2 + 11/2n + 3
        // => 7/2n^2 + 11/2n + 3
        // O(7/2n^2 + 11/2n + 3) = O(n^2)  *  ignore coefficient of n^2 and + 11/2n + 3
                                           // Because the coefficient of n^2 and + 11/2n + 3 do not effect the shape 
                                           // when number of case goes up infinitely.
    }
    public static void main(String[] args) {
        System.out.println(HasRepeated("alexander"));
        System.out.println(HasRepeated("mango"));
    }
}
