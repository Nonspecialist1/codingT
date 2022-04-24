package beckjoon.dp;

import java.util.Scanner;

public class Binary_2193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] DP = new long[91];
        DP[1] = 1;
        DP[2] = 1;

        for(int i=3; i<91; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }

        System.out.println(DP[N]);
    }
}
