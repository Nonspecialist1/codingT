package beckjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Guess_1248 {

    static int R;
    static char[][] S;
    static int[] Temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        R = Integer.parseInt(br.readLine());
        S = new char[R][R];
        Temp = new int[R];

        String str = br.readLine();
        int idx = 0;
        for(int i=0; i<R; i++){
            for(int j=i; j<R; j++){
                S[i][j] = str.charAt(idx++);
            }
        }

        perm(0);
    }

    static void perm(int r){
        if(r == R){
            String str = "";
            for(int i=0; i<R; i++){
                str += Temp[i] + " ";
            }

            System.out.println(str);
            System.exit(0); // 강제종료
            return;
        }

        for(int i=-10; i<11; i++){
            Temp[r] = i;
            if(checkMtx(r)) perm(r+1);
        }
    }

    private static boolean checkMtx(int r) {
        for(int i=0; i<=r; i++){
            int n = 0;
            for(int j=i; j<=r; j++){
                n += Temp[j];

                if(S[i][j] != (n == 0 ? '0' : (n > 0 ? '+' : '-'))){
                    return false;
                }
            }
        }

        return true;
    }

}
