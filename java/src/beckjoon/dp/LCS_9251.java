package beckjoon.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS_9251 {
    static char[] STRING1;
    static char[] STRING2;
    static int[] DP;

    static int LCS = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        STRING1 = br.readLine().toCharArray();
        STRING2 = br.readLine().toCharArray();
        // LCS 찾기
        for(int i=0; i<STRING1.length; i++){
            getLCS(i);
        }

        System.out.println(LCS);
    }

    static void getLCS(int idx){
        int st = 0;
        int lcs = 0;

        for(int i=idx; i<STRING1.length; i++){
            char ch = STRING1[i];

            for(int j=st; j<STRING2.length; j++){
                if(ch == STRING2[j]){
                    lcs++;
                    st = j+1;
                    break;
                }
            }
        }

        if(lcs > LCS) LCS = lcs;
    }

}
