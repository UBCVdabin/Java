package Lectures.CPSC_225.Classes;

public class PriorityQueue extends Queue {
    public PriorityQueue() {
        super();
    }

     public int Dequeue() {
        if (IsEmpty()) {
            System.out.println("Queue is Empty...");
            return -1;
        }
        // Find Get Priority Node Idx;
        int idx = content.GetPriorityNodeIdx(); 

        Node node = content.GetNode(idx);
        int res = node.item;

        content.RemoveNode(idx);
        front = content.GetFirstNode();
        
        node.next = null;
        node.prev = null;
        node = null;

        return res;
    }


}

