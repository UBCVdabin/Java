package Classes;

public class MyQueue {
    private final int NUMBER_OF_ELEMENT = 8;
    private int[] elements;
    private int front;
    private int rear;
    private int cnt;

    public MyQueue() {
        elements = new int[NUMBER_OF_ELEMENT];
        front = -1;
        rear = -1;
    }
    public void enqueue(int v) {
        if (Full()) {
            System.out.println("The queue is already ouccpied...");
        }
        else if (Empty()) {
            rear = ++rear % NUMBER_OF_ELEMENT;
            elements[rear] = v;
            cnt++;

            front = rear;
        } 
        else {
            rear = ++rear % NUMBER_OF_ELEMENT;
            elements[rear] = v;
            cnt++;
        }    
    }

    public String dequeue() {
        String element = "";
        if (Empty()) {
            element = "The queue is already empty...";
        }
        else {
            element = Integer.toString(elements[front++ % NUMBER_OF_ELEMENT]);
            cnt--;
        }
        return element;
    }

    public boolean Empty() {
        return cnt == 0;
    }

    public boolean Full() {
        return cnt == elements.length;
    }

    public int getSize() {
        return cnt;
    }
}
