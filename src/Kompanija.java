import java.util.Scanner;

public class Kompanija{

    static class Zadaca{
        private String opis;
        private int br_casovi;
        private boolean status;

        public Zadaca() {
        }

        @Override
        public String toString() {
            return "Zadaca " +
                    "opis='" + opis + '\'' +
                    ", br_casovi=" + br_casovi +
                    ", status=" + status;
        }

        public String getOpis() {
            return opis;
        }

        public void setOpis(String opis) {
            this.opis = opis;
        }

        public int getBr_casovi() {
            return br_casovi;
        }

        public void setBr_casovi(int br_casovi) {
            this.br_casovi = br_casovi;
        }

        public boolean isStatus() {
            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }
    }

    static class Vraboten{
        private static double BOD = 50;
        private String ime;
        private String prezime;
        private double plata;
        private int staz;
        private int brBod;
        private Zadaca [] zadaci;
        private int brZadaci;

        public Vraboten(){
            zadaci = new Zadaca[10];
            brZadaci = 0;
        }

        @Override
        public String toString(){
            return ime + " " + prezime;
        }

        public void dodadiZadaca(Zadaca z){
            if(brZadaci == 10){
                System.out.println("Nemoze da se dodade zadaca");
            }else {
                zadaci[brZadaci+1] = z;
            }
        }

        public double procentZavrseni(){
            int br=0;
            for(int i = 0;i<brZadaci;i++){
                if(zadaci[i].isStatus()){
                    br++;
                }
            }
            return (double)br/brZadaci;
        }

        public int vkupnoCasovi(){
            int suma=0;
            for(int i =0;i<brZadaci;i++){
                suma+=zadaci[i].getBr_casovi();
            }
            return suma;
        }

        public Vraboten(String ime, String prezime, double plata, int staz, int brBod, int brZadaci) {
            this.ime = ime;
            this.prezime = prezime;
            this.staz = staz;
            this.brBod = brBod;
            this.brZadaci = brZadaci;
            this.plata = plata*BOD;
        }

        public static double getBOD() {
            return BOD;
        }

        public static void setBOD(double BOD) {
            Vraboten.BOD = BOD;
        }

        public String getIme() {
            return ime;
        }

        public void setIme(String ime) {
            this.ime = ime;
        }

        public String getPrezime() {
            return prezime;
        }

        public void setPrezime(String prezime) {
            this.prezime = prezime;
        }

        public double getPlata() {
            return plata;
        }

        public void setPlata(double plata) {
            this.plata = plata;
        }

        public int getStaz() {
            return staz;
        }

        public void setStaz(int staz) {
            this.staz = staz;
        }

        public int getBrBod() {
            return brBod;
        }

        public void setBrBod(int brBod) {
            this.brBod = brBod;
        }

        public Zadaca[] getZadaci() {
            return zadaci;
        }

        public void setZadaci(Zadaca[] zadaci) {
            this.zadaci = zadaci;
        }

        public int getBrZadaci() {
            return brZadaci;
        }

        public void setBrZadaci(int brZadaci) {
            this.brZadaci = brZadaci;
        }
    }
    
    //Klasata Kompanija
    private Vraboten[] vraboteni;

    public Kompanija(Vraboten [] vraboteni){
        this.vraboteni = vraboteni;
    }

    public Vraboten najangaziran(){
        int max = 0;
        int k = 0;
        for(int i=0;i<vraboteni.length;i++){
            if(vraboteni[i].vkupnoCasovi()>max){
                max=vraboteni[i].vkupnoCasovi();
                k=i;
            }
        }
        return vraboteni[k];
    }

    public void pecatiPoUspesnost(){
        boolean flag=true;
        while (flag){
            flag=false;
            for(int j=0;j<vraboteni.length-1;j++){
                if (vraboteni[j].procentZavrseni()<
                        vraboteni[j+1].procentZavrseni()){
                    Vraboten tmp = vraboteni[j];
                    vraboteni[j] = vraboteni[j+1];
                    vraboteni[j+1] = tmp;
                    flag = true;
                }
            }
        }
        for(int i = 0;i<vraboteni.length;i++){
            System.out.printf("Vraboten: " + vraboteni[i].getIme()+
                    " "+ vraboteni[i].getPrezime()+ " "+
                    "Uspesnost: %.2f\n",(vraboteni[i].procentZavrseni()*100));
        }
    }

    public void pecati(){
        for(Vraboten v:vraboteni){
            System.out.println(v);
        }
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        Vraboten [] pom = new Vraboten[n];

        for(int i =0;i<pom.length;i++){
            Vraboten v = new Vraboten();
            v.setIme(input.next());
            v.setPrezime(input.next());
            v.setStaz(input.nextInt());
            v.setBrBod(input.nextInt());
            pom[i] = v;

            int p = input.nextInt();
            for(int j = 0;j<p;j++){
                Zadaca z = new Zadaca();
                z.setBr_casovi(input.nextInt());
                z.setOpis(input.next());
                z.setStatus(input.hasNextBoolean());
                v.dodadiZadaca(z);
            }
        }
        Kompanija k = new Kompanija(pom);
        k.pecati();
        k.pecatiPoUspesnost();
        System.out.println("Najangaziran vraboten: " + k.najangaziran());
    }
}
