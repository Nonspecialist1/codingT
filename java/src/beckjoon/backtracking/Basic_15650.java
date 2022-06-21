package beckjoon.backtracking;

import java.util.Scanner;

public class Basic_15650 {
    static int[] arr;
    static boolean[] visited;
    // static int r;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 1 ~ N까지 자연수
        // r = sc.nextInt(); // 수열의 길이

        visited = new boolean[n+1];
        arr = new int[n];

        permutation(0);
    }

    static void permutation(int depth) {
       if(depth == n){
           for(int i : arr){ System.out.print(i + " "); }
           System.out.println();
           return;
       }

       for(int i=1; i<=n; i++){
           if(visited[i]) continue;

           arr[depth] = i;

           visited[i] = true;
           permutation(depth + 1);
           visited[i] = false;
       }
    }
}
