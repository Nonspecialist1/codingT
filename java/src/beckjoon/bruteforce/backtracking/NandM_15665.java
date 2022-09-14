package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NandM_15665 {
    static int[] arr, temps;
    static int N, R; // nPr
    static StringBuilder sb = new StringBuilder(); // 시간초과나므로 set 을 sb로 변경

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N];
        temps = new int[R];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        perm(0, 0);
        System.out.println(sb);
    }

    static void perm(int idx, int r){
        if(r == R){
            for(int i=0; i<R; i++){
                sb.append(temps[i] + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 중복되는 순열 방지
        for(int i=idx; i<N; i++){
            if(prev == arr[i]) continue;

            prev = arr[i];
            temps[r] = arr[i];
            perm(i, r+1);
        }
    }

}
