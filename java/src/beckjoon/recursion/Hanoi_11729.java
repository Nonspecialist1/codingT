package beckjoon.recursion;

import java.util.Scanner;
import java.util.Stack;

public class Hanoi_11729 {
    static int one = 1;
    static int two = 2;
    static int three = 3;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sb.append((int)Math.pow(2, N) - 1 + "\n");
        getHanoi(N, one, two, three);

        System.out.println(sb);
    }

    static void getHanoi(int N, int one, int two, int three){
        if(N == 1){ sb.append(one + " " + three + "\n"); return; }

        // 1 -> 3 으로 옮길 때, N-1 개를 1 -> 2로 이동
        getHanoi(N-1, one, three, two);
        // 1개를 1 -> 3으로 이동
        sb.append(one + " " + three + "\n");
        // N-1 개를 2 -> 3으로 이동
        getHanoi(N-1, two, one, three);
    }

}
