package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Math__2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int min = 0;
        int total = 0;
        for(int i=M; i<=N; i++){
            int cnt = 0;
            for(int j=2; j<=i; j++){ if(i%j == 0) cnt++; }
            if(cnt == 1){
                if(min == 0) min = i;
                total += i;
            }
        }
        if(min > 0){
            System.out.println(total);
            System.out.println(min);
        }else {
            System.out.println(-1);
        }
    }
}
