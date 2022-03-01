package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongSequence_11053 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        int[] DP = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) nums[i] = Integer.parseInt(st.nextToken());
        DP[1] = nums[0];

        int cnt = 1;
        for(int i=1; i<N; i++){
            if(nums[i] > DP[cnt]) DP[++cnt] = nums[i];
        }
        System.out.print(cnt);
    }
}
