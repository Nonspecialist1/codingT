package beckjoon.imlevel;

import java.util.Scanner;

public class Confetti_2563 {
    static boolean[][] board = new boolean[101][101];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int j=x; j<x+10; j++)
            {
                for(int k=y; k<y+10; k++){ board[j][k] = true; }
            }
        }

        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){ if(board[i][j]) cnt++; }
        }

        System.out.println(cnt);
    }
}
