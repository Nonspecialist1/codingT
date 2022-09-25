package beckjoon.dp;

import java.util.Arrays;
import java.util.Scanner;

public class ASC_11057 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] DP = new long[N+1][10];
        Arrays.fill(DP[1], 1);

        for(int i=2; i<=N; i++){
            // i 자리수 마다 채워주기
            for(int idx=0; idx<10; idx++){
                if(idx == 0){
                    DP[i][idx] = DP[i-1][idx] ;
                }
                else {
                    DP[i][idx] = (DP[i-1][idx] + DP[i][idx-1]) % 10007;
                }
            }
        }

        int result = 0;
        for(long i : DP[N]){
            result += i;
        }

        System.out.println(result % 10007);
    }
}
