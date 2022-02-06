package beckjoon.backtracking;

import java.util.Scanner;

public class Basic_15649 {
    static int N;
    static int r;
    static int[] arr;
    static int[] answer;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 1 ~ N까지 자연수
        arr = new int[N];
        check = new boolean[N];
        for(int i=0; i<N; i++){ arr[i] = i+1; }
        r = sc.nextInt(); // 수열의 길이
        answer = new int[r];

        permutation(0);
    }
    static void permutation(int depth){
        if(r == depth){ print(answer); return; }
        for(int i=0; i<N; i++){
            if(!check[i])
            {
                check[i] = true;
                answer[depth] = arr[i];
                permutation(depth + 1);
                check[i] = false;
            }
        }
    }
    static void print(int[] answer){
        for(int i : answer){ System.out.print(i + " "); }
        System.out.println();
    }


}
