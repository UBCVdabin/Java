package Exam;

public class Midterm1Part1 {
    public static void main(String[] args) {
        int count = 0;

        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                for (int c = 1; c <= 100; c++) {
                    if ((int)Math.pow(a, 2) + (int)Math.pow(b, 2) == (int)Math.pow(c, 2)) {
                        System.out.println("Pythagorean numbers: " + a + ", " + b + ", " + c);
                        if (a + b + c > 50) {
                            count++;
                        }
                    }
                }
            }
        }
        System.out.println("\nPythagoream numbers (triples) that sum to over 50: " + count);    
    }
}
