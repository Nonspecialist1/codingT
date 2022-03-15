package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutaion_1722 {
    static int N;
    static boolean[] visited;
    static int T;
    static int k;
    static int[] ans;
    static int[] temp;
    static int idx;
    static boolean flag;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        ans = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        if(T == 1){ idx = Integer.parseInt(st.nextToken()); }
        else if(T == 2)
        {
            temp = new int[N];
            for(int i=0; i<N; i++){ temp[i] = Integer.parseInt(st.nextToken()); }
        }

        sb = new StringBuilder();
        k = 1;
        flag = false;
        perm(0);

        System.out.println(sb);
    }

    static void perm(int r){
        if(r == N) {
            if(T == 1){
                if(idx == k) {
                    solve(k++);
                    flag = true;
                }
                else k++;
            }
            else if(!flag) { solve(k++); }
        }
        else
        {
            for(int i=1; i<=N; i++){
                if(!visited[i]){
                    ans[r] = i;
                    visited[i] = true;
                    perm(r+1);
                    visited[i] = false;
                }
                if(flag){
                    break;
                }
            }
        }
    }

    static void solve(int k){
        if(T == 1){
            for(int i : ans){ sb.append(i + " "); }
            return;
        }
        else if(T == 2){
            flag = true;

            for(int i=0; i<N; i++){
                if(temp[i] != ans[i]){ flag = false; break;}
            }
            if(flag){ sb.append(k); }
        }
    }

}
