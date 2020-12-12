//package labs.Lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SumOfAbsoluteDifferences {

    static int solve(int numbers[], int N, int K) {
        // vasiot kod ovde
        // mozete da napisete i drugi funkcii dokolku vi se potrebni
        int[] max = new int[N];
        int[] maxSum = new int[K];
        int sum =0;
        for(int i =1;i<N;i++){
            max[i-1] = (Math.abs(numbers[i-1]-numbers[i]));
        }
        for(int i =0;i<max.length-1;i++){
            for(int j=i+1;j<max.length-1;j++){
                if(max[i] < max[j] && i<=2){
                    maxSum[i]=max[j];
                }else if(i<=2){
                    maxSum[i]=max[i];
                }
            }
        }
        while (K>0){
            sum+=maxSum[K-1];
            K--;
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int numbers[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (i=0;i<N;i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int res = solve(numbers, N, K);
        System.out.println(res);

        br.close();

    }

}