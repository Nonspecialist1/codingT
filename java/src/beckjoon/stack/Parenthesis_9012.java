package beckjoon.stack;

import java.util.Scanner;

public class Parenthesis_9012 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            String ans = "NO";
            String[] stack = new String[50];
            int top = -1;

            String[] str = sc.next().split("");

            for(int j=0; j<str.length; j++){
                String s = str[j];
                if("(".equals(s) && top >= -1){ stack[++top] = s; }
                else { top--; }
            }
            if(top == -1) ans = "YES";
            System.out.println(ans);
        }
    }

}
