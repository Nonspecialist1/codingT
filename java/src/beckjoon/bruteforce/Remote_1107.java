package beckjoon.bruteforce;

import java.util.Scanner;

public class Remote_1107 {
    static boolean[] isBroken = new boolean[10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int Target = sc.nextInt();
        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int idx = sc.nextInt();
            isBroken[idx] = true;
        }
        int cnt = Math.abs(Target - 100);

        for (int i = 0; i <= 1000000; i++) {
            int len = check(i);
            if(len > 0){
                int press = Math.abs(Target - i);
                cnt = Math.min(cnt, len + press);
            }
        }
        System.out.println(cnt);
    }

    static int check(int n) {
        if (n == 0) {
            if (isBroken[n]) return 0;
            else return 1;
        }
        int len = 0;
        while(n > 0){
            if(isBroken[n % 10]) return 0;
            n /= 10;
            len += 1;
        }
        return len;
    }

}
