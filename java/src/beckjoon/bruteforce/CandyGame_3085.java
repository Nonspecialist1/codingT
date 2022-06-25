package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame_3085 {

    static int N, Max = 0;
    static char[][] Candy;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Candy = new char[N][N];
        Visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                Candy[i][j] = str.charAt(j);
            }
        }
        // 행검사
        checkRow();
        // 열검사
        if(Max != N) checkCol();
        // 가장 긴 공통행렬 찾기
        if(Max != N) solve();
        if(Max != N) System.out.println(Max);
    }
    // 이동 방향
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void solve(){
        // 0,0 부터 시작
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Visit[i][j] = true;
                for(int d=0; d<4; d++){
                    int newY = i + dy[d];
                    int newX = j + dx[d];
                    if(!checkWall(newY, newX) && !Visit[newY][newX] && Candy[i][j] != Candy[newY][newX]){
                        swap(i, j, newY, newX);
                        checkRow();
                        if(Max == N) return;
                        checkCol();
                        if(Max == N) return;
                        swap(i, j, newY, newX);
                    }
                }
            }
        }
    }
    // 위치 교환
    private static void swap(int i, int j, int newY, int newX) {
        char c = Candy[i][j];
        Candy[i][j] = Candy[newY][newX];
        Candy[newY][newX] = c;
    }


    private static void checkRow() {
        for(int i=0; i<N; i++){
            int max = 1;
            for(int j=1; j<N; j++){
                if(Candy[i][j-1] == Candy[i][j]){
                    max++;
                    if(max > Max) Max = max;
                    if(Max == N){
                        System.out.println(Max); return;
                    }
                } else {
                    max = 1;
                }
            }
        }
    }

    private static void checkCol() {
        for(int i=0; i<N; i++){
            int max = 1;
            for(int j=1; j<N; j++){
                if(Candy[j-1][i] == Candy[j][i]){
                    max++;
                    if(max > Max) Max = max;
                    if(Max == N){
                        System.out.println(Max); return;
                    }
                } else {
                    max = 1;
                }
            }
        }
    }

    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= N) return true;
        return false;
    }
}
