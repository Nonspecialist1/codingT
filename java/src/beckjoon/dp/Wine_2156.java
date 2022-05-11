package beckjoon.dp;

import java.util.Scanner;

public class Wine_2156 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N];
        int[] Wine = new int[N];

        for(int i=0; i<N; i++){
            Wine[i] = sc.nextInt();
        }
        DP[0] = Wine[0];
        int max = DP[0];
        if(N > 1) {
            DP[1] = DP[0] + Wine[1];
            max = DP[1];
        }
        // 연속 여부
        if(N > 2){
            DP[2] = Math.max(DP[0] + Wine[2], DP[1]);
            DP[2] = Math.max(DP[2], Wine[2] + Wine[1]);
            max = DP[2];
        }

        for(int i=3; i<N; i++){
            DP[i] = Math.max(DP[i-1], DP[i-2] + Wine[i]);
            DP[i] = Math.max(DP[i], DP[i-3] + Wine[i-1] + Wine[i]);

            if(DP[i] > max) max = DP[i];
        }

        System.out.println(max);
    }
}
