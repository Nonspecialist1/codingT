package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoDots_16929 {

    static int N, M;
    static char[][] Dots;
    static boolean[][] Visit;
    static int Y, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Dots = new char[N][M];
        Visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                Dots[i][j] = str.charAt(j);
            }
        }

        for(Y=0; Y<N; Y++){
            for(X=0; X<M; X++){
                if(Visit[Y][X]) continue;

                Visit[Y][X] = true;
                DFS(Y, X, 1); // 0,0 부터 DFS 시작
            }
        }

        System.out.println("No");
    }

    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static void DFS(int y, int x, int cnt){

        for(int d=0; d<4; d++){
            int newY = y + dy[d];
            int newX = x + dx[d];

            if(!checkWall(newY, newX) && !Visit[newY][newX] && Dots[y][x] == Dots[newY][newX]){
                Visit[newY][newX] = true;
                DFS(newY, newX, cnt+1);
                Visit[newY][newX] = false;
            }

            if(cnt > 3 && newY == Y && newX == X){ // 싸이클 완성된 경우
                System.out.println("Yes");
                System.exit(0);
            }
        }
    }

    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= M) return true;
        return false;
    }

}
