package beckjoon.dp.sum123;

import java.util.Scanner;

public class SUM123_15989 {

    static int[][] DP = new int[10001][4];
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        DP[1][1] = 1;
        DP[2][1] = 1;
        DP[2][2] = 1;
        DP[3][1] = 1;
        DP[3][2] = 1;
        DP[3][3] = 1;

        for(int i=4; i<=10000; i++){
            DP[i][1] = DP[i-1][1];
            DP[i][2] = DP[i-2][1] + DP[i-2][2];
            DP[i][3] = DP[i-3][1] + DP[i-3][2] + DP[i-3][3];
        }

        for(int i=0; i<T; i++){
            N = sc.nextInt();
            System.out.println(DP[N][1] + DP[N][2] + DP[N][3]);
        }
    }


}
