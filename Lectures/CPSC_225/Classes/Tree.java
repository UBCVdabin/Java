package Lectures.CPSC_225.Classes;

import Commons.Util;

public class Tree {
    public Node root;
    private int size;

    public Tree() {
        root = null;
        size = 0;
    }

    public Tree(int n) {
        size = 0;
        for (int i = 0; i < n; ) {
            int val = Util.RandInt(1, n);
            if (Add(val)) {
                i++;
            }
        }
    
    }

    public boolean Add(int val) {
        if (root == null) {
            root = new Node(val);
            size++;
            return true;
        }

        Node temp = root;
        Node parentNode = null;

        while (temp != null) {
            if (val == temp.item) {
                return false;         // distinguishable number
            }    
            
            parentNode = temp;
            
            if (val < temp.item) {
                temp = temp.L;
            }
            else {
                temp = temp.R;
            }
        }

        if (parentNode.item > val) {
            parentNode.L = new Node(val);
            parentNode.L.P = parentNode;
        }
        else {
            parentNode.R = new Node(val);
            parentNode.R.P = parentNode;
        }
        size++;

        UpdateBalanceFactors(this.root);
        TransformAVLTree();

        return true;
    }

    private void UpdateBalanceFactors(Node node) {
        if (node == null) {
            return;
        }
        else if (node.L == null && node.R == null) {
            // leaf node
            node.balanceFactor = 0;
            return;
        }
        node.balanceFactor = GetBalanceFactor(node);
        
        UpdateBalanceFactors(node.L);
        UpdateBalanceFactors(node.R);
    }

    private int GetBalanceFactor(Node node) {
        int leftHeight = 0;
        int rightHeight = 0;

        if (node.L != null) {
            // int curHeight = GetCurrentHeight(node.L);
            
            leftHeight = GetHeight(node.L);
        }

        if (node.R != null) {
            // int curHeight = GetCurrentHeight(node.R);
            //     leftHeight = GetHeight(node.R, curHeight);
            rightHeight = GetHeight(node.R);
        }

        return rightHeight - leftHeight;
    }

    public void InOrderDisplay() {
        InOrderDisplay(this.root, 0);
        System.out.println();
    }

    private void InOrderDisplay(Node node, int flag) {
        if (node == null) {
            return;
        }

        InOrderDisplay(node.L, flag);
        PrintNode(node, flag);
        InOrderDisplay(node.R, flag);
    }

    public void PostOrderDisplay() {
        PostOrderDisplay(this.root, 0);
        System.out.println();
    }

    private void PostOrderDisplay(Node node, int flag) {
        if (node == null) {
            return;
        }

        PostOrderDisplay(node.L, flag);
        PostOrderDisplay(node.R, flag);
        PrintNode(node, flag);
 
    }

    private void PrintNode(Node node, int flag) {
        switch (flag) {
            case 0: // normal
                System.out.print("[" + node.item + ", ");
                System.out.print(node.balanceFactor + "] ");
                break;
            case 1: // odd
                System.out.print((node.item % 2 != 0 ? node.item + " " : ""));
                break;
            default:
                break;
        }     
    }

    public void PreOrderDisplay() {
        PreOrderDisplay(this.root, 0);
        System.out.println();
    }

    private void PreOrderDisplay(Node node, int flag) {
        if (node == null) {
            return;
        }

        PrintNode(node, flag);
        PreOrderDisplay(node.L, flag);
        PreOrderDisplay(node.R, flag);
    }

    public void PrintOddValuesInOrder() {
        InOrderDisplay(this.root, 1);
        System.out.println();
    }

    public void PrintOddValuesInPreOrder() {
        PreOrderDisplay(this.root, 1);
        System.out.println();
    }

    public void PrintOddValuesInPostOrder() {
        PostOrderDisplay(this.root, 1);
        System.out.println();
    }

    public int CountOddValues() {
        return CountOddValues(this.root);
    }

    public int CountOddValues(Node node) {
        int cnt = 0;
        
        if (node == null) {
            return cnt;
        }

        else {
            int L = CountOddValues(node.L);
            int R = CountOddValues(node.R);
            
            if (node.item % 2 != 0) {
                cnt++;
            }
            
            return cnt + L + R;
        }
    }

    public int FindMinValue() {
        if (isEmpty()) {
            return -1;
        }
        return FindMinValue(this.root);     
    }

    public int FindMaxValue() {
        if (isEmpty()) {
            return -1;
        }
        return FindMaxValue(this.root);     
    }

    private int FindMaxValue(Node node) {    
        int max = node.item;
        if (node.R ==  null) {
            return max;
        }
        else {
            return FindMaxValue(node.R);
        }
    }

    private int FindMinValue(Node node) {    
        int min = node.item;
        if (node.L ==  null) {
            return min;
        }
        else {
            return FindMinValue(node.L);
        }
    }
    
    private Node FindMaxNode(Node node) {    
        if (node.R == null) {
            return node;
        }
        else {
            return FindMaxNode(node.R);
        }
    }

    private Node FindMinNode(Node node) {    
        if (node.L == null) {
            return node;
        }
        else {
            return FindMinNode(node.L);
        }
    }

    public int FindSumOfAllValues() {
        if (isEmpty()) {
            return 0;
        }
        return FindSumOfAllValues(this.root);     
    }

    public int FindSumOfAllValues(Node node) {    
        if (node == null) {
            return 0;
        }
        else {
            int sum = 0;
            sum += node.item;
            sum += FindSumOfAllValues(node.L);
            sum += FindSumOfAllValues(node.R);

            return sum;
        }
    }


    public void GetReduceValuesByAverage() {
        if (isEmpty()) {
            return;
        }

        double avg = FindAvgValue();
        Change(this.root, avg);
    }

    public void Change(double val) {
        if (isEmpty()) {
            return;
        }

        Change(this.root, val);   
    }


    public void Change(Node node, double val) {
        if (node == null) {
            return;
        }

        node.item -= val;
        Change(node.L, val);
        Change(node.R, val);        
    }

    public int getSize() {
        return size;
    }

    public double FindAvgValue() {
        if (isEmpty()) {
            return 0;
        }
        return (double)this.FindSumOfAllValues(this.root) / size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int GetHeight() {
        int height = 0;
        if (isEmpty()) {
            return height;
        }
        height = GetHeight(this.root);
        
        return height;
    }
    private int GetHeight(Node node) {
        if (node == null) {
            return 0;
        }
        else if (node.L == null && node.R == null) {
            return 0;
        }

        int lHeight = GetHeight(node.L) + 1; 
        int rHeight = GetHeight(node.R) + 1;

        return lHeight > rHeight ? lHeight : rHeight;
    }
    // private int GetHeight(Node node, int height) {
    //     if (node.L == null && node.R == null) {
    //         return height;
    //     }

    //     int lHeight = node.L != null ? GetHeight(node.L, height + 1) : height; 
    //     int rHeight = node.R != null ? GetHeight(node.R, height + 1) : height;

    //     return lHeight > rHeight ? lHeight : rHeight;
    // }
    public void BreadthFirstSearchDisplay() {
        Queue queue = this.BreadthFirstSearch();
        // deepest level
        int depth = GetHeight();
        int height = 0;
        // space
        String sCur = "";
        String sPrev = "";

        // initialize 
        for (int i = 0; i < Math.pow(2, depth - height); i++) {
            sCur += "   ";
        }
        System.out.print(sCur);
        // 2^n
         System.out.println(queue);
      
        while (!queue.IsEmpty()) {
            Node node = queue.DequeueNode();
            
            int item = node.item;

            if (height != node.height) {
                System.out.println();
                sPrev = sCur.substring(2);
                
                sCur = "";
              
                height = node.height;

                // initialize 
                for (int i = 0; i < Math.pow(2, depth - height); i++) {
                    sCur += "   ";
                }
                System.out.print(sCur);
            }
            System.out.print((item == -1 ? "  " : String.format("%-2d", item)) + sPrev); 
        }
        System.out.println();                   
    }

    public Queue BreadthFirstSearch() {
        if (isEmpty()) {
            return null;
        }

        Queue queue = new Queue();
        Queue temp = new Queue();
        
        int height = 0;
        int term, cnt = 0;
        int dummyCnt = 0;
        int[] dummyChNode = new int[0];
        root.height = height;
        
        term = (int)Math.pow(2, ++height);

        queue.Enqueue(root);
        temp.Enqueue(root);
        // 1 2 4 8
        while (!temp.IsEmpty()) {
            Node pNode = temp.DequeueNode();
            Node node;
            // assign node object
            if (cnt == term) {
                term = (int)Math.pow(2, ++height);
                
                dummyChNode = new int[(dummyChNode.length + dummyCnt) * 2];
                dummyCnt = 0;

                cnt = 0;
            }
            if (pNode.L != null) {
                // get Current height
                node = new Node(pNode.L.item);
                // get distance from a root node
                // height = this.GetDistance(pNode.L);
                node.height = height;

                temp.Enqueue(pNode.L);
            }
            else {
                // fake node
                node = new Node(-1);
                node.height = height;
                dummyCnt++;
            }
            queue.Enqueue(node);
            cnt++;

            // assign node object         
            if (pNode.R != null) {
                // get Current height
                node = new Node(pNode.R.item);
                // get distance from a root node

                // height = this.GetDistance(pNode.R);  
                node.height = height;     
                temp.Enqueue(pNode.R);
            }   
            else {
                // fake node
                node = new Node(-1);
                node.height = height;
                dummyCnt++;
            }
            queue.Enqueue(node);
            cnt++;
        }
        return queue;
    }

    private int GetDistance(Node node) {
        int height = -1;

        while (node != null) {
            height++;
            node = node.P;
        }

        return height;
    }

    private boolean isItemExists(int item) {
        boolean res = false;
        Node node = this.root; 

        while (node != null) {
            if (node.item == item){
                res = true;
                break;    
            }
            else if (node.item > item) {
                node = node.L;
            }
            else {
                node = node.R;
            }
        }
        return res;
    }

    public DoublyLinkedList FindPath(int item) {
        DoublyLinkedList res = new DoublyLinkedList();

        // check that the node exist.
        if (!isItemExists(item)) {
            return null;
        }

        Node node = this.root;

        while (node != null) {
            res.AddLast(node); 
            
            if (node.item ==item){
                break;    
            }
            else if (node.item > item) {
                node = node.L;
            }
            else {
                node = node.R;
            }         
        }

        if (res.size == 0) {
            res = null;
        }

        return res;
    } 

    public DoublyLinkedList FindPath(Node n) {
        DoublyLinkedList res = new DoublyLinkedList();

        if(!isItemExists(n.item)) {
            return null;
        }

        Node node = this.root;

        while (node != null) {
            res.AddLast(node); 
            
            if (node.item == n.item){
                break;    
            }
            else if (node.item > n.item) {
                node = node.L;
            }
            else {
                node = node.R;
            }
        }
        return res;
    } 

    public boolean Delete(int val) {
        if (isEmpty()) {
            return false;
        }
        return Delete(this.root, val);
    }

    private boolean Delete(Node cur, int val) {
        while (cur != null && cur.item != val) {
            if (val < cur.item) {
                cur = cur.L;
            }
            else {
                cur = cur.R;
            }
        }

        if (cur == null) {
            return false;
        }

        // leaf node
        if (cur.L == null && cur.R == null) {
            Node pNode = cur.P;

            // if current node is left side 
            if (pNode.L.item == cur.item) {
                pNode.L = null;
            }
            else {
                // right side
                pNode.R = null;
            }
            // clear
            cur.P = null;
            cur = null;
        }
        else if (cur.L == null) {
            // parent Node
            Node pNode = cur.P;

            // child Node
            Node chNode = cur.R;

            if (pNode.L.equals(cur)) {
                pNode.L = chNode;   
            }
            else {
                pNode.R = chNode;
            }

            // if chNode exists.
            if (chNode != null) {
                chNode.P = pNode;
            }
            
            // delete
            cur.P = null;
            cur.R = null;
        }
        // cur.R == null or if cur.R and cur.L exist
        else  {
            // Find Largest Node on the left side and then remove it
            Node LNodeRemove = this.FindMaxNode(cur.L);
            
            // Parent Node
            Node pNode = LNodeRemove.P;

            // child Node
            Node chNode = LNodeRemove.L;

            // Change value
            cur.item = LNodeRemove.item;
           
            // Add null or child Node address value
            pNode.R = chNode;               

            // if chNode exists.
            if (chNode != null) {
                chNode.P = pNode;
            }

            LNodeRemove.P = null;
            LNodeRemove.L = null;
            LNodeRemove = null;
        }
        // Success deleting
        return true;
    }




    public void RotateRRight() {
        // Rotate Root Tree to Right
        RotateRight(this.root);
    }

    // Rotate Root tree to left.
    public void RotateRLeft() {
        RotateLeft(this.root);
    }
    
    private boolean RotateRight(Node rNode) {
        // Rotate to right
        Node lNode = rNode.L;
        
        // cannot rotate to right
        if (lNode == null) { 
            return false;
        }

        // Right Child Node from Left Node
        Node lChNode = lNode.R;

        rNode.L = lChNode;

        if (lChNode != null) {
            lChNode.P = rNode;
        }

        lNode.P = rNode.P; // lNode.P can have null value or parent node 

        lNode.R = rNode;
        rNode.P = lNode;

        if (lNode.P == null) {
            this.root = lNode;
        }

        // Reset Height
        UpdateHeights(this.root, 0);

        // Reset balance factors
        UpdateBalanceFactors(this.root);

        return true;
    } 
    
    private void UpdateHeights(Node node, int height) {
        if (node == null) {
            return;
        }
        node.height = height;
        UpdateHeights(node.L, height + 1);
        UpdateHeights(node.R, height + 1);
    }

    private boolean RotateLeft(Node lNode) {
        // Rotate to left
        Node rNode = lNode.R;

        if (rNode == null) {
            // cannot rotate to left
            return false;
        }

        // Left Child Node from Right Node
        Node rChNode = rNode.L;

        lNode.R = rChNode;

        if (rChNode != null) {
            rChNode.P = lNode;
        }

        // Orginial Node is root node

        rNode.P = lNode.P; // lNode.P can have null value or parent node address
        
        rNode.L = lNode;
        lNode.P = rNode;

        if (rNode.P == null) {
            this.root = rNode;
        }

        // Reset Height
        UpdateHeights(this.root, 0);
        
        // Reset balance factors
        UpdateBalanceFactors(this.root);

        return true;
    } 

    private void LLImbalance(Node node) {
        this.RotateRight(node);
    }

    private void LRImbalance(Node node) {
        this.RotateLeft(node.L);
        this.RotateRight(node);
    }

    private void RRImbalance(Node node) {
        this.RotateLeft(node); 
    }

    private void RLImbalance(Node node) {
        this.RotateRight(node.R);
        this.RotateLeft(node);
    }

    private void TransformAVLTree() {
        Node node = this.root;
        int balFactor = node.balanceFactor;
         
        if (balFactor >= -1 && balFactor <= 1) {
            // already balanced
            return;
        }

        int childBalFactor;

        if (balFactor < -1) {
            // Require to rotate to left side
            // but, we need to check balance factor from a child node 
            childBalFactor = node.L.balanceFactor;

            if (childBalFactor > 0) {
                LRImbalance(node);
            }
            else {
                LLImbalance(node);
            }
        }
        else {
            // Require to rotate to right side
            // but, we need to check balance factor from a child node
            childBalFactor = node.R.balanceFactor; 

            if (childBalFactor < 0) {
                RLImbalance(node);
            }
            else {
                RRImbalance(node);
            }
        }
    }
}
