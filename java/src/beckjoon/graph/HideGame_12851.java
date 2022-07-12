package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideGame_12851 {

    static class Point{
        int p;
        int cnt;

        Point(int p, int cnt){
            this.p = p;
            this.cnt = cnt;
        }
    }

    static int N, K, Cnt, Min = Integer.MAX_VALUE;
    static boolean[] Visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
            System.out.println(1);
        }
        else if(N == K){
            System.out.println(0);
            System.out.println(1);
        }
        else {
            BFS(N);
            System.out.println(Min);
            System.out.println(Cnt);
        }
    }

    static void BFS(int st){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(st, 0));

        while (!q.isEmpty()){
            Point p = q.poll();
            Visit[p.p] = true;

            if(p.p == K){ // 동생을 찾은 경우
                if(p.cnt < Min) {
                    Min = p.cnt;
                    Cnt = 1;
                }
                else if(p.cnt == Min){
                    Cnt++;
                }
            }

            // 연산의 순서가 중요
            if(p.p * 2 <= 100000 && !Visit[p.p * 2]) {
                q.add(new Point(p.p * 2, p.cnt + 1));
            }

            if(p.p + 1 <= 100000 && !Visit[p.p + 1]) {
                q.add(new Point(p.p + 1, p.cnt + 1));
            }

            if(p.p - 1 >= 0 && !Visit[p.p - 1]) {
                q.add(new Point(p.p - 1, p.cnt + 1));
            }
        }
    }

}
