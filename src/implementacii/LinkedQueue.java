package implementacii;

import implementacii.SLLNode;

import java.util.NoSuchElementException;

public class LinkedQueue<E> implements Queue<E> {

    SLLNode<E> front, rear;
    int length;

    public LinkedQueue(){
        clear();
    }

    @Override
    public boolean isEmpty() {
        return (length==0);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public E peek() {
        if(front==null) throw new NoSuchElementException();
        return front.element;
    }

    @Override
    public void clear() {
        front=rear=null;
        length=0;
    }

    @Override
    public void enqueue(E x) {
        SLLNode<E> latest = new SLLNode<E>(x,null);
        if(rear!=null){
            rear.succ = latest;
            rear = latest;
        }else front = rear = latest;
        length++;
    }

    @Override
    public E dequeue() {
        if(front!=null){
            E frontmost = front.element;
            front = front.succ;
            if (front == null)rear=null;
            length--;
            return frontmost;
        }else throw new NoSuchElementException();
    }
}
