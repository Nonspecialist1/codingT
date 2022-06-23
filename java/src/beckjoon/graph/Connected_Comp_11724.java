package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Connected_Comp_11724 {
    static ArrayList<Integer>[] Graph;
    static boolean[] Visit;

    static int N, M, Cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N+1];
        Visit = new boolean[N+1];

        // Arraylist 배열 초기화
        for(int i=1; i<N+1; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){ // 양방향 그래프
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a].add(b);
            Graph[b].add(a);
        }

        // DFS
        DFS(1);
        sumCnt();
        System.out.println(Cnt);
    }

    private static void sumCnt() {
        boolean flag = false;

        for(int i=1; i<N+1; i++){
            if(!Visit[i]){ // 방문 하지 않은 점이 있으면 다시 dfs 시작
                Cnt++; DFS(i); flag = true;
                break;
            }
        }

        if(flag) sumCnt();
        else return;
    }

    static void DFS(int start){
        if(Visit[start]) return;

        Visit[start] = true;

        for(int i : Graph[start]){
            if(!Visit[i]){ DFS(i); }
        }
    }

}
