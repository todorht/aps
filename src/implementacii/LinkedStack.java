package implementacii;

import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private SLLNode<E> top;

    public LinkedStack() {
        top=null;
    }

    @Override
    public boolean isEmpty() {
        return (top == null);
    }

    @Override
    public E peek() {
        if(top==null) throw new NoSuchElementException();
        return top.element;
    }

    @Override
    public void clear() {
        top=null;
    }

    @Override
    public void push(E x) {
        top = new SLLNode<E>(x,top);
    }

    @Override
    public E pop() {
        if(top == null) throw new NoSuchElementException();
        E topElem = top.element;
        top = top.succ;
        return topElem;
    }
}
