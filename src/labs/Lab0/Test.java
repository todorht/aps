package labs.Lab0;

import java.util.Scanner;


//вашиот код
class Patuvanje{
    private String name;
    private int price;

    public Patuvanje(){}

    public Patuvanje(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



    public int vratiVremeVoDenovi(){
        int denovi=0;
        try {
            PraznicnoPatuvanje p = (PraznicnoPatuvanje) this;
            if((p.getKrajM()-p.getPocM())==0){
                denovi = p.getKrajD()-p.getPocD();
            }else {
                denovi = p.getKrajD()+(30-p.getPocD());
            }
        } catch (Exception ignored) {
            GodishenOdmor go = (GodishenOdmor) this;
            denovi = go.getVreme();
        }
        return denovi;
    }
}

class PraznicnoPatuvanje extends Patuvanje{
    private final int pocD;
    private final int pocM;
    private final int krajD;
    private final int krajM;

    public PraznicnoPatuvanje(String name, int price, int pocD, int pocM, int krajD, int krajM) {
        super(name, price);
        this.pocD = pocD;
        this.pocM = pocM;
        this.krajD = krajD;
        this.krajM = krajM;
    }

    public int getPocM() {
        return pocM;
    }

    public int getKrajD() {
        return krajD;
    }

    public int getKrajM() {
        return krajM;
    }

    public int getPocD() { return pocD; }

    public void exception(){
        if(this.getKrajM()<this.getPocM()){
            System.out.println("Iskluchok");
        }
    }

}

class GodishenOdmor extends Patuvanje{
    private int vreme;

    public GodishenOdmor(String name, int price, int vreme) {
        super(name, price-1000);
        this.vreme = vreme;
    }

    public int getVreme() {
        return vreme;
    }
}

public class Test {

    public static int vratiMinCena(Patuvanje [] niza, int n, Patuvanje zaSporedba){
        int minCena=9999999;
        for(Patuvanje a: niza){
            if(a.vratiVremeVoDenovi()>=zaSporedba.vratiVremeVoDenovi()){
                if(minCena>a.getPrice()){
                    minCena=a.getPrice();
                }
            }
        }
        return minCena;
    }

    public static void main(String[] args) {


        int n;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();

        Patuvanje nizaPatuvanje[]=new Patuvanje[n];

        for (int i=0;i<n;i++){
            int tip=in.nextInt();
            if (tip==0){
                String ime=in.next();
                int cena =in.nextInt();
                int vreme=in.nextInt();
                nizaPatuvanje[i]=new GodishenOdmor(ime,cena,vreme);
            }
            else {
                String ime=in.next();
                int cena =in.nextInt();
                int pocD=in.nextInt();
                int pocM=in.nextInt();
                int krajD=in.nextInt();
                int krajM=in.nextInt();
                nizaPatuvanje[i]=new PraznicnoPatuvanje(ime,cena,pocD,pocM, krajD,krajM);

            }
        }



        //решение на барање 1
        //решение на барање 2
        int denovi = 0;
        for(Patuvanje p: nizaPatuvanje){
            try {
                PraznicnoPatuvanje pp = (PraznicnoPatuvanje) p;
                pp.exception();
                denovi+=pp.vratiVremeVoDenovi();
                if(pp.getPocM()==6||pp.getKrajM()==6){
                    System.out.print(pp.getName() + " ");
                }
            } catch (Exception ignored) {
                GodishenOdmor go = (GodishenOdmor) p;
                denovi+=go.vratiVremeVoDenovi();
            }
        }
        System.out.print("\n" + (double) denovi / n + '\n');


        //решение на барање 3
        GodishenOdmor odmor = new GodishenOdmor(in.next(), in.nextInt(), in.nextInt());
        //решение на барање 4
        System.out.println(vratiMinCena(nizaPatuvanje,n,odmor));


    }

}
