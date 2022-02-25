package beckjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Math_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        BigInteger val = BigInteger.ONE;
        for(int i=2; i<=N; i++){
            BigInteger j = BigInteger.valueOf(i);
            val = val.multiply(j);
        }

        int cnt =0;
        String str = String.valueOf(val);
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == '0') cnt++;
            else break;
        }

        System.out.println(cnt);
    }
}
