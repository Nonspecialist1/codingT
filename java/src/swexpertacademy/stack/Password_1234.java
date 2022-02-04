package swexpertacademy.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Password_1234 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            Stack<Character> st = new Stack<>();
            sc.nextInt();
            char[] arr = sc.next().toCharArray();
            st.push(arr[0]);
            for(int i=1; i<arr.length; i++){
                if(!st.isEmpty() && st.peek() == arr[i]){ st.pop(); }
                else { st.push(arr[i]); }
            }
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){ sb.append(st.pop()); }
            System.out.printf("#%d %s\n", T, sb.reverse());
        }
    }
}
