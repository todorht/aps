package labs.lab3;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Gragjanin{
    String imePrezime;
    int lKarta;
    int pasos;
    int vozacka;

    public Gragjanin(String imePrezime, int lKarta, int pasos, int vozacka) {
        this.imePrezime = imePrezime;
        this.lKarta = lKarta;
        this.pasos = pasos;
        this.vozacka = vozacka;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public int getlKarta() {
        return lKarta;
    }

    public int getPasos() {
        return pasos;
    }

    public int getVozacka() {
        return vozacka;
    }

    public void setlKarta(int lKarta) {
        this.lKarta = lKarta;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public void setVozacka(int vozacka) {
        this.vozacka = vozacka;
    }
}

class ArrayQueue<E> {

    E[] elements;
    int length,front,rear;

    public ArrayQueue(int maxlength) {
        elements = (E[]) new Object[maxlength];
        clear();
    }


    public boolean isEmpty() {
        return (length == 0);
    }


    public int size() {
        return length;
    }


    public E peek() {
        if(length>0) {
            return elements[front];
        }else throw new NoSuchElementException();
    }


    public void clear() {
        length = 0;
        front= rear = 0;
    }


    public void enqueue(E x) {
        if(length == elements.length) return;
        elements[rear++]=x;
        if(rear == elements.length) rear=0;
        length++;
    }


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


public class MVR {

    public static void shalter(ArrayQueue<Gragjanin> lugje) {
        ArrayQueue<Gragjanin> pasos = new ArrayQueue<>(lugje.length);
        ArrayQueue<Gragjanin> vozacka = new ArrayQueue<>(lugje.length);
        ArrayQueue<Gragjanin> lkarta = new ArrayQueue<>(lugje.length);
        while (!lugje.isEmpty()){
            Gragjanin tmp = lugje.dequeue();
            if(tmp.getlKarta()==1) lkarta.enqueue(tmp);
            else if(tmp.getPasos()==1) pasos.enqueue(tmp);
            else if(tmp.getVozacka()==1) vozacka.enqueue(tmp);
        }
        while (!lkarta.isEmpty()) {
            Gragjanin tmp = lkarta.dequeue();
                if (tmp.getPasos() == 0 && tmp.getVozacka() == 0) {
                    System.out.println(tmp.getImePrezime());
                } else if (tmp.getPasos() == 1) pasos.enqueue(tmp);
                else vozacka.enqueue(tmp);
        }
        while (!pasos.isEmpty()) {
            Gragjanin tmp = pasos.dequeue();
                if (tmp.getVozacka()==0) {
                    System.out.println(tmp.getImePrezime());
                } else vozacka.enqueue(tmp);

        }
        while (!vozacka.isEmpty()) {
            Gragjanin tmp = vozacka.dequeue();
            System.out.println(tmp.getImePrezime());
        }

        }



    public static void main(String[] args) {

        Scanner br = new Scanner(System.in);

        int N = Integer.parseInt(br.nextLine());
        ArrayQueue<Gragjanin> lugje = new ArrayQueue<>(N);
        //List<Gragjanin> lugje = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            String imePrezime = br.nextLine();
            int lKarta = Integer.parseInt(br.nextLine());
            int pasos = Integer.parseInt(br.nextLine());
            int vozacka = Integer.parseInt(br.nextLine());
            Gragjanin covek = new Gragjanin(imePrezime, lKarta, pasos, vozacka);
            lugje.enqueue(covek);
        }

        shalter(lugje);
    }
}
