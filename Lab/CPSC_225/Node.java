package Lab.CPSC_225;
public class Node {
    public int item;
    public Node next;
    public Node prev;
    
    public Node(){
        item = 0;
        next = null;
    }

    public Node(int val){
        item = val;
        next = null;
    }
}
