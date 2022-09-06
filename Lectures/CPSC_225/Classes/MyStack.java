package Lectures.CPSC_225.Classes;

import java.util.ArrayList;

public class MyStack<E> {
    private ArrayList<E> contents;
    private int top;

    public MyStack() {
        contents = new ArrayList<>();
        top = -1;
    }

    public void Push(E item) {
        // System.out.println(item.getClass().getSimpleName()); Double
        
        contents.add(item);
        top++;
    }

    public E Pop() {
        if (IsEmpty()) {
            return null;
        }   
        return contents.remove(top--);
    }

    public E GetTopItem() {
        if (IsEmpty()) {
            System.out.println("Stack is empty, nothing to get");
            return null;
        }   
        return contents.get(top);
    }

    private boolean IsEmpty() {
        if (top == - 1) 
            return true;
        else
            return false;
    }
}
