package swexpertacademy;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Game2048_6109 {
    static int[][] board;
    static int N;
    static int[] dy = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dx = {0, 0, -1, 1};
    static int d;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int Tcase = sc.nextInt();

        for(int T=1; T<=Tcase; T++){
            N = sc.nextInt();
            String S = sc.next();
            switch (S) {
                case "up": d=0; break;
                case "down": d=1; break;
                case "left": d=2; break;
                case "right": d=3; break;
            }

            board = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){ board[i][j] = sc.nextInt(); }
            }

            System.out.printf("#%d \n", T);

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.printf("%-3d", board[i][j]);
                }
                System.out.println();
            }
        }
    }

}
