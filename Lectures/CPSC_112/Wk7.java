package Lectures.CPSC_112;

public class Wk7 {
    private static int CountFactors(int num) {
        int cnt = 2;
        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) {
                cnt++;
            }
        }
        return cnt;
    }
    private static boolean isPrime(int num) {
        for (int divisor = 2; divisor <= num / 2; divisor++) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 2; i <= 15; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is a prime");
            }
            else {
                System.out.println(i + " is not a prime");
            }
            System.out.println("The number of Factors is " + CountFactors(i));
            System.out.println();
        }
    }
}
