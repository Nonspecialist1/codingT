package beckjoon.bruteforce;

import java.util.Scanner;

public class Movie666_1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] n = new int[N];

        int idx = 0;
        for(int i=666; i<=2666799; i++){
            String str = String.valueOf(i);
            if(str.contains("666")){
                n[idx++] = i;
                if(idx == N) break;
            }
        }

        System.out.println(n[idx-1]);
    }
}
