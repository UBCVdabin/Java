package Exam;

public class Midterm1Part2 {
    public static void main(String[] args) {
        FindTheLargestSeq("Aabbc");
        FindTheLargestSeq("aabbc");
        FindTheLargestSeq("aabbcccc");
    }

    private static void FindTheLargestSeq(String s) {
        char ch = s.charAt(0);
        char maxCh = ch;
        int cnt = 1, maxCnt = 0;

        for (int i = 1; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                cnt++;
            }
            else {
                if (maxCnt < cnt) {
                    maxCnt = cnt;
                    maxCh = ch;
                }
                ch = s.charAt(i);
                cnt = 1;
            }
        }
        if (maxCnt < cnt) {
            maxCnt = cnt;
            maxCh = ch;
        }
        System.out.println(maxCh + ", count: " + maxCnt);
    }
}
