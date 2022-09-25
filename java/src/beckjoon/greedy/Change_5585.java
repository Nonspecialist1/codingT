package beckjoon.greedy;

import java.util.Scanner;

public class Change_5585 {

    static int PAY = 1000;
    static int[] Coins = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int change = PAY - value;

        int cnt = 0;
        for(int i : Coins){
            cnt += change / i;
            change %= i;
        }

        System.out.println(cnt);
    }

}
