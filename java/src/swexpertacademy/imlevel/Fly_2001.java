package swexpertacademy.imlevel;

import java.util.Scanner;

public class Fly_2001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T_case = sc.nextInt();
        for(int T=1; T<=T_case; T++){
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] board = new int[N][N];
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    board[i][j] = sc.nextInt();
                }
            }

            int D = N-M;
            int ans = 0;
            for(int i=0; i<=D; i++){
                for(int j=0; j<=D; j++){
                    int temp = 0;
                    for(int s=i; s<M+i; s++){
                        for (int k=j; k<M+j; k++) {
                            temp += board[s][k];
                        }
                    }
                    if(temp > ans) ans = temp;
                }
            }
            System.out.printf("#%d %d\n", T, ans);
        }
    }
}
