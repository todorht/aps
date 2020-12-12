package labs.Lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {

    static int najdiNajdolgaCikCak(int a[]) {
        // Vasiot kod tuka
        int count = 1;
        int maxCount = 0;
        for (int i = 0; i < a.length-1; i++) {
            if (a[i] > 0) {
                if (a[i + 1] < 0) {
                    count++;
                } else {
                    if(count>maxCount) maxCount = count;
                    count=1;
                }
            } else if (a[i] < 0) {
                if (a[i + 1] > 0) {
                    count++;
                } else{
                    if(count>maxCount) maxCount = count;
                    count=1;
                }
            }

        }
        if(maxCount==0 || maxCount<count){
            return count;
        }else return maxCount;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();

    }

}
