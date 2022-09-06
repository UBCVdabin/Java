package Lectures.CPSC_225;

import Lectures.CPSC_225.Classes.Tree;

public class Wk_07 {
    private static void Question_01() {
        // basic test...
        Tree tree = new Tree();

        tree.Add(25);
        tree.Add(21);
        tree.Add(23);
        tree.Add(30);
        tree.Add(27);

        // in order : 12 23 30 35 40
        // tree.InOrderDisplay();
        // tree.PrintOddValuesInOrder();
        // System.out.println();


        // // pre order : 23 12 35 30 40
        // tree.PreOrderDisplay();
        // tree.PrintOddValuesInPreOrder();
        // System.out.println();


        // // post order : 12 30 40 35 23
        // tree.PostOrderDisplay();
        // tree.PrintOddValuesInPostOrder();

        System.out.println(tree.FindMaxValue());
        
        System.out.println(tree.FindMinValue());
    }

    private static void Question_02() {
        Tree tree = new Tree(7);
        tree.PostOrderDisplay();


        System.out.println("Size: " + tree.getSize());
        System.out.println("Max: " + tree.FindMaxValue());
        System.out.println("Sum: " + tree.FindSumOfAllValues());
        System.out.println("Avg: " + tree.FindAvgValue());
        tree.GetReduceValuesByAverage();
        tree.PostOrderDisplay();
    }

    private static void Question_03() {
        Tree t = new Tree();

        t.Add(25);
        t.Add(20);
        t.Add(30);
        t.Add(15);
        t.Add(24);
        t.Add(29);
        t.Add(35);

        t.BreadthFirstSearchDisplay();

        t.Delete(25);
        System.out.println();
        t.BreadthFirstSearchDisplay();
    }
    public static void main(String[] args) {
        /* 
        Question_01();
        Question_02(); // Homework
        */

        Question_03();

        
    }





}
