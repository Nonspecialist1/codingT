package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_Special_16940 {
    static ArrayList<Integer>[] Graph;
    static int[] Target;
    static int[] Parent;
    static boolean[] Visit;
    static int N, Idx = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        Graph = new ArrayList[N+1];
        Visit = new boolean[N+1];
        Parent = new int[N+1];
        Target = new int[N];

        // Arraylist 배열 초기화
        for(int i=1; i<N+1; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N-1; i++){ // 양방향 그래스
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a].add(b);
            Graph[b].add(a);
        }
        // 찾는 답
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Target[i] = Integer.parseInt(st.nextToken());
            if(Target[0] != 1){ // 시작이 1이 아니면 오답
                System.out.println(0); return;
            }
        }

        // BFS
        BFS(1);
        System.out.println(1);
    }

    static void BFS(int st){
        Queue<Integer> q = new LinkedList<>();
        q.add(st);
        Visit[st] = true;

        while (!q.isEmpty()){
            int v = q.poll();
            int cnt = 0;

            for(int next : Graph[v]){
                if(!Visit[next]){
                    Visit[next] = true;
                    cnt++;
                }
            }

            for(int i=0; i<cnt; i++){
                int next = Target[Idx++];

                if(!Visit[next]){
                    System.out.println(0);
                    System.exit(0);
                } else {
                    q.add(next);
                }
            }
        }

    }

}
