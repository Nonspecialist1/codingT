package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NandM_15654 {
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

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
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
