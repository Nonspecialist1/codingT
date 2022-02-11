package swexpertacademy;

import java.io.IOException;
import java.util.Scanner;

public class SquareRoom_1861 {
    static int[][] room;
    static int N;
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int st;
    static int cnt;
    static int maxCnt;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int Tcase = sc.nextInt();

        for(int T=1; T<=Tcase; T++){
            N = sc.nextInt();
            room = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    room[i][j] = sc.nextInt();
                }
            }

            st = 1;
            maxCnt = 1;
            for(int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    int tempSt = room[i][j];
                    cnt = 1;
                    getMove(i, j);
                    if(cnt > maxCnt){ maxCnt = cnt; st = tempSt; }
                    if(cnt == maxCnt && tempSt < st) st = tempSt;
                }
            }
            System.out.printf("#%d %d %d\n", T, st, maxCnt);
        }
    }

    static void getMove(int stY, int stX){
        int newSt = room[stY][stX];
        for(int d=0; d<4; d++){ // 사방 확인
            int y = stY+dy[d];
            int x = stX+dx[d];
            if(!checkWalls(y,x)){ // 벽인지 확인
                if(room[y][x] == newSt + 1){ // 1보다 큰지 확인
                    cnt++;
                    getMove(y,x);
                }
            }
        }
    }

    static boolean checkWalls(int y, int x){
        if(y < 0 || x < 0 || y >= N || x >= N)  return true;
        return false;
    }

}
