package prvKolokviumVezbi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

import java.util.NoSuchElementException;

interface Queue<E> {
    public boolean isEmpty();
    public int size ();
    public E peek ();
    public void clear ();
    public void enqueue(E x);
    public E dequeue();
}

interface Stack<E> {

    public boolean isEmpty();
    public E peek ();
    public void clear ();
    public void push (E x);
    public E pop ();
}

class SLLNode<E> {

    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E element, SLLNode<E> succ) {
        this.element = element;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class LinkedStack<E> implements Stack<E> {

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


class LinkedQueue<E> implements Queue<E> {

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

public class card_trick {
    public static int count(int N){
        // Vasiot kod tuka
        Queue<Integer> cards = new LinkedQueue<>();
        Stack<Integer> shuffle = new LinkedStack<>();

        for (int i =1;i<=51;i++){
            cards.enqueue(i);
        }

        int brojac = 0;
        while(cards.peek()!=N){

            for(int i =0;i<7;i++){
                shuffle.push(cards.dequeue());
            }

            while(!shuffle.isEmpty()){
                cards.enqueue(shuffle.pop());
                cards.enqueue(cards.dequeue());
            }

            brojac++;
        }
        return brojac;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        System.out.println(count(Integer.parseInt(br.readLine())));
    }

}
