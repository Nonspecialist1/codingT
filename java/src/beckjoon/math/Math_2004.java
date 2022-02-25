package beckjoon.math;

import java.util.Scanner;

public class Math_2004 {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long r = sc.nextLong();

        long cntFif = fiveCnt(n) - (fiveCnt(r) + fiveCnt(n-r));
        long cntTwo = twoCnt(n) - (twoCnt(r) + twoCnt(n-r));

        System.out.print(Math.min(cntFif, cntTwo));
    }
    static long fiveCnt(long num){
        int cnt = 0;
        while(num >= 5){
            cnt += num/5;
            num /= 5;
        }
        return cnt;
    }
    static long twoCnt(long num){
        int cnt = 0;
        while(num >= 2){
            cnt += num/2;
            num /= 2;
        }
        return cnt;
    }
}
