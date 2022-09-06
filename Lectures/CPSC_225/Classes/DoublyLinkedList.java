package Lectures.CPSC_225.Classes;

import Commons.Util;

public class DoublyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public DoublyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public DoublyLinkedList(int n) {
        for (int i = 0; i < n; i++) {
            AddLast(Util.RandInt(1, 99));
        }
    }
    public boolean IsEmpty() {
        return size == 0;
    }

    public void RemoveFirst() {
        if(IsEmpty()) {
            System.out.println("Empty...");
            return;
        }
        Node deleteNode = head;
        head = head.next;
        
        if (head == null) {
             // if head is not equal to tail.. (In other words, the size is 0)
            head = tail = null;
        }
        else {
            head.prev = null;
        }

        deleteNode.next = null;
        deleteNode = null;
        size--;
    }

    public void RemoveLast() {
        if(IsEmpty()) {
            System.out.println("Empty...");
            return;
        }
        Node deleteNode = tail;
        tail = tail.prev;

        if (tail == null) {
            // if tail is equal to head.. (In other words, the size is 0)
            head = tail = null;
        }
        else {
            tail.next = null;
        }
    
        deleteNode.prev = null;
        deleteNode = null;
        size--;
    }
    public void AddFirst(int val) {
        Node newNode = new Node(val);

        if (size == 0) {    
            head = tail = newNode;
        }
        else {
            head.prev = newNode;
            newNode.next = head;
            head = head.prev;
        }
        size++;
    }
    private void AddFirst(Node node) {
        node.next = head;
        head.prev = node;
        node.prev = null;
        head = node;

        size++;
    }
    
    private void AddNode(Node node) {
        if (size == 0) {    
            head = tail = node;
        }
        else {   
            tail.next = node;
            node.prev = tail;
            tail = tail.next;        
        }
        size++;
    }

    public void AddLast(int val) {
        Node newNode = new Node(val);
        AddNode(newNode);
    }

    public void AddLast(Node node) {
        AddNode(node);
    }  

    public void AddNode(int index, int val) {
        if (!isValidIdx(index)) {
            System.out.println("Error...");
            return;
        }

        int lastIdx = size - 1;
        
        if (index == 0) {
            AddFirst(val);
        }
        else if (index == lastIdx) {
            AddLast(val);
        }
        else {
            Node newNode = new Node(val);
            Node temp = head;
            for (int i = 1; i < lastIdx; i++) {
                if (index == i) {
                    newNode.next = temp.next;
                    temp.next.prev = newNode;
                    newNode.prev = temp;
                    temp.next = newNode;
                    break;
                }
                temp = temp.next;
            }
        }
        size++;
    }
    private void AddNode(int idx, Node node) {
        Node R = head; 
        Node L = R.next;
        
        for (int i = 1; i < idx; i++) {
            R = L;
            L = L.next;
        }

        R.next = node;
        node.prev = R;
        L.prev = node;
        node.next = L;
        
        size++;
    }

    private boolean isValidIdx(int index) {
        return index < size && index >= 0;
    }

    public void RemoveNodesWithOddValues() {
        int cnt = 0;

        Node prev = null;
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.item % 2 == 0) {
                prev = temp;
                temp = temp.next;
                continue;
            }
            // if odd
            Node del;
            // head
            if (prev == null) {
                del = head;
                head = head.next;
                head.prev = null;
                temp = head;

                // delete
                del.next = null;
                del = null;
            }
            else {
                del = temp;

                temp = temp.next;
                prev.next = temp;

                if (temp == null) {
                    // tail
                    tail = prev;
                }
                else {
                    temp.prev = prev;
                }

                del.next = null;
                del.prev = null;
                del = null;
            }
            cnt++;
        }

        size -= cnt;
    }

    public void RemoveNodesWithOddIndex() {
        int cnt = 0;
        // initialize
        Node prev = head; // even
        Node temp = prev.next; // odd
        
        for (int i = 1; i < size; i += 2) {
            Node del = temp;  // odd
            
            // move to next node
            temp = temp.next;

            // connect forward
            prev.next = temp; // even

            // if size is even 
            if (temp == null) {
                tail = prev; 
            }
            else {
                // connect backward
                temp.prev = prev;

                // move to next node (even) -> 0, 2, 4...
                prev = prev.next;
                temp = prev.next; // odd

                // clear reference data
                del.next = null;
                del.prev = null;
                del = null;
            }
            cnt++;
        }

        size -= cnt;
    }

    public void RemoveNode(int index) {
        if (!isValidIdx(index)) {
            System.out.println("Error...");
            return;
        }
        int lastIdx = size - 1;
        Node del;

        if (index == 0) {
            // move head forward
            del = head;
            head = head.next;
            head.prev = null;

            // clear reference data
            del.next = null;
            del = null;
        }
        else if (index == lastIdx) {
            // move tail backward
            del = tail;
            tail = tail.prev;
            tail.next = null;

            // clear reference data
            del.prev = null;
            del = null;
        }
        else {
            Node prev = head;
            Node temp = prev.next;

            for (int i = 1; i < lastIdx; i++) {
                if (i == index) {
                    del = temp;
                    // move to the next node
                    temp = temp.next;
                    
                    // re-allocate links
                    prev.next = temp;
                    temp.prev = prev;
                    
                    // clear reference data
                    del.next = null;
                    del.prev = null;
                    del = null;
                }
                prev = temp;
                temp = prev.next;
            }
        }

        size--;
    }

    public void InsertionSortMyMethod() {
        Node prevNode, nextNode = head;
        Node duplicateNode;
        // find Idx which prev Node is bigger than current Node
        int insertIdx = -1;
        // Find backward to reduce n time..
        for (int i = 1; i < size; i++) {
            nextNode = nextNode.next;
            prevNode = nextNode.prev;
            int shiftIdx = i;

            for (int j = i - 1; j >= 0; j--) { 
                // compare
                if (prevNode.item > nextNode.item) {
                    insertIdx = j;
                    prevNode = prevNode.prev;
                }
                else {
                    break;
                }
            }

            if (insertIdx == -1) {
                continue;
            }
            
            // Insert current Node before prev Node
            
            // For test 
            // this.ShowForward();
            // System.out.println(this.size);  

            duplicateNode = new Node(nextNode.item);

            if (insertIdx == 0) {
                this.AddFirst(duplicateNode);
            }
            else {
                this.AddNode(insertIdx, duplicateNode);
            }
            // For test 
            // this.ShowForward();
            // System.out.println(this.size);        
            
            // Shift Node 
            // ShiftIdx + 1 -> because the size temporarily increase by 1
            if (shiftIdx == size) {
                this.RemoveLast();
            }
            else {
                this.RemoveNode(shiftIdx + 1);
            }
            
            // For test
            // System.out.println(this.size);       
            // this.ShowForward();
            
            // Reset 
            nextNode = GetNode(shiftIdx);
            insertIdx = -1;
        }
    }

    public void InsertionSort(){
        // apply insertion sort algorithm to sort the linked list
        // you can add more methods if necessary
        Node nextNode = head;

        for (int i = 1; i < size; i++) {
            nextNode = nextNode.next;
            Node prevNode = head;
            for (int j = 0; j < i;) { 
                // compare
                if (prevNode.item > nextNode.item) {
                    Swap(j, i);

                    // for test
                    // this.ShowForward(); 

                    // reset
                    nextNode = GetNode(i);
                    prevNode = GetNode(j);
                }
                else {
                    prevNode = prevNode.next;
                    j++;
                }
            }
        }
    }

    public void Swap(int sIndex, int lIndex) {
        // swaps node at index1 with node at index2
        // swap by swapping connections NOT content of the nodes
        // validate index1 and index2
        // consider all possible situations
        if (!isValidIdx(sIndex) || !isValidIdx(lIndex)) {
            System.out.println("Error...");
            return;
        }
   
        if (sIndex == lIndex) {
            return;
        }
        else if (sIndex == 0 && lIndex == size - 1) {
            Node sNext, lPrev;

            sNext = head.next;
            lPrev = tail.prev;

            head.prev = tail.prev;
            lPrev.next = head;

            tail.next = head.next;
            sNext.prev = tail;

            head.next = null;
            tail.prev = null;

            // swap
            Node temp = head;
            head = tail;
            tail = temp;
        }
        else if (sIndex == 0) {
            Node lNode, lPrev, lNext;
            // swap   
            if (sIndex + 1 == lIndex) { 
                // next to each other
                lNode = head.next;
                lNext = lNode.next;

                head.prev = lNode;
                lNode.next = head;

                head.next = lNext;
                lNext.prev = head;

                lNode.prev = null;

                head = lNode;
            }
            else {
                lPrev = head.next;
                lNode = lPrev.next;
                lNext = lNode.next;

                // Set lIdxNode
                for (int i = 2; i < lIndex; i++) {
                    lPrev = lNode;
                    lNode = lNext;
                    lNext = lNext.next;
                }
                Node hNext = head.next;

                hNext.prev = lNode;
                lNode.next = hNext;
                lNode.prev = null;
                head.next = lNext;
                lNext.prev = head;
                head.prev = lPrev;
                lPrev.next = head;

                head = lNode;
            }
        }
        else if (lIndex == size - 1) {
            Node sNode, sPrev, sNext;

            // swap   
            if (sIndex + 1 == lIndex) { 
                // next to each other
                sNode = tail.prev;
                sPrev = sNode.prev;

                tail.next = sNode;
                sNode.prev = tail;
                tail.prev = sPrev;
                sPrev.next = tail;

                sNode.next = null;

                tail = sNode;
            }
            else {
                sPrev = null;
                sNode = head;
                sNext = sNode.next;
                // Set sIdxNode
                for (int i = 0; i < sIndex; i++) {
                    sPrev = sNode;
                    sNode = sNext;
                    sNext = sNext.next;
                }
                Node tPrev = tail.prev;

                sNode.prev = tPrev;
                tPrev.next = sNode;

                sNode.next = null;

                tail.next = sNext;
                sNext.prev = tail;
                tail.prev = sPrev;
                sPrev.next = tail; 
                
                tail = sNode;
            }
        }
        else {
            Node sNode, sPrev, sNext, lNode, lPrev, lNext;

            sPrev = head;
            sNode = sPrev.next;
            sNext = sNode.next;

            // Set sIdxNode
            for (int i = 1; i < sIndex; i++) {
                sPrev = sNode;
                sNode = sNext;
                sNext = sNext.next;
            }

            // swap   
            if (sIndex + 1 == lIndex) { 
                // next to each other
                lNode = sNext;
                lNext = lNode.next;

                sNode.prev = lNode;
                lNode.next = sNode;
                sNode.next = lNext;
                lNext.prev = sNode;
                lNode.prev = sPrev;
                sPrev.next = lNode;
            }
            else {
                lPrev = sNext;
                lNode = lPrev.next;
                lNext = lNode.next;
               
                for (int i = 2; i < lIndex - sIndex; i++) {
                    lPrev = lNode;
                    lNode = lNext;
                    lNext = lNext.next;
                }

                sNode.next = lNext;
                lNext.prev = sNode;
                sNode.prev = lPrev;
                lPrev.next = sNode;

                lNode.next = sNext;
                sNext.prev = lNode;
                lNode.prev = sPrev;
                sPrev.next = lNode;
            }      
        }
    }

    public int Partition(int low, int high) {
        int pivot = low++;

        Node pivotNode = GetNode(pivot);
        while (low <= high) {
            Node lowNode = GetNode(low);
            while (pivotNode.item >= lowNode.item) {
                lowNode = GetNode(++low);

                if (low > high){
                    break;
                }
            }
            Node highNode = GetNode(high);
            while (pivotNode.item < highNode.item) {
                highNode = GetNode(--high);

                if (high < low) {
                    break;
                }
            }

            if (low < high) {
                Swap(low, high);
            }
        }
        Swap(pivot, high);

        return high;
    }

    public void QuickSort() {
        QuickSort(0, this.size - 1);
    }

    public void QuickSort(int low, int high) {
        if (low < high) {
            int partitionIndex = Partition(low, high);

            QuickSort(low, partitionIndex - 1);
            QuickSort(partitionIndex + 1, high);
        }
    }

    public String MakeStrForward() {
        String content = "";
        Node temp = head;

        if (IsEmpty()) {
            return "Empty...";
        }

        content += temp.item;
        temp = temp.next;

        while(temp != null) {
            content += " -> " + temp.item;
            temp = temp.next;
        }

        return content;
    }

    public void ShowForward () {
        System.out.println(this.MakeStrForward());
    }

    public String MakeStrBackward() {
        String content = "";
        Node temp = tail;

        if (IsEmpty()) {
            return "Empty...";
        }

        content += temp.item;
        temp = temp.prev;

        while(temp != null) {
            content += " -> " + temp.item;
            temp = temp.prev;
        }

        return content;
    }

    public void ShowBackward () {
        System.out.println(this.MakeStrBackward());
    }

    public int GetSize() {
        return size;
    }

    public Node GetLastNode() {
        return tail;
    }

    public Node GetFirstNode() {
        return head;
    }

    public int GetPriorityNodeIdx() {
        Node temp = head;
        
        if (IsEmpty()) {
            return -1;
        }

        // initialize first item if exists.
        int priority = temp.priority; // default 
        Node tempNode = temp;
        int idx = 0;
        
        for (int i = 1; i < size; i++) {
            temp = temp.next;
            if (temp.priority > priority) {
                priority = temp.priority;
                // test
                tempNode = temp;
                idx = i;
            }
        }
        System.out.println("Priority: " + priority + " Node: " + tempNode.item);
        return idx;       
    }

    public Node GetNode(int idx) {
        Node node = null;
        int lastIdx = size - 1;

        if (!isValidIdx(idx) || size == 0) {
            return node;
        }
    
        if (idx == 0) {
            // move head forward
            node = head;
        }
        else if (idx == lastIdx) {
            node = tail;
        }
        else {
            Node temp = head.next;

            for (int i = 1; i < lastIdx; i++) {
                if (i == idx) {
                    node = temp;
                    break;
                }
                temp = temp.next;
            }
        }
        return node;
    }  
}
