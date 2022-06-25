package beckjoon.dp;

import java.util.Scanner;

public class SquareNumSum_1699 {

    static int N;
    static int[] DP;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        DP = new int[N+1];

        for(int i=1; i<=N; i++){
            DP[i] = i; // 값 초기화

            if(checkSqrt(i) == 1){
                DP[i] = 1;
                continue;
            }

            DP[i] = Math.min(DP[i-1] + 1, DP[i]);
            // 모든 더하기 조합 찾기
            for(int j=1; j<=i/2; j++){
                DP[i] = Math.min(DP[i], DP[j] + DP[i-j]);
            }
        }

        System.out.println(DP[N]);
    }

    private static int checkSqrt(long n) {
        double sqrt = Math.sqrt(n);

        if(sqrt % 1 > 0){
            return 0;
        } else {
            return 1;
        }
    }

}
