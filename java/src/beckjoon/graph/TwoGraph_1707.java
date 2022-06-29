package beckjoon.graph;

import com.sun.org.apache.xpath.internal.operations.Or;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TwoGraph_1707 {

    static int K, V, E;
    static ArrayList<Integer>[] Graph;
    static boolean[] Visit;
    static int[] Order;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        all:for(int t=0; t<K; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            Visit = new boolean[V+1];
            Graph = new ArrayList[V+1];
            Order = new int[V+1];

            for(int i=1; i<V+1; i++){ // 그래프 초기화
                Graph[i] = new ArrayList<>();
            }

            for(int i=0; i<E; i++){ // 간선 채우기
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                Graph[a].add(b);
                Graph[b].add(a);
            }

            BFS(1);
            for(int i=1; i<V+1; i++){
                if(!Visit[i]) BFS(i);
            }

            for(int i=1; i<V+1; i++){ // 그래프 초기화
                for(int v : Graph[i]){
                    if(Order[i] == Order[v]){
                        System.out.println("NO");
                        continue all;
                    }
                }
            }

            System.out.println("YES");
        }
    }

    static void BFS(int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        Visit[st] = true;

        while (!q.isEmpty()){
            int v = q.poll();

            for(int i : Graph[v]){
                if(Visit[i]) continue;
                Visit[i] = true;

                if(Order[v] == 0) Order[i] = 1;
                else Order[i] = 0;

                q.add(i);
            }
        }

    }

}
