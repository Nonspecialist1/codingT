package beckjoon.dp.sum123;

import java.util.Scanner;

public class SUM123_15990 {

    static long[][] DP = new long[100001][4];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        DP[1][1] = 1;
        DP[2][2] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;

        for(int i=4; i<=100000; i++){
            DP[i][1] = (DP[i-1][2] + DP[i-1][3]) % 1000000009;
            DP[i][2] = (DP[i-2][1] + DP[i-2][3]) % 1000000009;
            DP[i][3] = (DP[i-3][1] + DP[i-3][2]) % 1000000009;
        }

        StringBuilder sb =new StringBuilder();

        for(int i=0; i<T; i++){
            N = sc.nextInt();
            sb.append((DP[N][1] + DP[N][2] + DP[N][3]) % 1000000009 + "\n");
        }
        System.out.println(sb);
    }


}
