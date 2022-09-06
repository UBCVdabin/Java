package Lab.CPSC_225;


public class Wk5Lab_Dabin_Im_10122964 {
    public static void main(String[] args) {

    //    Node node1 = new Node(123);

    //    Node node2 = new Node(45);

    //    Node node3 = new Node(6789);

    //    node1.next = node2;
    //    node2.next = node3;

    //    Node head = node1;

    //    Node temp = head;

    //    while(temp != null){
    //         System.out.println(temp.item);

    //         temp = temp.next;
    //    }  
    
        LinkedList ll = new LinkedList(5);

        //ll.Show();
        ll.Add(3, 100);

        ll.Add(1, 200);

        //ll.Show();

        ll.Add(0, 500);

        //ll.Show();

        ll.Add(7, 1000);

        ll.Add(-1, 1234);
        ll.Add(9, 4567);
      
        ll.Show();
        ll.SelectionSort();
        // ll.BubbleSortSimple();
        ll.Show();

        LinkedList lls = new LinkedList(4);
        lls.Show();
        ll.MergeSort(lls).Show();
    }
}
