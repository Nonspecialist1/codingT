package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Date_Cal_1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int ans = 0;
        int e=1, s=1, m=1;

        while (true){
            ans++;
            if(E == e && S == s && M == m){
                break;
            } else {
                e++; s++; m++;
            }

            if(e == 16) e=1;
            if(s == 29) s=1;
            if(m == 20) m=1;
        }

        System.out.println(ans);
    }
}
