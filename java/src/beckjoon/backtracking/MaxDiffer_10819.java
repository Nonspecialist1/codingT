package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxDiffer_10819 {

    static int[] arr, temp;
    static boolean[] visited;
    static int N, Max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        perm(0);
        System.out.println(Max);
    }

    static void perm(int r){
        if(r == N){
            int sum = 0;
            for(int i=1; i<N; i++){
                sum += Math.abs(temp[i-1] - temp[i]);
            }
            if(sum > Max) Max = sum;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            temp[r] = arr[i];

            visited[i] = true;
            perm(r+1);
            visited[i] = false;
        }
    }
}
