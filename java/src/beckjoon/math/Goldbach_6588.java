package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach_6588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 1000001;
        boolean[] isPrime = new boolean[MAX];

        for(int i=2; i*i<MAX; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<MAX; j += i){ isPrime[j] = true; }
            }
        }

        a:while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            for(int i=3; i<=N/2; i++){
                if(!isPrime[i] && !isPrime[N-i]){
                    System.out.println(N + " = " + i + " + " + (N-i));
                    continue a;
                }
            }
            System.out.println("Goldbach's conjecture is wrong.");
        }
    }
}
