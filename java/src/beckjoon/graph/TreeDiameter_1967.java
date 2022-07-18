package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TreeDiameter_1967 {

    static class Node {
        int idx, value;

        Node(int idx, int value){
            this.idx = idx;
            this.value = value;
        }
    }

    static int N, Ans = -1, Idx = 0;
    static ArrayList<Node>[] Graph;
    static boolean[] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Visit = new boolean[N+1];
        Graph = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            Graph[parent].add(new Node(child, value)); // 부모 자식 가중치
            Graph[child].add(new Node(parent, value));
        }

        // 루트노드에서 시작 -> 가중치 가장 큰 단말노드 찾기
        Visit[1] = true;
        DFS(1, 0);

        Visit = new boolean[N+1];
        Visit[Idx] = true;
        DFS(Idx, 0);

        System.out.println(Ans);
    }

    private static void DFS(int st, int ans){
        // 단말노드에 도착했을 때
        if(Ans < ans){
            Ans = ans;
            Idx = st;
        }

        for(Node v : Graph[st]){
            if(!Visit[v.idx]){
                Visit[v.idx] = true;
                DFS(v.idx, ans + v.value);
            }
        }
    }

}
