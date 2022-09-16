package beckjoon.dp;

import java.util.Scanner;

public class SUM123 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[] DP = new long[1000001];
        DP[1] = 1;
        DP[2] = 2;
        DP[3] = 4;

        for(int j=4; j<=1000000; j++){
            DP[j] = (DP[j-1] + DP[j-2] + DP[j-3]) % 1000000009;
        }

        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            System.out.println(DP[n]);
        }
    }

}
