package beckjoon.dp;

import java.util.Scanner;

public class Stair_10844 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] DP = new long[N+1];

        DP[1] = 9;
        for(int i=2; i<=N; i++){
            DP[i] = ((DP[i-1]*2) - (i-1)) % 1000000000;
        }

        System.out.println(DP[N] % 1000000000);
    }
}
