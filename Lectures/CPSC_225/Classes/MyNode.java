package Lectures.CPSC_225.Classes;

public class MyNode {
    private int item;
    private MyNode next;

    public MyNode(){
        item = 0;
        next = null;
    }

    public MyNode(int val){
        item = val;
        next = null;
    }
    
    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public MyNode getNext() {
        return next;
    }
    
    public void setNext(MyNode next) {
        this.next = next;
    }
}
