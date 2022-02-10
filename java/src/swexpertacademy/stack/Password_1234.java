package swexpertacademy.stack;

import java.io.IOException;
import java.util.Scanner;

public class Password_1234 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
           char[] s = new char[100];
           int top = -1;

           int n = sc.nextInt();
           char[] input = sc.next().toCharArray();
           s[++top] = input[0];

           for(int i=1; i<n; i++){
               if(top != -1 && s[top] == input[i]) top--;
               else s[++top] = input[i];
           }
           System.out.print("#" + T + " ");
           for(int i=0; i<=top; i++){
               System.out.print(s[i]);
           }
           System.out.println();
        }
        sc.close();
    }
}
