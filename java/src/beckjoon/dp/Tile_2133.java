package beckjoon.dp;

import java.util.Scanner;

public class Tile_2133 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];

        int answer = 0;
        if(N % 2 != 1) {
            DP[0] = 1;
            DP[2] = 3;

            for (int i=4; i<=N; i+=2) {
                DP[i] = DP[i-2] * DP[2];
                for (int j=i-4; j>=0; j-=2) {
                    DP[i] += DP[j] * 2;
                }
            }
            answer = DP[N];
        }
        System.out.print(answer);
    }
}
