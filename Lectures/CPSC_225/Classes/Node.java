package Lectures.CPSC_225.Classes;

import Commons.Util;

public class Node {
    public int item;
 
    public int priority;        // for priority Queue
    public Node next;
    public Node prev;

    // For tree 
    public Node R;
    public Node L;
    public Node P;              // parent
    public int height;
    public int balanceFactor;
    //
    
    public Node() {
        item = 0;
        next = null;
        prev = null;
    }

    public Node(int val) {
        item = val;

        // generate a random integer between 1 and 3 (both inclusive)
        priority = Util.RandInt(1, 3);

        next = null;
        prev = null;
    }
}
