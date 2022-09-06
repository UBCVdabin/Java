package Lectures.CPSC_225;

public class MyArrayList<E> implements Comparable<MyArrayList<E>>{
    private Object[] elements;
    private int currentIdx;
    public MyArrayList() {
        elements = null;
        currentIdx = -1;
    }

    public MyArrayList(int cnt) {
        elements = new Object[cnt];
        currentIdx = 0;
    }

    public void add(E element) {
        // If array is Null
        if (isNull(element)) {
            return;
        }

        if (++currentIdx < elements.length) {
            elements[currentIdx] = element;
        }
        else {
            Object[] temp;
            temp = new Object[elements.length + 1];

            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            temp[elements.length] = element;
            
            elements = temp;
        }
    }

    private boolean isNull(E element) {
        if (elements == null) {
            elements = new Object[1];
            elements[++currentIdx] = element;        
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(MyArrayList<E> o) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int size() {
        return elements.length;
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void remove(int index) {
        if (currentIdx <= 0) {
            elements = null;
            currentIdx = -1;

            return;
        }

        Object[] temp = new Object[currentIdx--];

        for (int i = 0; i < index; i++) {
            temp[i] = elements[i];
        }

        for (int i = index + 1; i < elements.length; i++) {
            temp[i - 1] = elements[i];
        }

        elements = temp;
    }

    public void add(int index, E element) {
        if(isNull(element)) {
            return;
        }
        if (index < elements.length) {
            elements[currentIdx] = element;
        }
        if (index <= currentIdx++) {
            //for 
            elements[index] = element;
        }
        else {
            Object[] temp;
            temp = new Object[elements.length + 1];

            for (int i = 0; i < elements.length; i++) {
                temp[i] = elements[i];
            }
            temp[elements.length] = element;
            
            elements = temp;
        }
    }

    public void RemoveElement(int x) {

    }
    public void RemoveIndex(int x) {

    }
    public void Clear() {
        elements = null;
    }
    
    public void Show() {
        for (int i = 0; i < elements.length; i++) {
            System.out.println((E)elements[i]);
        }
    }

    public boolean Contains(E value) {
        boolean isContain = false;
        for (int i = 0; i < elements.length; i++) {
            if (elements.equals(value)) {
                isContain = true;
            }
        }
        return isContain;
    }

    public void AddAll(int[] c) {

    }

    public void Add(int index, int element) {
        
    }
}
