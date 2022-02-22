package swexpertacademy.imlevel;

import java.util.Scanner;

public class Fly_2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] board = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    board[i][j] = sc.nextInt();
                }
            }

            int ans = 0;
            int val = 0;
            int cnt = M;
            for(int i=0; i<N; i++){
                cnt = 0;
                for(int j=0; j<N; j++){
                    val += board[i][j];
                    cnt++;
                    if(cnt == M) continue;
                }
            }



            System.out.printf("#%d %d\n", T, ans);
        }
    }
}
