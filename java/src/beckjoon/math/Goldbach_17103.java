package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Goldbach_17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int MAX = 1000001;
        boolean[] isPrime = new boolean[MAX];

        for(int i=2; i*i<MAX; i++){
            if(!isPrime[i]){
                for(int j=i*i; j<MAX; j += i){ isPrime[j] = true; }
            }
        }

        int N = Integer.parseInt(br.readLine());
        while(N-->0){
            int num = Integer.parseInt(br.readLine());

            int cnt = 0;
            for(int i=2; i<=num/2; i++){
                if(!isPrime[i] && !isPrime[num-i]) cnt++;
            }
            System.out.println(cnt);
        }
    }
}
