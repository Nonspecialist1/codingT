package swexpertacademy.advancelevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class SafetyFilm_2122 {

    static int D, W, K, SafeFilm[][], min;
    static final int A=0, B=1;
    static int[] drugA, drugB;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        System.out.println();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T_case = Integer.valueOf(br.readLine());

        for(int T=1; T<=T_case; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            D = Integer.valueOf(st.nextToken());
            W = Integer.valueOf(st.nextToken());
            K = Integer.valueOf(st.nextToken());

            SafeFilm = new int[D][W];
            drugA = new int[W];
            drugB = new int[W];
            min = K;

            for(int i=0; i<D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    SafeFilm[i][j] = Integer.valueOf(st.nextToken());
                }
            }
            Arrays.fill(drugA, A);
            Arrays.fill(drugB, B);

            solve(0, 0);
            System.out.printf("#%d %d\n", T, min);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static boolean checkAnswer(){
        for(int col=0; col<W; col++){
            int cnt = 1;
            int pre = SafeFilm[0][col];

            for(int row =1; row<D; row++){
                int cur = SafeFilm[row][col];

                if(pre == cur) {
                    if(++cnt == K) break;
                }
                else {
                    pre = cur;
                    cnt = 1;
                }
            }
            if(cnt < K) return false;
        }
        return true;
    }

    private static boolean solve(int row, int cnt) {
        if(row == D){
            if(checkAnswer()){
                min = Math.min(min, cnt);
                return min == 0;
            }
            return false;
        }
        int[] backUp = SafeFilm[row];
        if(solve(row+1, cnt)) return true;

        SafeFilm[row] = drugA;
        solve(row+1, cnt+1);

        SafeFilm[row] = drugB;
        solve(row+1, cnt+1);

        SafeFilm[row] = backUp;
        return false;
    }

}
