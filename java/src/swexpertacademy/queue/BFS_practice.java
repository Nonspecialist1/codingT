package swexpertacademy.queue;

import java.util.*;

public class BFS_practice {
    static boolean[] visited = new boolean[8];
    static int[][] arr = new int[8][8];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[8];
        arr = new int[8][8];
        sb = new StringBuilder();
        for(int i=0; i<8; i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                arr[a][b]++;
                arr[b][0]++;
        }
        int start = 0;
        for(int i=1; i<8; i++){
            if(arr[i][0] == 0){ start = i; break; }
        }
        BFS(arr, start);
        System.out.println(sb);
    }
    static void BFS(int[][] arr, int v){
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited[v] = true;
        sb.append(v);
        while(!q.isEmpty()){
            int t = q.poll();
            for(int i=1; i<8; i++){
                if(arr[t][i] != 0)
                {
                    if(!visited[i]){
                        q.add(i);
                        visited[i] = true;
                        sb.append(" - " + i);
                    }
                }
            }
        }
    }

}
