package Lab.CPSC_225;
public class LinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return head;
    }
    public Node getTail() {
        return tail;
    }

    public LinkedList(){
        head = tail = null;
    }

    public LinkedList(int n){
        // creates a new linked list with with n nodes where each node's value is 0
        head = null;

        for(int i = 0; i < n; i++){
            int r = (int)(Math.random() * 10);
            AddLast(r);
        }       
    }

    public int Length(){
        // returns the number of nodes in a linked list
        int count = 0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void AddLast(int z){
        // adds a new node to the end of the linked list with the value z
        Node newNode = new Node(z);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = tail.next;
        }
    } 
    
    public void AddFirst(int z){
        // adds a new node to the beginning of the linked list with the value z
        Node newNode = new Node(z);

        if(head == null){
            head = tail = newNode;
        }
        else{
            Node temp = head;
            head = newNode;
            head.next = temp;
        }

    } 

    public void Show(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.item + " -> ");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public void Add(int index, int z){
        int len = Length();
        if(index < 0 || index >= len){
            System.out.println("Invalid index try again!");
            return;
        }

        Node newNode = new Node(z);
        if(index == 0){
            newNode.next = head.next;
            head.next = newNode;
            return;
        }
        if(index == len - 1){
            AddLast(z);
            return;
        }

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        // temp points to the node of interest
        // adding a new node after the node of interest
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public Node FindNode(int index){
        Node n1 = head;
        for(int i  = 0; i < index; i++){
            n1 = n1.next;
        }
        return n1;
    }
    public void Swap(int index1, int index2){
        // given that index1 and index2 are both valid indices then
        // this method swaps the two nodes at those indices
        int len = Length();
        if(index1 < 0 || index1 >= len || index2 < 0 || index2 >= len || index1 >= index2){
            System.out.println("Invalid indices for swap! Try again");
            return;
        }

        // simple swap
        Node n1 = FindNode(index1);
        Node n2 = FindNode(index2);

        int temp = n1.item;
        n1.item = n2.item;
        n2.item = temp;

        // rewrite swap without swapping the data-content of each node rather swapping the connections in a linked list
    }
    public void BubbleSortSimple(){
        // bubble sorts the linked list in ascending order
        // must have a method named swap nodes

        int len = Length();
        for(int k = 0; k < len - 1; k++){
            Node temp = head;
            for(int i = 0; i < len - 1; i++){
                if(temp.item > temp.next.item){
                    Swap(i, i+1);
                }
                temp = temp.next;
            }
        }
    }

    public void SelectionSort(){
        int len = Length();
        Node n1 = head;
        for(int i = 0; i < len - 1; i++){
            int minValue = n1.item, minIdx = i;
            Node n2 = n1.next;
            
            for(int j = i + 1; j < len; j++){          
                if(minValue > n2.item){
                    minValue = n2.item;
                    minIdx = j;
                }
                n2 = n2.next;
            }

            if (minIdx != i) {
                SwapNode(i, minIdx);
                this.Show();
            }
            n1 = n1.next;
        }
    }

    public void MergeSort(){
        LinkedList ll = MergeSort(this);
        this.head = ll.head;
        this.tail = ll.tail;
    }

    public LinkedList Copy(int index1, int index2) {
        LinkedList ll = new LinkedList();
        Node n = FindNode(index1);
        ll.AddLast(n.item);

        for (int i = index1 + 1; i < index2; i++) {
            n = n.next;
            ll.AddLast(n.item);
        } 
        return ll;
    }

    public LinkedList Merge(LinkedList ll1, LinkedList ll2) {
        LinkedList merge = new LinkedList();

        int i = 0, j = 0;
        int n1 = ll1.Length(), n2 = ll2.Length();
        Node node1 = ll1.head; 
        Node node2 = ll2.head;

        while (i < n1 && j < n2) {
            int item1 = node1.item;
            int item2 = node2.item;
            if (item1 <= item2) {
                merge.AddLast(item1);
                node1 = node1.next;
                i++;
            }
            else {
                merge.AddLast(item2);
                node2 = node2.next;
                j++;
            }
        }
        
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            merge.AddLast(node1.item);
            node1 = node1.next;
            i++;
        }
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            merge.AddLast(node2.item);
            node2 = node2.next;
            j++;
        }

        return merge;
    }

    public LinkedList MergeSort(LinkedList ll) {
        int middle = ll.Length() / 2;

        if (ll.Length() <= 1) {
            return ll;
        }

        LinkedList L = ll.Copy(0, middle);
        LinkedList R = ll.Copy(middle, ll.Length());

        L = MergeSort(L);
        R = MergeSort(R);

        return Merge(L, R);
    }

    public void SwapNode(int index1, int index2) { 
        int len = this.Length();

        if (index1 < 0 || index1 >= len || index2 < 0 || index2 >= len || index1 >= index2) {
            System.out.println("Invalid");
            return;
        }

        int gap = index2 - index1;
        Node n1, prev = null;
        if (index1 == 0) {
            n1 = head;
        }
        else {
            prev = head;

        }

        for (int i = 0; i < index1 - 1; i++) {
            prev = prev.next;
        }
        n1 = prev.next; 
        
        Node n2, gapNode;

        if (gap > 1) {
            gapNode = n1;
            Node temp = new Node(n1.item);
            temp.next = n1.next;
            for (int i = 0; i < gap - 1; i++) {
                gapNode = gapNode.next;
            }
           n2 = gapNode.next;

           n1.next = n2.next;
           gapNode.next = n1;
           n2.next = temp.next;
        }
        else {
            n2 = n1.next;
            n1.next = n2.next;
            n2.next = n1;
        }

        if(prev != null) {
            prev.next = n2;
        } 
    }
    public void BubbleSort() {
        for (int i = 1; i < this.Length(); i++) {
            Node n = head;
            for (int j = 0; j < this.Length() - i; j++) {
                if (n.item > n.next.item) {
                    SwapNode(j, j + 1);
                    this.Show();
                }
                else {
                    n = n.next;
                }
            }
        }
    }

    public void RemoveAllOddIntegers() {
        Node temp = head;
        LinkedList newNodes = null;
        while (temp != null) {
            if (temp.item % 2 == 0) {
                newNodes = new LinkedList(temp.item);
            }
            temp = temp.next;
        }

        if (newNodes == null) {
            head = tail = null;
        }
        else {
            this.head = newNodes.getHead();
            this.tail = newNodes.getTail();
        }
    }

    public void RemoveOddNodes() {
        Node prev = null;
        Node temp = head;
        
        while (temp != null) {
            if (temp.item % 2 != 0) {
                Node delNode = temp;
                if (prev == null) {
                    head = temp.next;
                }
                else {
                    prev.next = temp.next;
                    if (tail == temp) {
                        tail = prev;
                    }
                }
                temp = temp.next;
                delNode = null;
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }    
    }

    public void RemoveOddIndex() {
        Node prev = null;
        Node temp = head;
        int cnt = this.Length();
        
        if (cnt <= 1) {
            return;
        }
        
        // initialize
        prev = temp;
        temp = temp.next;

        for (int i = 2; i < cnt; i += 2) {
            Node delNode = temp;
            temp = temp.next;
            prev.next = temp;
            prev = prev.next; 
            temp = temp.next;
            // last 
            if (i + 2 >= cnt) {
                tail = prev;
                prev.next = null;
                break;
            }
        
            delNode = null;
        }
    }
}

