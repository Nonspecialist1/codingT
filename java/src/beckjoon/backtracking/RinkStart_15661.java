package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RinkStart_15661 {
    static int N, Min = Integer.MAX_VALUE;
    static boolean[] Visited;
    static int[][] S, Power;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N+1][N+1];
        Power = new int[N+1][N+1];
        Visited = new boolean[N + 1];

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

        powerSet(1);
        System.out.println(Min);
    }

    static void powerSet(int r){
        if(r == N+1) { // 부분집합이 완성된 경우
            if(isPossible()){
                int sum1 = 0;
                int sum2 = 0;

                for(int i=1; i<=N; i++){
                    if(!Visited[i]) continue;
                    for(int j=i+1; j<=N; j++){
                        if(!Visited[j]) continue;
                        sum1 += Power[i][j];
                    }
                }

                for(int i=1; i<=N; i++){
                    if(Visited[i]) continue;
                    for(int j=i+1; j<=N; j++){
                        if(Visited[j]) continue;
                        sum2 += Power[i][j];
                    }
                }

                if(Min > Math.abs(sum1 -sum2)) Min = Math.abs(sum1 - sum2);
            }
            if(Min == 0){
                System.out.println(Min);
                System.exit(0);
            }
            return;
        }

        Visited[r] = false;
        powerSet(r+1);
        Visited[r] = true;
        powerSet(r+1);
    }

    private static boolean isPossible() {
        int cnt = 0;
        for(int i=1; i<N; i++){
            if(Visited[i]) cnt++;
        }
        return cnt != 0 && cnt != N;
    }

}
