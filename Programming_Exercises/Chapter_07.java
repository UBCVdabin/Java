package Programming_Exercises;

import java.util.ArrayList;
import java.util.Scanner;

import Commons.Sorts;
import Commons.Util;

class Student implements Comparable<Student> {
    private double score;
    private String name;

    public String getName() {
        return name;
    }
    public double getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student s) {
        // TODO Auto-generated method stub
        if (this.score < s.getScore()) {
            return -1;
        } else if (this.score > s.getScore()) {
            return 1;
        }
        return 0;
    }
}

public class Chapter_07 {
    private static char GetGrade(int i, int max) {
        char ch;

        if (i >= max - 10) {
            ch = 'A';
        }
        else if (i >= max - 20) {
            ch = 'B';
        }
        else if (i >= max - 30) {
            ch = 'C';
        }
        else if (i >= max - 40) {
            ch = 'D';
        }
        else {
            ch = 'F';
        }
        return ch;
    }

    private static void Question_01(Scanner s) {
        int n, max = 0;
        int [] arr;
        System.out.print("Enter the number of students: ");
        n = s.nextInt();

        arr = new int[n];
        System.out.print("Enter " + n + " scores: ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();

            if (max < arr[i]) {
                max = arr[i];
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Student " + i + " score is " +
                            arr[i] + " and grade is " + GetGrade(arr[i], max));
        }
    }

    private static void Question_02(Scanner s) {
        int [] arr = new int[10];

        System.out.print("Enter integers: ");

        for(int i = arr.length - 1; i >= 0; i--) {
            arr[i] = s.nextInt();
        }

        for(int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void Question_03(Scanner s) {
        ArrayList<Integer> arrList = new ArrayList<Integer>();
        
        int num;
        System.out.print("Enter the integers between 1 and 100: ");
        num = s.nextInt();

        while (num != 0) {
            arrList.add(num);
            num = s.nextInt();
        }

        if (arrList.size() == 0) {
            System.out.println("Empty...");
        }
        else {
            ArrayList<Integer> tempArrayList = new ArrayList<Integer>(); 
           
            for (int i = 0; i < arrList.size(); i++) {
                Integer obj = arrList.get(i);
                if (!tempArrayList.contains(obj)) {
                    tempArrayList.add(obj);
                }
            }
            int [] arr = tempArrayList.stream().mapToInt(i -> i).toArray();

            Sorts.QuickSort(arr, 0, arr.length);

            for (int i = 0; i < arr.length; i++) {
                int cnt = 0;
                int element = arr[i];
                
                for (int j = 0; j < arrList.size(); j++){
                    if (element == arrList.get(j)) {
                        cnt++;
                    }
                }
                System.out.println(element + " occurs " + cnt + (cnt > 1 ? " times" : " time"));
            }
        }
    }

    private static void Question_04(Scanner s) {

        double[] scores = new double[100];
        double sum = 0;
        int count = 0;
    
        double item;

        System.out.print("Enter a new score: ");

        item = s.nextDouble();
        
        while (item >= 0) {
            scores[count] = item;
            sum += item;
            count++;

            item = s.nextDouble();
          }

        System.out.println("count is " + count);
        double average = sum / count;
    
        int numOfAbove = 0;
        int numOfBelow = 0;
        for (int i = 0; i < count; i++) {
            if (scores[i] >= average) {
                numOfAbove++;
            } else {
                numOfBelow++;
            }
        }
    
        System.out.println("Average is " + average);
        System.out.println("Number of scores above or equal to the average "
            + numOfAbove);
        System.out.println("Number of scores below the average " + numOfBelow);
    }

    private static void Question_05(Scanner s) {
        int cnt = 0;
        int [] arr = new int[1];
        System.out.print("Enter 10 numbers: ");

        arr[cnt++] = s.nextInt();;
        for (int i = 1; i < 10; i++) {
            boolean isDuplicate = false;
            int num = s.nextInt();
            
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == num) {
                    isDuplicate = true;
                }
            }
            
            if (!isDuplicate) {
                int [] temp = new int[cnt + 1];
                for (int j = 0; j < arr.length; j++) {
                    temp[j] = arr[j];
                }
                temp[cnt++] = num;
                arr = temp;
            }
        }
        System.out.println("The number of distinct numbers is " + cnt);
        System.out.print("The distinct numbers are: ");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr[arr.length - 1]);
    }

    private static void Question_06(Scanner s) {
        final int NUM_OF_PRIMES = 50;
        // Store prime numbers
        int[] primeNumbers = new int[NUM_OF_PRIMES];
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness
        boolean isPrime = true; // Is the current number prime?
    
        System.out.println("The first 50 prime numbers are \n");
    
        // Repeatedly find prime numbers
        while (count < NUM_OF_PRIMES) {
          // Assume the number is prime
          isPrime = true;
    
          // Exercise03_21 if number is prime
          for (int i = 0; i < count &&
            primeNumbers[i] <= Math.sqrt(number); i++) {
            //If true, the number is not prime
            if (number % primeNumbers[i] == 0) {
              // Set isPrime to false, if the number is not prime
              isPrime = false;
              break; // Exit the for loop
            }
          }
    
          // Print the prime number and increase the count
          if (isPrime) {
            primeNumbers[count] = number;
            count++; // Increase the count
    
            if (count % 10 == 0) {
              // Print the number and advance to the new line
              System.out.println(number);
            }
            else
              System.out.print(number + "\t");
          }
    
          // Check if the next number is prime
          number++;
        }
    }

    private static void Question_07(Scanner s) {
        int[] arr = new int[10];

        for (int i = 1; i <= 100; i++) {
            int randInt = Util.RandInt(0, 9);
            arr[randInt]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i + "s: " + arr[i]);
        }
    }

    public static double average(double[] array) {
        double sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    private static void Question_08(Scanner s) {
        double[] arr = new double[10];

        System.out.print("Enter 10 numbers: ");
        
        for(int i = 0; i < 10; i++) {
            arr[i] = s.nextDouble();
        }
        System.out.println("The minimum number is " + average(arr));
    }

    public static double min(double[] array) {
        double min = array[0];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }

    private static void Question_09(Scanner s) {
        double[] arr = new double[10];

        System.out.print("Enter 10 numbers: ");
        
        for(int i = 0; i < 10; i++) {
            arr[i] = s.nextDouble();
        }
        System.out.println("The minimum number is " + min(arr));
    }

    public static int indexOfSmallestElement(double[] array) {
        int idx = 0;
        double min = array[idx];

        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min = array[i];
                idx = i;
            }
        }
        return idx;
    }

    private static void Question_10(Scanner s) {
        double[] arr = new double[10];

        System.out.print("Enter 10 numbers: ");
        
        for(int i = 0; i < 10; i++) {
            arr[i] = s.nextDouble();
        }
        System.out.println("The index of the smallest element is " + indexOfSmallestElement(arr));
    }

    /** Compute the deviation of double values */
    public static double deviation(double[] x) {
        double sum = 0;
        double mean = mean(x);

        for (int i = 0; i < x.length; i++) {
            sum += Math.pow(x[i] - mean, 2);
        }
        return Math.sqrt(sum / (x.length - 1));
    }

    /** Compute the mean of an array of double values */
    public static double mean(double[] x) {
        double sum = 0;

        for (int i = 0; i < x.length; i++) {
            sum += x[i];
        }
        return sum / x.length;
    }

    private static void Question_11(Scanner s) {
        double[] arr = new double[10];
        double mean, sd;
        System.out.print("Enter 10 numbers: ");

        for(int i = 0; i < 10; i++) {
            arr[i] = s.nextDouble();
        }

        mean = mean(arr);
        sd = deviation(arr);

        System.out.println("The mean is " + Util.MyRound(mean, 2));
        System.out.println("The mean is " + Util.MyRound(sd, 5));
    }

    private static void reverse(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[0]);
    }

    private static void Question_12(Scanner s) {
        int n = 10;
        int[] arr = new int[n];
        System.out.print("Enter 10 numbers: ");
        
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.print("reversed is ");
        reverse(arr);
    }

    private static void Question_13(Scanner s) {
        int[] exceptVals = {4, 8, 95, 93};
        
        for (int i = 1; i <= 45; i++) {
            if (i % 15 == 0) {
                System.out.println(String.format("%4d", Util.getRandom(1, 100, exceptVals)));
            }
            else {
                System.out.print(String.format("%4d", Util.getRandom(1, 100, exceptVals)));
            }
        }
    }

    public static int gcd(int... numbers) {
        int g = numbers[0];

        for (int i = 1; i < numbers.length; i++)
            g = Util.GCD(g, numbers[i]);

        return g;
    }

    private static void Question_14(Scanner s) {
        System.out.print("Enter five integers: ");
        
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++)
          numbers[i] = s.nextInt();
    
        System.out.println("The gcd of these five integers is " + gcd(numbers));
    }

    public static int[] eliminateDuplicates(int[] list) {
        int cnt = 1;
        int[] res = new int[cnt];
        res[0] = list[0];

        for (int i = 1; i < list.length; i++) {
            boolean isDuplicate = false;

            for (int j = 0; j < res.length; j++) {
                if (res[j] == list[i]) {
                    isDuplicate = true;
                    break;
                }
            }

            if(isDuplicate) {
                continue;
            }
            else {
                int[] temp = new int[++cnt];

                for(int k = 0; k < res.length; k++) {
                    temp[k] = res[k];
                }                
                temp[cnt - 1] = list[i];
                res = temp;
            }
        }
        return res;
    }

    private static void Question_15(Scanner s) {
        int n = 10;
        int[] arr = new int[n];
        int[] distinct;
        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        distinct = eliminateDuplicates(arr);
        System.out.print("The distinct numbers are: ");

        for (int i = 0; i < distinct.length - 1; i++) {
            System.out.print(distinct[i] + ", ");
        }
        System.out.println(distinct[distinct.length - 1]);
    }
    private static void Question_16(Scanner s) {
        int[] list = new int[100000];
        for (int i = 0; i < list.length; i++) {
          list[i] = i + 1;
        }
    
        int key = (int)(Math.random() * 1000000);
        long startTime = System.nanoTime();
        System.out.println(Util.LinearSearch(list, key));
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time for linear search is " +
                           executionTime);
    
        java.util.Arrays.sort(list);
        startTime = System.nanoTime();
        System.out.println(java.util.Arrays.binarySearch(list, key));
        endTime = System.nanoTime();
        executionTime = endTime - startTime;
        System.out.println("Execution time for binary search is " +
                           executionTime);
    }

    private static void Question_17(Scanner s) {
        int n;
        ArrayList<Student> sList = new ArrayList<Student>();
        
        System.out.print("Enter the number of students: ");
        n = s.nextInt();
        s.nextLine();

        for (int i = 0; i < n; i++) {
            Student st = new Student(); 
            System.out.print("Student's Name: ");
            st.setName(s.nextLine());

            System.out.print("Student's Score: ");
            st.setScore(s.nextDouble());
            s.nextLine();

            sList.add(st);
        }
        // List.sort의 역할 
        // sort 메서드는 일단 재정의된 Comparable 또는 Comparator 인터페이스가 필요하다. (Compare to 메서드로 값의 크기를 비교하기 위해)
        // Comparable 인터페이스를 상속받아 compareTo 메서드를 재정의하면
        // 해당 객체와 매개변수로 받은 객체를 비교하며 (이때 integer, double 아니면 문자열의 순서 [abc 중 a가 우선순위])
        // compareTo 에 나온 값으로 List 안의 순서를 옮겨가는 형식이다.
        // 처음에는 Insertion sort 형식으로 초기위치(idx)를 잡고 
        // 이때, 버블정렬 형식으로 인접한 값을 비교하면서 n 번째 객체가 n + 1 객체보다 값이 작을 경우 
        // 초기 인덱스에 위치한 객체의 위치를 n번째로 옮기면서
        // n 번째 객체를 초기 위치로 옮긴다.

        // 그런 후 n+1 인덱스 객체는 pivot 대상이 되면서 binary search 함과 동시에 정확한 위치에 insertion 하는 알고리즘이다.
        // 역시 비교를 하기 위해 compare 메서드가 주인공으로 이용되고 있다.

        sList.sort(null);
        //Collections.sort(sList);

        for (Student stu : sList) {
            System.out.print(stu.getName() + ": ");
            System.out.println(stu.getScore());
        }
    }

    private static void Question_18(Scanner s) {
        int n = 6;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Util.RandInt(1, 100);
        }

        Sorts.BubbleSort(arr);
        Util.PrintArray(arr);
    }



    private static void Question_19(Scanner s) {
        int n;
        int[] arr;
        System.out.print("Enter the size of the list: ");
        n = s.nextInt();

        arr = new int[n];

        System.out.print("Enter the contents of the list: ");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        
        System.out.print("The list has "+ n + " integers ");

        for (int i = 0; i < n - 1; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println(arr[n - 1]);
        System.out.println("The list is " + (Util.isSorted(arr) ? "already": "not") + " sorted");
    }

    private static void Question_20(Scanner s) {
        int n = 6;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Util.RandInt(1, 100);
        }
        Util.PrintArray(arr);
        Sorts.SelectionSortRecur(arr);
        Util.PrintArray(arr);
    }

    private static void Question_21(Scanner s) {
        int sum = 0;
        System.out.print("Enter integers: ");

        if (s.hasNextLine()) {
            s = new Scanner(s.nextLine()).useDelimiter(" ");
        }
        while (s.hasNextInt()) {
            sum += s.nextInt();
        }
        System.out.println("Total: " + sum);
    }

    private static void Question_22(Scanner s) {
        int cnt = 0;
        char[] chArr;
        System.out.print("Enter a String: ");

        chArr = s.nextLine().toCharArray();

        for (int i = 0; i < chArr.length; i++) {
            if (chArr[i] >= 'A' && chArr[i] <= 'Z') {
                cnt++;
            }
        }
        System.out.println("The number of uppercase letters in the string is " + cnt);
    }

    private static void Question_23(Scanner s) {
        int n = 100;
        boolean[] arr = new boolean[n];

        for (int i = 1; i <= n; i++) {
            int idx = i - 1;
            if (i == 1) {
                for (int j = idx; j < n; j++) {
                    arr[j] = true;
                }
            }
            else if (i == 2) {
                for (int j = idx; j < n; j++) {
                    arr[j] = false;
                }
            }
            else {
                for (int j = idx; j < n; j += i) {
                    if (arr[j] == false) {
                        arr[j] = true;
                    }
                    else {
                        arr[j] = false;
                    } 
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == true) {
                System.out.println("The Locker " + (i+1) + " is open");
            }
        }
    }

    private static void Question_24(Scanner s) {
        final int NUMBER_OF_CARDS = 52;

        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
          "10", "Jack", "Queen", "King"};

        // found indicates whether a suit has been picked
        boolean[] found = new boolean[4]; 
    
        // Count the number of picks
        int numberOfPicks = 0;
        
        // Count occurrence in each suit
        int count = 0;
        while (count < 4) {
            numberOfPicks++;
            int index = (int)(Math.random() * NUMBER_OF_CARDS);
            if (!found[index / 13]) {
                found[index / 13] = true;
                count++;
                
                String suit = suits[index / 13];
                String rank = ranks[index % 13];
                System.out.println(rank + " of " + suit);
            }
        }
        System.out.println("Number of picks: " + numberOfPicks);
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {
        int res;
        double a, b, c;
        a = eqn[0];
        b = eqn[1];
        c = eqn[2];

        double D = Math.pow(b, 2) - (4 * a * c);

        if (D > 0) {
            D = Math.pow(D, 0.5);

            roots[0] = (-b + D) / (2 * a);
            roots[1] = (-b - D) / (2 * a);
            
            res = 2;
        }
        else if (D < 0) {
            res = 0;
        }
        else {
            D = Math.pow(D, 0.5);

            roots[0] = (-b) / (2 * a);
            res = 1;
        }
        return res;
    }

    private static void Question_25(Scanner s) {
        int numOfRoots, n = 3;
        double[] eqn, root;
        eqn = new double[n--];
        root = new double[n];

        System.out.print("Enter a, b, c: ");

        for (int i = 0; i < eqn.length; i++) {
            eqn[i] = s.nextDouble();
        }
        
        numOfRoots = solveQuadratic(eqn, root);
        System.out.println("The number of real roots is " + numOfRoots);

        if (numOfRoots == 0) {
            System.out.println("The equation has no real roots");          
        }
        else if (numOfRoots == 1) {
            System.out.println("The equation has one root " + root[0]);
        }
        else {
            System.out.println("The equation has two roots " + Util.MyRound(root[0], Util._5TH) + " and " + Util.MyRound(root[1], Util._5TH));            
        }
    }

    public static boolean equals(int[] list1, int[] list2, boolean isStricted) {
        boolean res = true;

        if (list1.length != list2.length) {
            res = false;
        }
        else {
            if (!isStricted) {
                Sorts.MergeSort(list1);
                Sorts.MergeSort(list2);
            }
            for (int i = 0; i < list1.length; i++) {
                if (list1[i] != list2[i]) {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
    private static void Question_26(Scanner s) {
        int n1, n2;
        int[] arr1 = null, arr2 = null;
        System.out.print("Enter list1 size and contents: ");
        n1 = s.nextInt();
        arr1 = new int[n1];
        
        for (int i = 0; i < n1; i++) {
            arr1[i] = s.nextInt();
        }
        System.out.print("Enter list2 size and contents: ");
        n2 = s.nextInt();
        arr2 = new int[n2];
        
        for (int i = 0; i < n2; i++) {
            arr2[i] = s.nextInt();
        }
        System.out.println("Two lists are " + (equals(arr1, arr2, true) ? "" : "not ") + "strictly identical");
    }

    private static void Question_27(Scanner s) {
        int n1, n2;
        int[] arr1 = null, arr2 = null;
        System.out.print("Enter list1 size and contents: ");
        n1 = s.nextInt();
        arr1 = new int[n1];
        
        for (int i = 0; i < n1; i++) {
            arr1[i] = s.nextInt();
        }
        System.out.print("Enter list2 size and contents: ");
        n2 = s.nextInt();
        arr2 = new int[n2];
        
        for (int i = 0; i < n2; i++) {
            arr2[i] = s.nextInt();
        }
        System.out.println("Two lists are " + (equals(arr1, arr2, false) ? "" : "not ") + "identical");
    }

    private static void Question_28(Scanner s) {
        int n = 10;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Util.getRandom(1, 10, arr);
        }
   
        Sorts.QuickSort(arr);
        Util.PrintArray(arr, ',');

        // 향후 코드 수정해야할 것...
        Util.Combination(arr, 2);
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
        Question_29(s);
        Question_30(s);
        Question_31(s);
        Question_32(s);
        Question_33(s);
        Question_34(s);
        Question_35(s);
        Question_36(s);
        Question_37(s);

        s.close();
    }

}
