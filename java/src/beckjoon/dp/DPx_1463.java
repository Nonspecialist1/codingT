package beckjoon.dp;

import java.util.Scanner;

public class DPx_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int[] DP = new int[X+1];

        for(int i=2; i<=X; i++){
            DP[i] = DP[i-1] + 1;
            if(i % 3 == 0){ DP[i] = Math.min(DP[i/3] + 1, DP[i]); }
            if(i % 2 == 0) { DP[i] = Math.min(DP[i/2] + 1, DP[i]); }
        }

        System.out.print(DP[X]);
    }
}
