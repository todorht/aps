package labs.Lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Array<E> {


    public static int brojDoProsek(int[] niza){
        //Vashiot kod tuka...
        int sum = 0;
        for(int i = 0; i<niza.length;i++){
            sum+=niza[i];
        }
        double prosek = sum/niza.length;
        int tmp = getElement(niza,prosek);
        return niza[tmp];
    }

    private static int getElement(int[] niza, double prosek) {
        int min = 1000, tmp = 0;
        for(int i = 0; i<niza.length;i++){
            int razlika = Math.abs((int) (niza[i]-prosek));
            if(razlika<=min){
                if(razlika==min){
                    if(niza[tmp]>niza[i]){
                        tmp = i;
                    }
                }else {
                    min = razlika;
                    tmp = i;
                }
            }
        }
        return tmp;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);
        int[] niza = new int[N];
        //Vashiot kod tuka...
        for(int i = 0; i<niza.length;i++){
            s = stdin.readLine();
            niza[i] = Integer.parseInt(s);

        }


        System.out.println(brojDoProsek(niza));
    }



}
