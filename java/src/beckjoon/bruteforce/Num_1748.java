package beckjoon.bruteforce;

import java.util.Scanner;

public class Num_1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int cnt = 0;
        int plus = 1;
        int num = 10;

        for(int i=1; i<=N; i++){
           if(i % num == 0){
                plus++;
                num *= 10;
           }
           cnt += plus;
        }
        System.out.println(cnt);
    }
}
