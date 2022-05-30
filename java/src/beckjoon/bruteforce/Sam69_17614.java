package beckjoon.bruteforce;

import java.util.Scanner;

public class Sam69_17614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 0;

        for(int i=1; i<=N; i++){
            String str = String.valueOf(i);

            for(int j=0; j<str.length(); j++){
                if(str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') ans++;
            }
        }

        System.out.println(ans);
    }
}
