package prvKolokviumVezbi;

import java.util.Scanner;

import java.util.Iterator;
import java.util.NoSuchElementException;

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


class SLL<E>{
    private SLLNode<E> first;

    public SLL() {
        this.first = null;
    }

    public void deleteList(){ first=null; }

    public int length(){
        int rez;
        if(first!=null){
            SLLNode<E> tmp = first;
            rez = 1;
            while (tmp.succ!=null){
                tmp = tmp.succ;
                rez++;
            }
            return rez;
        }else return 0;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o){
        SLLNode<E> ins = new SLLNode<>(o,first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node){
        if(node!=null){
            SLLNode<E> ins = new SLLNode<E>(o,node.succ);
            node.succ = ins;
        }else {
            System.out.println("Jazolot e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before){
        if(first!=null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            while (tmp.succ != before)
                tmp = tmp.succ;
            if(tmp.succ == before){
                SLLNode<E> ins = new SLLNode<E>(o,before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoti vo listata");
            }
        }else{
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o){
        if(first!=null){
            SLLNode<E> tmp = first;
            while (tmp.succ!=null) tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o,null);
            tmp.succ = ins;
        }else insertFirst(o);
    }

    public E deleteFirst(){
        if(first!=null){
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        }else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node){
        if(first!=null){
            SLLNode<E> tmp = first;
            if(first == node){
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ!=null)
                tmp = tmp.succ;
            if(tmp.succ==node){
                tmp.succ = tmp.succ.succ;
                return node.element;
            }else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        }else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public SLLNode<E> getFirst(){ return first; }

    public Iterator<E> iterator () {
        // Return an iterator that visits all elements of this list, in left-to-right order.
        return new LRIterator<E>();
    }


    // //////////Inner class ////////////

    private class LRIterator<E> implements Iterator<E> {

        private SLLNode<E> place, curr;

        private LRIterator() {
            place = (SLLNode<E>) first;
            curr = null;
        }

        public boolean hasNext() {
            return (place != null);
        }

        public E next() {
            if (place == null)
                throw new NoSuchElementException();
            E nextElem = place.element;
            curr = place;
            place = place.succ;
            return nextElem;
        }

        public void remove() {
            //Not implemented
        }
    }

    public void mirror(){
        if (first != null) {
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while(tmp != null){
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }

    }

    public void merge (SLL<E> in){
        if (first != null){
            SLLNode<E> tmp= first;
            while(tmp.succ!= null)
                tmp= tmp.succ;
            tmp.succ= in.getFirst();
        }else{
            first = in.getFirst();
        }
    }

}

class PalindromeSLL {

    public static int isItPalindrome(SLL<Integer> list){
        //Vashiot kod tuka...
        SLL<Integer> mirrorList = new SLL<>();
        SLLNode<Integer> tmp1 = list.getFirst();
        while (tmp1 != null){
            mirrorList.insertLast(tmp1.element);
            tmp1 = tmp1.succ;
        }

        mirrorList.mirror();
        SLLNode<Integer> tmp2 = mirrorList.getFirst();
        tmp1 = list.getFirst();
        while (tmp1 != null && tmp2 != null) {
            if (!tmp1.element.equals(tmp2.element)) return -1;
            tmp1 = tmp1.succ;
            tmp2 = tmp2.succ;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isItPalindrome(list));
    }

}