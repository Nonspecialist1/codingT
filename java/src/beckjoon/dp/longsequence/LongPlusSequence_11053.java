package beckjoon.dp.longsequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongPlusSequence_11053 {
    static int[] NUMS;
    static int[] DP;
    static int N;
    static int MAX_LEN = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        NUMS = new int[N];
        DP = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){ // 수열 채우기
            NUMS[i] = Integer.valueOf(st.nextToken());
        }
        // DP 채우기
        for(int i=0; i<N; i++){
            DP[i] = 1;

            for(int j=0; j<i; j++){
                if(NUMS[j] < NUMS[i] && DP[j] >= DP[i]){
                    DP[i]++;
                }
            }

            if(DP[i] > MAX_LEN) MAX_LEN = DP[i];
        }

        System.out.println(MAX_LEN);
    }

}
