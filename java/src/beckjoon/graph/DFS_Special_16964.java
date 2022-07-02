package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS_Special_16964 {
    static ArrayList<Integer>[] Graph;
    static int[] Target;
    static int[] Parent;
    static boolean[] Visit;
    static int N;

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
        }

        if(Target[0] != 1){ // 시작이 1이 아니면 오답
            System.out.println(0);
            System.exit(0);
        }
        // DFS
        DFS(1, 1);
        System.out.println(1);
    }

    static void DFS(int cur, int idx){
        Visit[cur] = true;

        int cnt = 0;
        for(int next : Graph[cur]){
            if(!Visit[next]){
                Visit[next] = true;
                Parent[next] = cur; // 부모 설정
                cnt++;
            }
        }

        if(cnt > 0){
            int next = Target[idx];
            if(Parent[next] != cur){
                System.out.println(0);
                System.exit(0);
            }
            DFS(next, idx+1);
        }

    }




}
