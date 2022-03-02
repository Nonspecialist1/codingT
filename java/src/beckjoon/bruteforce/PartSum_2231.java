package beckjoon.bruteforce;

import java.util.Scanner;

public class PartSum_2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int ans = 1000000;
        int temp = 0;
        for(int i=1; i<N; i++){
            if(i < 10){ temp = i*2; }
            else {
                temp = i;
                String s = String.valueOf(i);
                for(int j=0; j<s.length(); j++){
                    temp += Integer.valueOf(String.valueOf(s.charAt(j)));
                }
            }
            if(N == temp && temp < ans){ ans = i; }
        }

        if(ans == 1000000) System.out.println(0);
        else System.out.println(ans);
    }
}
