package beckjoon.bruteforce.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Basic_15650 {
    static int[] arr, temp;
    static boolean[] visited;
    static int r = 6;
    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 1 ~ N까지 자연수
        // r = sc.nextInt(); // 수열의 길이

        while (n != 0){
            arr = new int[n];
            temp = new int[r];

            for(int i=0; i<n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n];
            permutation(0, 0);
            System.out.println();

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }

        // arr = new int[n];
        // permutation(0);
    }

    static void permutation(int idx, int depth) {
       if(depth == r){
           sb = new StringBuilder();

           for(int i : temp){ sb.append(i + " "); }
           System.out.println(sb);

           return;
       }

       for(int i=idx; i<n; i++){
           if(visited[i]) continue;

           temp[depth] = arr[i];

           visited[i] = true;
           permutation(i,depth + 1);
           visited[i] = false;
       }
    }
}
