package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LandCnt_4963 {

    static int W, H, Cnt = 0;
    static int[][] Land;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            // 종료
            if(W == 0 & H == 0) break;
            // 계속
            Cnt = 0;
            Land = new int[H][W];
            Visit = new boolean[H][W];

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    Land[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 섬의 개수 셈
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(Land[i][j] != 0) {
                        LandCnt(i, j);
                    }
                }
            }

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    if(Land[i][j] != 0) Cnt++;
                }
            }
            System.out.println(Cnt);
        }
    }

    // 가로, 세로, 대각선 방향
    static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};

    private static void LandCnt(int col, int row) {
        if(Visit[col][row]) return;

        for(int i=0; i<8; i++){
            int newY = col + dy[i];
            int newX = row + dx[i];
            // 바다가 아닌 경우 이동
            if(!checkSea(newY, newX) && Land[newY][newX] == 1 && !Visit[newY][newX]){
                Visit[col][row] = true;

                Land[newY][newX] = 0;
                LandCnt(newY, newX);
            }
        }
    }

    private static boolean checkSea(int newY, int newX) {
        if(newY < 0 || newY >= H || newX < 0 || newX >= W) return true;
        return false;
    }

}
