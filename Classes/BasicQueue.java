package Classes;

public class BasicQueue {
    private int[] elements;
    private int size;

    public BasicQueue() {
        elements = new int[8];
    }

    public void enqueue(int v) {
        if (Full()) {
            int[] temp = new int[size * 2];

            for (int i = 0; i < size; i++) {
                temp[i] =elements[i];
            }
            temp[size++] = v; 
            elements = temp;
        }
        else {
            elements[size++] = v;
        }
    }
    public String dequeue() {
        String element = "";
        if (Empty()) {
            element = "The queue is already empty...";
        }
        else {
            element = Integer.toString(elements[0]);

            for (int i = 1; i < size; i++) {
                elements[i - 1] = elements[i];
            }
            size--;
        }
        return element;
    }

    public boolean Empty() {
        return size == 0;
    }

    public boolean Full() {
        return size == elements.length;
    }

    public int getSize() {
        return size;
    }
}