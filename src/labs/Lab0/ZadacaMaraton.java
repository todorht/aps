package labs.Lab0;

import java.util.Scanner;

interface IMaraton{
    Atleticar najdobroVreme();
    int atleticariOd(String s);
}

class Atleticar{
    private String name;
    private String gender;
    private int age;
    private double time;
    private String country;

    public Atleticar(){}

    public Atleticar(String name, String gender, int age, double time, String country) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.time = time;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return   name + '\n' +
                 age + '\n' +
                country + '\n' +
                time ;
    }
}

class Maraton implements IMaraton{

    private String place;
    private int year;
    private Atleticar[] atleticars;

    public Maraton(){}

    public Maraton(String place, int year, Atleticar[] atleticars) {
        this.place = place;
        this.year = year;
        this.atleticars = atleticars;
    }

    @Override
    public Atleticar najdobroVreme() {
        double max = 20000.0;
        int atN = 0;
        for(int i =0;i<atleticars.length;i++){
            if(atleticars[i].getTime()<max){
                atN = i;
                max = atleticars[i].getTime();
            }
        }
        return atleticars[atN];
    }

    @Override
    public int atleticariOd(String s) {
        int count = 0;
        for(Atleticar a: atleticars){
            if(a.getCountry().equals(s)){
                count++;
            }
        }
        return count;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Atleticar[] getAtleticars() {
        return atleticars;
    }

    public void setAtleticars(Atleticar[] atleticars) {
        this.atleticars = atleticars;
    }


    @Override
    public String toString() {
        StringBuilder atleticarString = new StringBuilder();
        for(Atleticar a : atleticars) {
            atleticarString.append(a.toString());
            atleticarString.append("\n");
        }
        return  place + '\n' +
                 year + "\n" +
                 atleticarString ;
    }
}

public class ZadacaMaraton {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Atleticar[] atleticari = new Atleticar[n];

        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;

        input.nextLine();

        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Atleticar(ime,pol,vozrast,vreme,zemja);
        }

        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();

        Maraton m1 = new Maraton(mesto, godina, atleticari);
        System.out.print(m1.toString());

        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.najdobroVreme().toString() + '\n');
        System.out.println("Ima vkupno " + m1.atleticariOd(zemjaP) + " atleticar/i od " + zemjaP);
    }
}
