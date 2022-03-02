package swexpertacademy.array2;

import java.io.IOException;
import java.util.Scanner;

public class GetHoney_2115 {
    static int N;
    static int M;
    static int C;
    static int[][] Box;
    static boolean[][] visited;
    static int ans;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++){
            N = sc.nextInt();
            Box = new int[N][N];
            visited = new boolean[N][N];
            M = sc.nextInt();
            C = sc.nextInt();

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){ Box[i][j] = sc.nextInt(); }
            }

            ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    getHoney(i, j, 0, 0);
                }
            }

            int total = ans;
            ans = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j]) getHoney(i, j, 0, 0);
                }
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
        sc.close();
    }

    static void getHoney(int i, int j, int m, int temp){
        if(m == M){
            int max = 0;
            if(temp > C){
                int seq = 0;
                for(int x=0; x<N; x++){
                    for(int y=0; y<N; y++){
                        if(visited[x][y]){
                            seq += Box[x][y];
                            if(seq <= temp){ max += (int) Math.pow(Box[x][y], 2); }
                            else { max = (int) Math.pow(Box[x][y], 2); }
                            if(max > ans) ans = max;
                        }
                    }
                }
            }
            else {
                for(int x=0; x<N; x++){
                    for(int y=0; y<N; y++){
                        if(visited[x][y]){ max += (int) Math.pow(Box[x][y], 2); }
                    }
                }
                if(max > ans) ans = max;
            }
        }
        if(!visited[i][j] && j < N){
            visited[i][j] = true;
            temp += Box[i][j];
            getHoney(i, j+1, m+1, temp);
            visited[i][j] = false;
        }
    }

}
