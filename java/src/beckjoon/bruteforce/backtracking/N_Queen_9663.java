package beckjoon.bruteforce.backtracking;

import java.util.Scanner;

public class N_Queen_9663 {

    static int[][] Chess;
    static boolean[][] Visit;

    static int N, Q = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        Chess = new int[N][N];
        Visit = new boolean[N][N];

        BackTracking(0);
        System.out.println(Q);
    }

    private static void BackTracking(int row) {
        if(row == N){ // 모든 퀸이 채워졌을 때
            Q++;
            return;
        }

        for(int i=0; i<N; i++){ // 모든 컬럼을 돌기
            if(!Visit[row][i]){ // 채워지지 않은 경우에만 놓기
                Visit[row][i] = true;
                Chess[row][i] = 1;

                checkVisit(row, i);
                BackTracking(row+1);

                // 방문 전부 초기화
                initVisit();
                Chess[row][i] = 0;

                // 이전의 퀸 위치 복원
                revertVisit();
            }
        }
    }

    private static void checkVisit(int row, int col) {
        // 아래
        for(int i=row; i<N; i++){
            Visit[i][col] = true;
        }
        // 왼쪽 대각선
        int r = row;
        int c = col;
        while (0 <= c && c < N && 0 <= r && r < N){
            Visit[r++][c--] = true;
        }
        // 오른쪽 대각선
        while (0 <= row && row < N && 0 <= col && col < N){
            Visit[row++][col++] = true;
        }
    }

    private static void initVisit() {
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                Visit[i][j] = false;
            }
        }
    }

    private static void revertVisit() {
        for(int j=0; j<N; j++){
            for(int k=0; k<N; k++){
                if(Chess[j][k] == 1){
                    checkVisit(j, k);
                }
            }
        }
    }

}
