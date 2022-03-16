package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongSequence_11053 {
    static int[] nums;
    static int[] temps;
    static int N;
    static int M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        temps = new int[N];

        for(int i=0; i<N; i++){
            nums[i] = i+1;
        }

        sb = new StringBuilder();
        perm(0);
        System.out.print(sb);
    }

    static void perm(int r){
        if(r == M){
            StringBuilder tempSb = new StringBuilder();
            tempSb.append(temps[0] + " ");
            boolean flag = true;

            for(int i=1; i<M; i++){
                if(temps[i] < temps[i-1]){
                    flag = false;
                    break;
                }
                else tempSb.append(temps[i] + " ");
            }
            if(flag) sb.append(tempSb + "\n");
            return;
        }

        for(int i=0; i<N; i++){
            temps[r] = nums[i];
            perm(r+1);
        }

    }
}
