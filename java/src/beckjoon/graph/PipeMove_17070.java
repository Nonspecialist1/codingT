package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PipeMove_17070 {

    static int N, Cnt = 0;
    static int[][] Arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(Arr[N-1][N-1] == 1){
            System.out.println(0);
            return;
        }

        DFS(0, 1, 0);

        System.out.println(Cnt);
    }

    static void DFS(int r, int c, int dir){
        if(r==N-1 && c==N-1){
            Cnt++;
            return;
        }

        if(dir == 0 && checkIdx(r, c+1)){ // 가로
            DFS(r, c+1, 0);
        }
        else if(dir == 1 && checkIdx(r+1, c)){ // 세로
            DFS(r+1, c, 1);
        }
        else if(dir == 2){
            if(checkIdx(r, c+1)) DFS(r, c+1, 0);
            if(checkIdx(r+1, c)) DFS(r+1, c, 1);
        }
        // 대각선
        if(checkIdx(r+1, c+1) && checkCross(r+1, c+1)){
            DFS(r+1, c+1, 2);
        }
    }

    static boolean checkIdx(int r, int c){ // 인덱스 체크
        if(r < 0 || r >= N || c < 0 || c >= N || Arr[r][c] == 1){
            return false;
        }
        return true;
    }

    static boolean checkCross(int r, int c){ // 대각 체크
        if(Arr[r-1][c] == 1 || Arr[r][c-1] == 1){
            return false;
        }
        return true;
    }

}
