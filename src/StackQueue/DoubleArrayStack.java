package StackQueue;

import java.util.NoSuchElementException;

public class DoubleArrayStack<E> {
    private E[] elements;
    private int depth1;
    private int depth2;

    public DoubleArrayStack(int maxDepth) {
        elements = (E[]) new Object[maxDepth];
        depth1 = 0;
        depth2 = 0;
    }

    public boolean isEmptyFirst(){
        return (depth1==0);
    }
    public boolean isEmptySecond(){
        return (depth2==0);
    }

    public boolean isFull(){
        return (depth1+depth2==elements.length);
    }

    public E peekFirst(){
        if(depth1==0) throw new NoSuchElementException();
        return elements[depth1-1];
    }
    public E peekSecond(){
        if(depth2==0) throw new NoSuchElementException();
        return elements[elements.length-depth2];
    }

    public void clearFirst(){
        for(int i =0;i<depth1;i++)elements[i] = null;
        depth1 = 0;
    }
    public void clearSecond(){
        for(int i =elements.length-1;i>=elements.length-depth2;i--)elements[i] = null;
        depth2 = 0;
    }

    public void pushFirst(E x){
        if(!this.isFull())
            elements[depth1++] = x;
        else System.out.println("Error, the array is full");
    }
    public void pushSecond(E x){
        if(!this.isFull())
            elements[elements.length - (++depth2)] = x;
        else System.out.println("Error, the array is full");
    }

    public E popFirst(){
        if(depth1==0) throw new NoSuchElementException();
        E topmost = elements[--depth1];
        elements[depth1]=null;
        return topmost;
    }
    public E popSecond(){
        if(depth2==0) throw new NoSuchElementException();
        E topmost = elements[elements.length-depth2];
        elements[elements.length-depth2]=null;
        depth2--;
        return topmost;
    }

}
