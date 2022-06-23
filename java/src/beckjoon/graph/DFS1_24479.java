package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS1_24479 {
    static ArrayList<Integer>[] Graph;
    static int[] Visit;
    static int st = 1;

    static int N, M, R;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N+1];
        Visit = new int[N+1];

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

        for(int i=1; i<N+1; i++){ // 내림차순 정렬
            Collections.sort(Graph[i]);
            Collections.reverse(Graph[i]);
        }

        // DFS
        DFS(R);
        for(int i=1; i<N+1; i++){
            System.out.println(Visit[i]);
        }
    }

    static void DFS(int start){
        if(Visit[start] != 0) return;

        Visit[start] = st++;

        for(int i : Graph[start]){
            if(Visit[i] == 0){ DFS(i); }
        }
    }

}
