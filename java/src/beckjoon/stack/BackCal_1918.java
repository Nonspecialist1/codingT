package beckjoon.stack;

import java.util.Scanner;
import java.util.Stack;

public class BackCal_1918 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        String str = sc.next();
        char[] arr = str.toCharArray();

        for(int i=0; i<arr.length; i++){
            char c = arr[i];

            if(c > 64){ sb.append(c); }
            else
            {
                switch (c){
                    case '*':
                    case '/':
                        if(!st.isEmpty()) {
                            while(!st.isEmpty() && (st.peek() == '*' || st.peek() == '/')){ sb.append(st.pop()); }
                        }
                        st.push(c); break;
                    case '+':
                    case '-':
                        if(!st.isEmpty()) {
                            while(!st.isEmpty() && st.peek() != '('){ sb.append(st.pop()); }
                        }
                        st.push(c); break;
                    case ')':
                        while(!st.isEmpty() && st.peek() != '('){ sb.append(st.pop()); }
                        st.pop(); break;
                    case '(': st.push(c); break;
                }
            }
        }
        while(!st.isEmpty()){ sb.append(st.pop()); }

        System.out.println(sb);
    }
}


