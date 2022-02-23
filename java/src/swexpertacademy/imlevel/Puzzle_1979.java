package swexpertacademy.imlevel;

import java.util.Scanner;

public class Puzzle_1979 {
    static int[][] puzzle;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Tcase = sc.nextInt();
        for(int T=1; T<=Tcase; T++){
            int N = sc.nextInt();
            int word = sc.nextInt();

            puzzle = new int[N][N];

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){ puzzle[i][j] = sc.nextInt(); }
            }

            int cnt = 0;
            // 행체크
            for(int y=0; y<N; y++){
                a:for(int x=0; x<=N-word; x++){
                    if(RowCheckSpoint(y, x) && puzzle[y][x] == 1){
                        for(int i=1; i<word; i++){
                            if(puzzle[y][x+i] != 1){ continue a; }
                        }
                        if(x+word < N && puzzle[y][x+word] == 1){ continue a; }
                        cnt++;
                    }
                }
            }

            // 열체크
            for(int x=0; x<N; x++){
                a:for(int y=0; y<=N-word; y++){
                    if(ColCheckSpoint(y, x) && puzzle[y][x] == 1){
                        for(int i=1; i<word; i++){
                            if(puzzle[y+i][x] != 1){ continue a; }
                        }
                        if(y+word < N && puzzle[y+word][x] == 1){ continue a; }
                        cnt++;
                    }
                }
            }
            System.out.printf("#%d %d\n", T, cnt);
        }
    }

    static boolean RowCheckSpoint(int y, int x){
        if(x == 0 || (x > 0 && puzzle[y][x-1] == 0)) { return true; }
        return false;
    }

    static boolean ColCheckSpoint(int y, int x){
        if(y == 0 || (y > 0 && puzzle[y-1][x] == 0)) { return true; }
        return false;
    }
}
