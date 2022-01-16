package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int distance = y-x;
            int k =1;
            int total = 0;
            while(true) {
                total += k * 2;
                if(distance - total <= k) {
                    int mod = distance - total;
                    if(mod <= 0) {
                        if(mod + k == 0) { System.out.println(k * 2 - 1); break; }
                        System.out.println(k * 2); break;
                    }
                    System.out.println(k * 2 + 1); break;
                }
                k++;
            }
        }
    }
}
