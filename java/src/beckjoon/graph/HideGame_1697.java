package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideGame_1697 {

    static class Point{
        int p;
        int cnt;

        Point(int p, int cnt, int v){
            this.p = p;
            this.cnt = cnt;
        }
    }

    static int N, K;
    static boolean[] Visit = new boolean[100001];
    static int[] Parent = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
            StringBuilder sb = new StringBuilder();
            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
        else if(N == K){
            System.out.println(0);
            System.out.println(N + " ");
        }
        else BFS(N);
    }

    static void BFS(int st){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(st, 0, st));

        while (!q.isEmpty()){
            Point p = q.poll();

            if(p.p == K){ // 동생을 찾은 경우
                System.out.println(p.cnt);
                // 경로 찾기
                Stack<Integer> stack = new Stack<>();
                int idx = K;
                while (idx != N){
                    stack.push(idx);
                    idx = Parent[idx];
                }
                stack.push(idx);

                while (!stack.isEmpty()){
                    System.out.print(stack.pop() + " ");
                }

                System.exit(0);
            }

            if(p.p - 1 >= 0 && !Visit[p.p - 1]) {
                q.add(new Point(p.p - 1, p.cnt + 1, p.p - 1));
                Parent[p.p - 1] = p.p;
                Visit[p.p - 1] = true;
            }
            if(p.p + 1 <= 100000 && !Visit[p.p + 1]) {
                q.add(new Point(p.p + 1, p.cnt + 1, p.p + 1));
                Parent[p.p + 1] = p.p;
                Visit[p.p + 1] = true;
            }
            if(p.p * 2 <= 100000 && !Visit[p.p * 2]) {
                q.add(new Point(p.p * 2, p.cnt + 1, p.p * 2));
                Parent[p.p * 2] = p.p;
                Visit[p.p * 2] = true;
            }
        }
    }

}
