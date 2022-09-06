package Classes;

public class StackOfIntegers {
    private int[] arr = null;
    private int size;

    public void push(int number) {
        int[] temp = new int[++size];
        
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
        }
        temp[size - 1] = number;
        arr = temp;
    }

    public boolean empty() {
        return size == 0 ? true : false;
    }

    public String pop() {
        String num = "";
        if (size > 0) {
            int[] temp = new int[--size];
        
            num = Integer.toString(arr[size]);
            for (int i = 0; i < size; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        return num;
    }

    public int getSize() {
        return size;
    }
    
}
