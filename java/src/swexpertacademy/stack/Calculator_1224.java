package swexpertacademy.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Calculator_1224 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            Stack<String> st = new Stack<>();
            sc.nextInt();
            StringBuilder sb = new StringBuilder();
            char[] arr = sc.next().toCharArray();
            for(int i=0; i<arr.length; i++){
                char c = arr[i];
                if(c == '('){ st.push(String.valueOf(c)); }
                else if(c == '*'){ st.push(String.valueOf(c)); }
                else if(c == '+'){
                    while(!st.isEmpty() && (st.peek().equals("*") || st.peek().equals("+") )){ sb.append(st.pop()); }
                    st.push(String.valueOf(c));
                }
                else if(c == ')'){
                    while(!st.isEmpty() && !(st.peek().equals("("))){ sb.append(st.pop()); }
                    st.pop();
                }
                else { sb.append(c); }
            }

            for(int i=0; i<sb.length(); i++){
                char c = sb.charAt(i);
                if(c == '*'){
                    String a = st.pop();
                    String b = st.pop();
                    int result =  Integer.valueOf(b) * Integer.valueOf(a);
                    st.push(String.valueOf(result));
                }
                else if(c == '+'){
                    String a = st.pop();
                    String b = st.pop();
                    int result =  Integer.valueOf(b) + Integer.valueOf(a);
                    st.push(String.valueOf(result));
                }
                else { st.push(String.valueOf(c)); }
            }
            System.out.printf("#%d %s\n", T, st.pop());
        }
    }
}
