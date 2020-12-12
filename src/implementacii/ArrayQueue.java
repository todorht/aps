package implementacii;

import java.util.NoSuchElementException;

public class ArrayQueue<E>implements Queue<E> {

    E[] elements;
    int length,front,rear;

    public ArrayQueue(int maxlength) {
        elements = (E[]) new Object[maxlength];
        clear();
    }

    @Override
    public boolean isEmpty() {
        return (length == 0);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public E peek() {
        if(length>0) {
            return elements[front];
        }else throw new NoSuchElementException();
    }

    @Override
    public void clear() {
        length = 0;
        front= rear = 0;
    }

    @Override
    public void enqueue(E x) {
        if(length == elements.length) return;
        elements[rear++]=x;
        if(rear == elements.length) rear=0;
        length++;
    }

    @Override
    public E dequeue() {
        if(length>0){
            E frontmost = elements[front];
            elements[front++] = null;
            if(front == elements.length) front=0;
            length--;
            return frontmost;
        }else throw new NoSuchElementException();
    }
}
