package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TreeTraversal_1991 {

    static int N;
    static ArrayList<Integer>[] Graph;
    static boolean[] Visit;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Visit = new boolean[N];
        Graph = new ArrayList[N];

        for(int i=0; i<N; i++){ // 트리 초기화
            Graph[i] = new ArrayList<>();
        }

        // 트리 값 넣기
        for(int i=0; i<N; i++){ // 트리 초기화
            String str = br.readLine().replaceAll(" ", "");
            int v = str.charAt(0) - 65;
            int left = str.charAt(1) - 65;
            int right = str.charAt(2) - 65;

            Graph[v].add(left);
            Graph[v].add(right);
        }

        // 전위 순회
        preOrder(0);
        SB.append("\n");
        // 중위 순회
        Visit = new boolean[N];
        intOrder(0);
        SB.append("\n");
        // 후위 순회
        Visit = new boolean[N];
        postOrder(0);

        System.out.println(SB);
    }
    private static void preOrder(int st) {
        Visit[st] = true;
        char c = (char) (st + 65);
        SB.append(c);

        for(int node : Graph[st]){
            if(node >= 0 && !Visit[node]){ // 방문하지 않은 노드라면 이동
                preOrder(node);
            }
        }
    }

    private static void intOrder(int st) {
        for(int node : Graph[st]){
            if(node >= 0 && !Visit[node]){ // 방문하지 않은 노드라면 이동
                intOrder(node);
            }

            if(!Visit[st]){
                Visit[st] = true;
                char c = (char) (st + 65);
                SB.append(c);
            }
        }
    }

    private static void postOrder(int st) {
        for(int node : Graph[st]){
            if(node >= 0 && !Visit[node]){ // 방문하지 않은 노드라면 이동
                postOrder(node);
            }
        }

        if(!Visit[st]){
            Visit[st] = true;
            char c = (char) (st + 65);
            SB.append(c);
        }
    }

}
