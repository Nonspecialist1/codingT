package swexpertacademy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GNS_1221 {
    static String[] num = { "ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN" };
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        int T = 0;
        while(T != 10){
            cnt = new int[10];
            br.readLine(); T++;

            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            while(st.hasMoreTokens()){
                String s = st.nextToken();
                for(int j=0; j<10; j++){
                    if(num[j].equals(s)){ cnt[j]++; break;}
                }
            }

            sb.append("#"+T + " ");
            for(int i=0; i<10; i++){
                int iter = cnt[i];
                for(int j=0; j<iter; j++){ sb.append(num[i] + " "); }
            }
            System.out.println(sb);
         }
    }
}
