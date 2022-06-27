package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NMandK_18290 {
    static boolean[][] Visit;
    static int[][] Arr;
    static int N, M, K, Max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Arr = new int[N][M];
        Visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, 0, 0);
        System.out.println(Max);
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void solve(int y, int x, int r, int sum){
        if(r == K){ // 개수가 채워졌을 때
            Max = Math.max(sum, Max);
            return;
        }

        for(int i=y; i<N; i++){
            for(int j= (y == i ? r : 0); j<M; j++) {
                if(Visit[i][j]) continue;

                boolean flag = true;
                for(int d=0; d<4; d++){
                    int newY = i + dy[d];
                    int newX = j + dx[d];

                    if(!checkWall(newY, newX) && Visit[newY][newX]){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    Visit[i][j] = true;
                    solve(i, j, r+1, sum + Arr[i][j]);
                    Visit[i][j] = false;
                }
            }
        }

    }


    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= M) return true;
        return false;
    }

}
