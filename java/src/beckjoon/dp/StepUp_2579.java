package beckjoon.dp;
import java.util.Scanner;

public class StepUp_2579 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] DP = new int[N+1];
        int[] Stairs = new int[N+1];

        for(int i=1; i<=N; i++){
            Stairs[i] = sc.nextInt();
        }
        DP[1] = Stairs[1];

        if(N >= 2) {
            DP[2] = DP[1] + Stairs[2];
        }
        for(int i=3; i<=N; i++){
            DP[i] = Math.max(DP[i-2], DP[i-3] + Stairs[i-1]) + Stairs[i];
        }
        System.out.println(DP[N]);
    }
}
