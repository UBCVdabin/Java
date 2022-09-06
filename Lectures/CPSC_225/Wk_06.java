package Lectures.CPSC_225;

import Lab.CPSC_225.LinkedList;
import Lectures.CPSC_225.Classes.*;

public class Wk_06 {
    private static void Question_01() {
        LinkedList list = new LinkedList(3);
        list.AddLast(4);
        list.AddLast(2);
        list.AddLast(1);
        list.AddLast(5);
        list.AddLast(6);
        list.AddLast(7);
        list.AddLast(8);
        list.Show();
        list.RemoveOddIndex();
        list.Show();
    }

    private static void Question_02() {
        DoublyLinkedList ll = new DoublyLinkedList(7);

        ll.ShowForward();                                                                                                                                                                                                                                                                                                                              

        // ll.InsertionSort();
        ll.QuickSort();
 
        ll.ShowForward();

        System.out.println(ll.size);
    }

    private static void Question_03() {         
        Stack s = new Stack();

        System.out.println(s);
        
        s.Push(123);
        s.Push(45);

        System.out.println(s);

        s.Pop();

        System.out.println(s);

        s.Pop();

        System.out.println(s);

        s.Pop();
    }

    private static void Question_04() {
        PriorityQueue q = new PriorityQueue();
        
        q.Enqueue(123);
        q.Enqueue(45);
        q.Enqueue(12);
        q.Enqueue(22);
        q.Enqueue(32);
        q.Enqueue(42);
        q.Enqueue(52);
        q.Enqueue(62);
        System.out.println(q);

        q.Dequeue();

        System.out.println(q);

        q.Dequeue();
        
        System.out.println(q);

        q.Dequeue();
        System.out.println(q);

        q.Dequeue();
        System.out.println(q);

        q.Dequeue();
        System.out.println(q);

        q.Dequeue();
    }

    public static void main(String[] args) {
        // Question_01();
        // Question_02();
        // Question_03();
        Question_04();
    }


}
