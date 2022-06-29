package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PieceOfPaper_14391 {

    static int N, M, Max = Integer.MIN_VALUE;
    static int[][] Paper;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Paper = new int[N][M];
        Visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                Paper[i][j] = str.charAt(j) - '0';
            }
        }
        dfs(0, 0);

        System.out.println(Max);
    }

    private static void dfs(int y, int x) {
        if(y >= N){
            calRowCol();
            return;
        }

        if(x >= M){
            dfs(y+1, 0);
            return;
        }

        Visit[y][x] = true; // 세로 마스킹 1
        dfs(y, x+1);

        Visit[y][x] = false; // 가로 마스킹 0
        dfs(y, x+1);
    }

    // 행, 열 계산
    private static void calRowCol() {
        int sum = 0;

        for(int i=0; i<N; i++){
            int temp = 0;
            for(int j=0; j<M; j++){
                if(!Visit[i][j]){ // 가로 칸이면
                    temp *= 10;
                    temp += Paper[i][j];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        for(int i=0; i<M; i++){
            int temp = 0;
            for(int j=0; j<N; j++){
                if(Visit[j][i]){ // 세로 칸이면
                    temp *= 10;
                    temp += Paper[j][i];
                } else {
                    sum += temp;
                    temp = 0;
                }
            }
            sum += temp;
        }

        Max = Math.max(sum, Max);
    }
}
