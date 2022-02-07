package swexpertacademy.queue;

import java.io.IOException;
import java.util.*;

public class Contact_1238 {
    static int[][] arr;
    static boolean[] visited;
    static boolean[][] ans;
    static int depth;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++){
            int N = sc.nextInt();
            int start = sc.nextInt();
            arr = new int[110][110];
            visited = new boolean[110];
            ans = new boolean[110][110];
            for(int i=0; i<N/2; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b]++; // from to
            }
            DFS(arr, start);
            int result = 0;
            for(int i=1; i<110; i++){
                if(ans[depth-2][i]) result = i;
            }
            System.out.printf("#%d %d\n", T, result);
        }
    }
    static void DFS(int[][] arr, int v){
        Queue<Integer> q = new LinkedList<>();
        depth = 2;
        q.add(v);
        while(!q.isEmpty()){
            int k = q.size();
            for(int j=0; j<k; j++)
            {
                int t = q.poll();
                for(int i=1; i<110; i++) {
                    if(arr[t][i] > 0 && !visited[i]){
                        q.add(i);
                        visited[i] = true;
                        ans[depth][i] = true;
                    }
                }
            }
            depth++;
        }
    }
}
