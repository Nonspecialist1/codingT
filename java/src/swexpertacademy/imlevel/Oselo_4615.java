package swexpertacademy.imlevel;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Oselo_4615 {
    static int[][] board;
    static int N;
    static Queue<Integer> q;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T_case = sc.nextInt();
        for(int T=1; T<=T_case; T++){
            q = new LinkedList<>();

            N = sc.nextInt();
            board = new int[N+1][N+1];

            if(N == 4){
                board[2][2] = board[3][3] = 2;
                board[2][3] = board[3][2] = 1;
            }
            else if(N == 6){
                board[3][3] = board[4][4] = 2;
                board[3][4] = board[4][3] = 1;
            }
            else if(N == 8) {
                board[4][4] = board[5][5] = 2;
                board[4][5] = board[5][4] = 1;
            }

            int time = sc.nextInt();
            for(int i=0; i<time; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                int color = sc.nextInt();
                board[y][x] = color;

                for(int d=0; d<8; d++){
                    check(y, x, d, color);
                }
            }

            int[] cnt = new int[2];
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(board[i][j] == 1){ cnt[0]++; }
                    else if(board[i][j] == 2) { cnt[1]++; }
                }
            }

            System.out.printf("#%d %d %d", T, cnt[0], cnt[1]);
        }

    }
    // 팔방검색
    static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
    static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

    static void check(int y, int x, int d, int color){
        int newY = y + dy[d];
        int newX = x + dx[d];
        if(newX > 0 && newY > 0 && newY <= N && newX <= N && board[newY][newX] != 0){
            if(board[newY][newX] != color) {
                q.add(newY);
                q.add(newX);
                check(newY, newX, d, color);
            } else {
                while (!q.isEmpty()){
                    int chY = q.poll();
                    int chX = q.poll();
                    board[chY][chX] = color;
                }
            }
        } else {
            while(!q.isEmpty()){ q.poll(); }
        }
    }

}
