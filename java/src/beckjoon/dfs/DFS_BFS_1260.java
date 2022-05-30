package beckjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_BFS_1260 {
    static ArrayList<Integer>[] Graph;
    static boolean[] Visit;

    static int N, M, Start;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Start = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N+1];
        Visit = new boolean[N+1];

        // Arraylist 배열 초기화
        for(int i=1; i<N+1; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){ // 양방향 그래스
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a].add(b);
            Graph[b].add(a);
        }

        for(int i=1; i<N+1; i++){ // 오름차순 정렬
            Collections.sort(Graph[i]);
        }

        // DFS
        DFS(Start);
        sb.append("\n");
        // 값 초기화
        Visit = new boolean[N+1];
        // BFS
        BFS();
        // 값출력
        System.out.println(sb);
    }

    static void DFS(int start){
        if(Visit[start]) return;

        Visit[start] = true;
        sb.append(start + " ");

        for(int i : Graph[start]){
            if(!Visit[i]){ DFS(i); }
        }
    }

    static void BFS(){
        Queue<Integer> que = new LinkedList<>();
        que.add(Start);
        Visit[Start] = true;

        while (!que.isEmpty()){
            int x = que.poll();
            sb.append(x + " ");

            for(int i : Graph[x]){
                if(!Visit[i]){
                    Visit[i] = true;
                    que.add(i);
                }
            }
        }
    }



}
