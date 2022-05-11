package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SUM_1912 {
    static int[] DP;
    static int[] NUMS;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.valueOf(br.readLine());
        DP = new int[N];
        NUMS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            NUMS[i] = Integer.valueOf(st.nextToken());
        }
        DP[0] = NUMS[0];

        int max = DP[0];
        for(int i=1; i<N; i++){
            DP[i] = Math.max(NUMS[i], DP[i-1]+NUMS[i]);
            if(DP[i] > max) max = DP[i];
        }

        System.out.println(max);
    }



}
