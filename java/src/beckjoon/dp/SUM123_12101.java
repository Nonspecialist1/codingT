package beckjoon.dp;

import java.util.Scanner;

public class SUM123_12101 {

    static int[] temp = new int[11];
    static int n, k, cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        BruteForce(0, 0);
        System.out.println(-1);
    }

    private static void BruteForce(int sum, int idx){
        if(idx == 11 || sum > n) return;

        if(sum == n){
            cnt++;
            if(cnt == k){
                for(int i : temp){
                    if(i == 0) break;
                    sb.append(i+"+");
                }
                sb.deleteCharAt(sb.length()-1);
                System.out.println(sb);
                System.exit(0);
            }
            return;
        }

        for(int i=1; i<4; i++){
            temp[idx] = i;
            BruteForce(sum + i, idx + 1);
            temp[idx] = 0;
        }
    }
}
