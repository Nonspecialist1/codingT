package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RGB_1149 {
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        DP = new int[N+1];
        int[][] RGB = new int[N+1][3];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = 1001;
            for(int j=0; j<3; j++){
                RGB[i][j] = Integer.valueOf(st.nextToken());
                if(RGB[i][j] < min) min = RGB[i][j];
            }

            if(i == 1) DP[i] = min;
        }

        for(int i=2; i<=N; i++){


            DP[i] = RGB[i-1][0] + RGB[i][1];
            DP[i] = Math.min(DP[i], RGB[i-1][0] + RGB[i][2]);
            DP[i] = Math.min(DP[i], RGB[i-1][1] + RGB[i][0]);
            DP[i] = Math.min(DP[i], RGB[i-1][1] + RGB[i][2]);
            DP[i] = Math.min(DP[i], RGB[i-1][2] + RGB[i][0]);
            DP[i] = Math.min(DP[i], RGB[i-1][2] + RGB[i][1]);

        }

        System.out.println(DP[N]);
    }



}
