package Lectures.CPSC_225;

import java.util.ArrayList;
import java.util.Scanner;

import Lectures.CPSC_225.Classes.LinkedList;
import Lectures.CPSC_225.Classes.MyNode;

public class Wk_04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Question_01(s);
        Question_02(s);
        
        s.close();
    }

    private static void Question_02(Scanner s) {
    
        // Node node_1 = new Node(123);
        // Node node_2 = new Node(456);
        // Node node_3 = new Node(789);
        
        // node_2.setNext(node_3);
        // node_1.setNext(node_2);

        // Node head = node_1;

        // Node nodes = head;

        // System.out.println(nodes.getItem());

        // while (nodes.getNext() != null) {
        //     nodes = nodes.getNext();
        //     System.out.println(nodes.getItem());           
        // }


        LinkedList lList = new LinkedList(5);
        //lList.Show();
        lList.Add(5, 10);
        lList.Show();
    }

    private static void Question_01(Scanner s) {
        ArrayList<Integer> a = new ArrayList<>(10);

        for (int i = 0; i < 10; i++) {
            System.out.println(a.get(i));
        }

        // for (int i = 0; i < 10; i++) {
        //     a.add(i);
        //     a.add(i, i);
        // }
        
        // MyArrayList<Integer> ma = new MyArrayList<>();

        // for (int i = 0; i < 10; i++) {
        //     ma.add(i);
        //     ma.add(i, i * 2);
        // }

        // ma.size();

        // for (int i = 0; i < 10; i++) {
        //     System.out.println(ma.get(i));
        // }

        // ma.remove(1);


    }
}
