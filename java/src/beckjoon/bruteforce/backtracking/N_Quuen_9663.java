package beckjoon.bruteforce.backtracking;

import java.util.Scanner;

public class N_Quuen_9663 {
    static int[][] board;
    static boolean[][] visit;
    static int cnt;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N개의 퀸
        board = new int[N][N];
        visit = new boolean[N][N];

        cnt = 0;
        checkQueen(0);

        System.out.println(cnt);
    }

    static void checkQueen(int n) {
        if(n == N){
            cnt++;
            return;
        }
        for(int i=0; i<N; i++){
            if(!visit[n][i]){
                visit[n][i] = true;
                board[n][i] = 1;

                // 퀸이 가는 방향 체크
                checkDir(n, i);
                checkQueen(n+1);

                board[n][i] = 0;
                init_board();

                for(int k=0; i<N; i++){
                    for(int j=0; j<N; j++){
                        if(board[k][j] == 1){
                            checkDir(k, j);
                        }
                    }
                }
            }
        }

    }

    // 벽검색
    static void checkDir(int x, int y) {
       for(int i=x; i<N; i++){
           visit[i][y] = true;
       }

       int a = x;
       int b = y;

       while(x >= 0 && x < N && y >= 0 && y < N) {
           visit[x++][y++] = true;
       }

       while(a >= 0 && a < N && b >= 0 && b < N){
           visit[a++][b--] = true;
       }
    }

    static void init_board(){
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                visit[i][j] = false;
            }
        }
    }

}
