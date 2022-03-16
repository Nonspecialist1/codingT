package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SubSet_1182 {
    static int[] arr;
    static int N;
    static int SUM;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        SUM = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        cnt = 0;
        powerSet(1, 0);
        powerSet(1, arr[0]);

        if(SUM == 0) cnt--;
        System.out.println(cnt);
    }

    static void powerSet(int idx, int sum){
        if(idx >= N){
            if(sum == SUM) cnt++;
            return;
        }

        powerSet(idx+1, sum);
        powerSet(idx+1, sum + arr[idx]);
    }

}
