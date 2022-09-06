package Lectures.CPSC_225.Classes;

public class Queue {
    public Node front, rear;
    public DoublyLinkedList content;

    public Queue() {
        front = rear = null;
        content = new DoublyLinkedList();
    }

    public boolean IsEmpty() {
        return content.size == 0;
    }

    public void Enqueue(int item) {
        if (IsEmpty()) {
            content = new DoublyLinkedList();
        }
        content.AddLast(item);

        front = content.GetFirstNode();
        rear = content.GetLastNode();
    }

    public void Enqueue(Node node) {
        if (IsEmpty()) {
            content = new DoublyLinkedList();
        }
        content.AddLast(node);

        front = content.GetFirstNode();
        rear = content.GetLastNode();
    }

    public int Dequeue() {
        if (IsEmpty()) {
            System.out.println("Queue is Empty...");
            return -1;
        }
        Node node = content.GetFirstNode();
        content.RemoveFirst();

        front = content.GetFirstNode();
        rear = content.GetLastNode();
        
        return node.item;
    }

    // For General Queue
    public Node DequeueNode() {
        if (IsEmpty()) {
            System.out.println("Queue is Empty...");
            return null;
        }
        // Find Get Priority Node Idx;
        // int idx = content.GetPriorityNodeIdx(); 

        Node node = content.GetFirstNode();
        content.RemoveFirst();

        front = content.GetFirstNode();
        rear = content.GetLastNode();

        return node;
    }

    @Override
    public String toString() {
        return content.MakeStrBackward();
    }
}
