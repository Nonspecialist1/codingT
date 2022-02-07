package swexpertacademy.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class bracket_1218 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            Stack<Character> st = new Stack<>();
            int caseNum = sc.nextInt();
            String str = sc.next();
            char[] arr = str.toCharArray();
            int ans = 1;

            for(int i=0; i<caseNum; i++){
                if(arr[i] == '(' || arr[i] == '{' || arr[i] == '[' || arr[i] == '<'){ st.push(arr[i]); }
                else{
                    char c = st.pop();
                    if(c == '('){ c = ')'; }
                    if(c == '{'){ c = '}'; }
                    if(c == '['){ c = ']'; }
                    if(c == '<'){ c = '>'; }
                    if(c != arr[i]){ ans = 0; break; }
                }
            }
            if(!st.isEmpty()){ ans = 0; }

            System.out.printf("#%d %d\n", T, ans);
        }
    }

}
