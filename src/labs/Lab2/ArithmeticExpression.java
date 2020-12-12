package labs.Lab2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ArithmeticExpression {

    // funkcija za presmetuvanje na izrazot pocnuvajki
    // od indeks l, zavrsuvajki vo indeks r
    static int presmetaj(char c[], int l, int r) {
        // Vasiot kod tuka
        int b1,b2;
            b1 = Integer.parseInt(String.valueOf(c[l+1]));
        System.out.println(b1);
            b2 =Integer.parseInt(String.valueOf(c[r-1]));
        System.out.println(b2);
            if(c[l+2]=='+'){
                return b1+b2;
            }else if(c[l+2]=='-'){
                return b1-b2;
            }else return 0;


    }

    public static void main(String[] args) throws Exception {
        int i,j,k;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();
        char exp[] = expression.toCharArray();

        int rez = presmetaj(exp, 0, exp.length-1);
        System.out.println(rez);

        br.close();

    }

}
