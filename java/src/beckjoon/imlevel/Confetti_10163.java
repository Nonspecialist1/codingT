package beckjoon.imlevel;

import java.util.Scanner;

public class Confetti_10163 {
    static int[][] board = new int[1001][1001];
    static int[] ans;
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ans = new int[N+1];
        cnt = 1;

        for(int i=0; i<N; i++){
            int y = sc.nextInt();
            int x = sc.nextInt();
            int col = sc.nextInt();
            int row = sc.nextInt();

            for(int ny=y; ny<y+col; ny++){
                for(int nx=x; nx<x+row; nx++){
                    board[ny][nx] = cnt;
                }
            }
            cnt++;
        }

        for(int k=1; k<=cnt; k++) {
            for(int i=0; i<1001; i++){
                for(int j=0; j<1001; j++){
                    if(board[i][j] == k){ ans[k]++; }
                }
            }
        }

        for(int i=1; i<ans.length; i++){ System.out.println(ans[i]); }
    }
}
