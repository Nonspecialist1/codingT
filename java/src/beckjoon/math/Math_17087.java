package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Math_17087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st1.nextToken());
        int X = Integer.parseInt(st1.nextToken());
        int[] D = new int[N];

        for(int i=0; i<N; i++){
            D[i] = Math.abs(X - Integer.valueOf(st2.nextToken()));
        }
        int gcd = D[0];
        for(int j=1; j<N; j++){ gcd = GCD(D[j], gcd); }

        System.out.println(gcd);
    }

    static int GCD(int a, int b){
        if(a % b == 0) return b;
        else return GCD(b, a % b);
    }
}
