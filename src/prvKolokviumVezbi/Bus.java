package prvKolokviumVezbi;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bus {

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        br.close();

        // Vasiot kod tuka
        int max = 0;
        if(M!=0) max = N * 100 + (M - 1) * 100;
        else max = N * 100;
        int min = 0;
        if(M!=1 && M!=0) {
            if(M>N) {
                min =  N * (M / N * 100);
                if ((M % N) != 0) {
                    M = M - N*(M / N);
                    min += (M * 100);
                }
            }else min = N * 100 ;
        }else min = max;

        System.out.println(min);
        System.out.println(max);

    }

}
