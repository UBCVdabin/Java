package Lectures.CPSC_225.Classes;

public class Stack {
    public Node top;
    public DoublyLinkedList content;

    public Stack() {
        top = null;
        content = new DoublyLinkedList();
    }

    public boolean IsEmpty() {
        return content.size == 0;
    }

    public void Push(int item) {
        if (IsEmpty()) {
            content = new DoublyLinkedList();
        }
        content.AddLast(item);  
        top = content.GetLastNode();
    }

    public int Pop() {
        if (IsEmpty()) {
            System.out.println("Stack is Empty...");
            return -1;
        }
        
        Node node = top;
        int res = node.item;

        content.RemoveLast();
        top = content.GetLastNode();
        
        node.prev = null;
        node = null;

        return res;
    }

    @Override
    public String toString() {
        return content.MakeStrForward();
    }
}
