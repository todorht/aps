package prvKolokviumVezbi;

import java.util.Scanner;


public class LDS {


    private static int najdolgaOpagackaSekvenca(int[] a) {

        // Vasiot kod tuka
        int maxCount = 1, maxCount1 = 1, count=1,min;
        for(int i =0;i<a.length-1;i++){
               min = i;
               for (int j = i+1;j<a.length-1;j++){
                    if(a[j]<a[min]){
                        maxCount++;
                    }else maxCount=1;
               }
        }

        return maxCount;

    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        int n = stdin.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = stdin.nextInt();
        }
        System.out.println(najdolgaOpagackaSekvenca(a));
    }


}
