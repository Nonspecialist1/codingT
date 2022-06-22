package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TSP2_10971 {

    static int[][] City;
    //static int[] temp;
    static boolean[] visited;
    static int N, Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        City = new int[N][N];
        // temp = new int[N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                City[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // perm(0);
        TPS(0, 0, 0);
        System.out.println(Min);
    }

    private static void TPS(int cost, int curPos, int cnt) {
        if(cost >= Min) return;
        if(cnt == N-1){ // 마지막 도시 방문일 때
            if(City[curPos][0] == 0) return;
            Min = Math.min(Min, cost + City[curPos][0]);
            return;
        }

        for(int i=1; i<N; i++){
            if(visited[i]) continue;
            if(City[curPos][i] == 0) continue;

            visited[i] = true;
            TPS(cost+City[curPos][i], i, cnt+1);
            visited[i] = false;
        }
    }


//    static void perm(int r){
//        if(r == N){
//            Long sum = 0L;
//            for(int i=0; i<N; i++){
//                if(sum > Min) return;
//
//                if(i == N-1){
//                    if(City[temp[i]][temp[0]] == 0) return;
//                    sum += City[temp[i]][temp[0]];
//                }
//                else {
//                    if(City[temp[i]][temp[i+1]] == 0) return;
//                    sum += City[temp[i]][temp[i+1]];
//                }
//            }
//            if(sum < Min) Min = sum;
//            return;
//        }
//
//        for(int i=0; i<N; i++){
//            if(visited[i]) continue;
//            temp[r] = i;
//
//            visited[i] = true;
//            perm(r+1);
//            visited[i] = false;
//        }
//    }
}
