package Lectures.CPSC_225;

import Lectures.CPSC_225.Classes.*;

public class Wk_08 {
    private static void Question_01() {
        Tree t = new Tree();
        DoublyLinkedList path = new DoublyLinkedList();
        Node node = new Node(25);

        t.Add(25);
        t.Add(20);
        t.Add(30);
        t.Add(15);
        t.Add(24);
        t.Add(29);
        t.Add(35);
        t.Add(37);
        t.Add(39);

        t.BreadthFirstSearchDisplay();
        // t.BreadthFirstSearchDisplay();


        // t.InOrderDisplay();
        


        path = t.FindPath(node);

        // path.ShowForward();
    }

    public static void main(String[] args) {
        Question_01();
    }


}
