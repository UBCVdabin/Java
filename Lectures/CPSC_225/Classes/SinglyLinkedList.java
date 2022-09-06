package Lectures.CPSC_225.Classes;

public class SinglyLinkedList {
    // data members
    public Node head; //  address of the first node
    public Node tail; // address of the last node

    public SinglyLinkedList(){
        head = null;
        tail = null;
    }

    public void AddNodeLast(int value){
        // adds a node to the end of the linked list
        if(head == null){
            head = new Node(value);
            tail = head;
        }
        else{
            // create a new node after the last one and sets its value
            tail.next = new Node(value);
            tail = tail.next;
        }
    }

    public int Size(){
        // returns the number of nodes in the linked list
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void Show(){
        Node temp = head;
        while(temp.next != null){
            System.out.print(temp.item + " -> ");
            temp= temp.next;
        }
        System.out.println(temp.item + " .");
    }

    public void AddNodeFirst(int value){
        // adds a new node to the beginning of the list and sets it
        // as the new head node
        if(head == null){
            head =  new Node(value);
            tail = head;           
        }
        else{
            Node newNode = new Node(value);

            newNode.next = head;

            head = newNode;

        }
        
    }

    public void AddNode(int index, int value){
        // adds a new node at position index containing the item value
        // Suppose that ll is 123 -> 45 -> 678
        // ll.AddNode(1, 100) changes ll to 123 -> 100 -> 45 -> 678
        // hence a new node got added to index 1
        // HINT: you have to keep track of the previous node to the
        // point in the list where you want to add a new node

        // validate index so this method only works if index is between
        // 0 and (size of the linked list - 1) [both inclusive]
        int s = Size();
        if(index < 0 || index > s){
            System.out.println("Invalid index!");
            return;
        }
        else if(index == 0){
            // add new node at the beginning of the list
            AddNodeFirst(value);
        }
        else if(index == s - 1 ){
            AddNodeLast(value);
        }
        else{
            // first find the node at position index
            // also keep track of the previous node to node at position index
            Node previous = null;
            Node temp = head;
            int i = 0;
            while(i < index){
                previous = temp;
                temp = temp.next;
                i++;
            }

            Node newNode = new Node(value);

            previous.next = newNode;
            newNode.next = temp;
        }

    }    
}
