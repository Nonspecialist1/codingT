package beckjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class BackCal_1935 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Double> st = new Stack<>();

        int N = sc.nextInt();
        int[] value = new int[N];

        String str = sc.next();
        char[] arr = str.toCharArray();

        for(int i=0; i<N; i++){ value[i] = sc.nextInt(); }

        for(int i=0; i<arr.length; i++){
            char c = arr[i];
            double val = 0.0;

            if(c > 64){
                int idx = c;
                st.push((double)value[idx-65]);
            }
            else {
                double a = st.pop();
                double b = st.pop();

                switch (c){
                    case '*': val = b * a; break;
                    case '/': val = b / a; break;
                    case '+': val = b + a; break;
                    case '-': val = b - a; break;
                }
                st.push(val);
            }
        }
        System.out.printf("%.2f", st.peek());
    }
}


