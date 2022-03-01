package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stair_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final long NUM = 1000000000;
        int N = Integer.parseInt(br.readLine());
        long[][] DP = new long[N+1][10];

        for(int i=1; i<10; i++) DP[1][i] = 1;

        for(int i=2; i<=N; i++){
            for(int j=0; j<10; j++){
                if(j == 0){ DP[i][j] = DP[i-1][1] % NUM; }
                else if (j == 9){ DP[i][j] = DP[i-1][8] % NUM; }
                else { DP[i][j] = (DP[i-1][j-1] + DP[i-1][j+1]) % NUM; }
            }
        }

        long ans = 0;
        for(int i=0; i<10; i++) ans += DP[N][i];

        System.out.println(ans % NUM);
    }
}
