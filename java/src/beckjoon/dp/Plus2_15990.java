package beckjoon.dp;

import java.util.Scanner;

public class Plus2_15990 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] DP = new int[11];
        DP[1] = 1;
        DP[2] = 1;
        DP[3] = 3;

        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++){
            int n = sc.nextInt();
            if(n > 3){
                for(int i=4; i<=n; i++){
                    DP[i] = DP[i-1] + DP[i-2] + DP[i-3];
                }
            }
            System.out.println(DP[n] % 1000000009);
        }
    }
}
