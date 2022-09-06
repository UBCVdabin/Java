package Lectures.CPSC_225.Classes;

public class LinkedList {
    private MyNode head;
    private MyNode tail;
    private int cnt;

    public LinkedList() {
        head = null;
        cnt = 0;
    }

    public LinkedList(int size) {
        for (int i = 0; i < size; i++) {
            AddLast(i);
        }
    }

    private void CreateLinkedList(MyNode node) {
        tail = head = node;
        cnt++;
    }

    public LinkedList(MyNode node) {
        head = node;
    }

    public int Length() {
        return cnt;
    }

    public void AddLast(int z) {
        MyNode node = new MyNode(z);
        if (head == null) {
            CreateLinkedList(node);
        }
        else {
            tail.setNext(node);
            tail = tail.getNext();
            cnt++;
        }     
       
    }

    public void AddLast(MyNode node) {
        if (head == null) {
            CreateLinkedList(node);
        }
        else {
            tail.setNext(node);
            tail = tail.getNext();
            cnt++;
        }
    }

    public void AddFirst(int z) {
        MyNode node = new MyNode(z);
        
        if (head == null) {
            CreateLinkedList(node);
        }
        else {
            MyNode nodes = head;
            head = node;
            head.setNext(nodes);
            cnt++;
        }
    }

    public void AddFirst(MyNode node) {
        if (head == null) {
            CreateLinkedList(node);
        }
        else {
            MyNode nodes = head;
            head = node;
            head.setNext(nodes);
            cnt++;
        }
    }

    public void Show() {
        MyNode nodes = head;

        System.out.println(nodes.getItem());

        while (nodes.getNext() != null) {
            nodes = nodes.getNext();
            System.out.println(nodes.getItem());           
        }
    }

    public void Add(int index, int val) {
        if (index < 0 || index >= this.Length()) {
            return;
        }
        MyNode node = new MyNode(val);
        MyNode nodes;
        
        nodes = head;

        for (int i = 0; i < index; i++) {
            nodes = nodes.getNext();
        }

        node.setNext(nodes.getNext());
        nodes.setNext(node);
    }
}
