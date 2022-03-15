package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Combination_2407 {
    static int N;
    static int R;
    static BigInteger[][] DP = new BigInteger[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        pasKal(N, R);

        System.out.print(DP[N][R]);
    }

    static void pasKal(int n, int r){
        for(int i=1; i<=n; i++){
            for(int j=0; j<=i; j++){
                if(j == i || j == 0) DP[i][j] = BigInteger.ONE;
                else DP[i][j] = DP[i-1][j-1].add(DP[i-1][j]);
            }
        }
    }



}
