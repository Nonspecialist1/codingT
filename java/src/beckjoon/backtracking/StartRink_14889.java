package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class StartRink_14889 {
    static int N, R, Min = Integer.MAX_VALUE;
    static boolean[] Visited;
    static int[] Arr;
    static int[][] S, Power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        R = N / 2;

        S = new int[N+1][N+1];
        Power = new int[N+1][N+1];
        Visited = new boolean[N + 1];
        Arr = new int[R];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N; i++){
            for(int j=i+1; j<=N; j++){
                Power[i][j] = S[i][j] + S[j][i]; // 능력치 표
            }
        }

        perm(1, 0);
        System.out.println(Min);
    }

    static void perm(int idx, int r){
        if(r == R) { // 4개의 수가 모두 만들어 졌을 때
            boolean[] visit = new boolean[N+1];
            int sum1 = 0;
            int sum2 = 0;

            for(int i=0; i<R; i++){
                visit[Arr[i]] = true;
                for(int j=i+1; j<R; j++){
                    visit[Arr[j]] = true;
                    sum1 += Power[Arr[i]][Arr[j]];
                }
            }

            for(int i=1; i<N; i++){
                if(visit[i]) continue;
                for(int j=i+1; j<=N; j++){
                    if(visit[j]) continue;
                    sum2 += Power[i][j];
                }
            }

            if(Min > Math.abs(sum1 -sum2)) Min = Math.abs(sum1 - sum2);
            return;
        }

        for(int i=idx; i<=N; i++){
            if(Visited[i]) continue;

            Arr[r] = i;

            Visited[i] = true;
            perm(i , r+1);
            Visited[i] = false;
        }
    }

}
