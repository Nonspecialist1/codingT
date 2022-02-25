package beckjoon.dp;

import java.util.Scanner;

public class Card_11052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];
        int[] pack = new int[N+1];

        for(int i=1; i<=N; i++){ pack[i] = sc.nextInt(); }

        for(int i=1; i<=N; i++){
            DP[i] = pack[i];
            for(int j=1; j<=i; j++){
                DP[i] = Math.min(DP[i], pack[j] + DP[i-j]);
            }
        }
        System.out.println(DP[N]);
    }
}
