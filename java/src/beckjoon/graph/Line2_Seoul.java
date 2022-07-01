package beckjoon.graph;

import java.io.*;
import java.util.*;

public class Line2_Seoul {

    static int N;
    static ArrayList<Integer>[] Graph;
    static boolean[] Visit;
    static int[] Distance;
    static boolean Flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        Graph = new ArrayList[N+1];
        Visit = new boolean[N+1];
        Distance = new int[N+1];
        // 그래프 초기화
        for(int i=1; i<=N; i++){
            Graph[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){ // 노선 그리기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Graph[a].add(b); // 양방향
            Graph[b].add(a);
        }

        // 순환선 찾기
        Stack<Integer> stack = new Stack<>();
        stack.add(1); Visit[1] = true;
        DFS(1, stack, 0);
        // 순환선에서 거리 찾기
        for(int i=1; i<=N; i++){
            if(Distance[i] < 0) calDistanc(i, 1);
        }

        String str = "";
        for(int i=1; i<=N; i++){
            if(Distance[i] == -1) bw.write(Distance[i]+1+" ");
            else bw.write(Distance[i]+" ");;
        }
        bw.flush();
        //System.out.println(str);
    }

    private static void calDistanc(int i, int dis) {
        for(int v : Graph[i]){
            if(Distance[v] != 0) continue;

            Distance[v] = dis;
            calDistanc(v, dis+1);
        }

    }

    static void DFS(int st, Stack<Integer> stack, int pre){
        if(Flag) return;

        for(int i : Graph[st]){
            if(Flag) return;

            if(Visit[i]){
                if(i != pre){ // 순환선 찾음
                    while (!stack.isEmpty()){ // 스택에 들어간 순환선 체크
                        int v = stack.pop();
                        Distance[v] = -1;

                        if(v == i) {
                            Flag = true;
                            return;
                        }
                    }
                }
                else { continue; }
            }

            Visit[i] = true;
            stack.add(i);

            DFS(i, stack, st);

            Visit[i] = false;
            stack.removeElement(i);
        }
    }


}
