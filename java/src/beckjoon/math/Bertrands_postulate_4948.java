package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bertrands_postulate_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 250000;
        boolean[] isPrime = new boolean[MAX];

        for(int i=2; i*i<MAX; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<MAX; j += i){ isPrime[j] = true; }
            }
        }

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int cnt = 0;
            for(int i=N+1; i<=2*N; i++){
                if(!isPrime[i]){
                   cnt++;
                }
            }
            System.out.println(cnt);
        }

    }
}
