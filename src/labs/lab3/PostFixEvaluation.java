
package labs.lab3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;

class ArrayStack<E> {

    private E[] elements;
    private int depth;

    public ArrayStack(int maxDepth) {
        elements = (E[])new Object[maxDepth];
        depth=0;
    }

    public boolean isEmpty() {
        return (depth==0);
    }

    public E peek() {
        if(depth==0) throw new NoSuchElementException();
        return elements[depth-1];
    }

    public void clear() {
        for(int i =0;i<depth;i++)elements[i]=null;
        depth =0;
    }

    public void push(E x) {
        elements[depth++] = x;
    }

    public E pop() {
        if(depth==0) throw new NoSuchElementException();
        E topmost = elements[--depth];
        elements[depth] = null;
        return topmost;
    }
}

public class PostFixEvaluation {

    private static int calc(int num1, int num2, String operator){
        if(operator.equals("+")) return num1+num2;
        if(operator.equals("-")) return num2-num1;
        if(operator.equals("*")) return num1*num2;
        if(operator.equals("/") && num1!=0 && num2!=0){
            if(num1>=num2){
                return num1/num2;
            }else return num2/num1;
        }
        if(operator.equals("%")) return num1%num2;
        else return 0;
    }

    public static void fix(String exp){
        ArrayStack<Integer> stack = new ArrayStack<Integer>(exp.length());
        String[] c= exp.split(" ");
        for(int i=0;i<c.length;i++){
            if(!c[i].equals(" ") && Character.isDigit(c[i].charAt(0)) ) stack.push(Integer.parseInt(c[i]));
            else if(c[i].equals("+")  || c[i].equals("-")  || c[i].equals("*")  || c[i].equals("/")  || c[i].equals("%") )
                stack.push(calc(stack.pop(),stack.pop(),c[i]));
        }
        if(!stack.isEmpty()) System.out.println(stack.pop());
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String expression = br.readLine();

        fix(expression);

        br.close();

    }

}
