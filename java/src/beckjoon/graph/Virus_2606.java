package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Virus_2606 {
    static ArrayList<Integer>[] Graph;
    static boolean[] Visit;

    static int N, M;
    static int Cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        Graph = new ArrayList[N+1];
        Visit = new boolean[N+1];

        // Arraylist 배열 초기화
        for(int i=1; i<N+1; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){ // 양방향 그래스
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a].add(b);
            Graph[b].add(a);
        }

        // DFS
        DFS(1);
        System.out.println(Cnt);
    }

    static void DFS(int start){
        if(Visit[start]) return;
        Visit[start] = true;

        for(int i : Graph[start]){
            if(!Visit[i]){ DFS(i);  Cnt++; }
        }
    }

}
