package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach_9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 10001;
        boolean[] isPrime = new boolean[MAX];

        for(int i=2; i*i<MAX; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<MAX; j += i){ isPrime[j] = true; }
            }
        }

        int T = Integer.parseInt(br.readLine());
        while (true) {
            if (T == 0) break;
            int N = Integer.parseInt(br.readLine());

            int x = 0;
            int y = 0;
            for(int i=2; i<=N/2; i++){
                if(!isPrime[i] && !isPrime[N-i]){
                    x = i; y = N-i;
                }
            }
            T--;
            System.out.println(x + " " + y);
        }

    }
}
