package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideGame_13549 {

    static class Point{
        int p;
        int cnt;

        Point(int p, int cnt){
            this.p = p;
            this.cnt = cnt;
        }
    }

    static int N, K, Min = Integer.MAX_VALUE;
    static boolean[] Visit = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
        }
        else if(N == K){
            System.out.println(0);
        }
        else {
            BFS(N);
            System.out.println(Min);
        }
    }

    static void BFS(int st){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(st, 0));

        while (!q.isEmpty()){
            Point p = q.poll();
            Visit[p.p] = true;

            if(p.p == K){ // 동생을 찾은 경우
                Min = Math.min(Min, p.cnt);
            }
            // 연산의 순서가 중요
            if(p.p + 1 <= 100000 && !Visit[p.p + 1]) {
                q.add(new Point(p.p + 1, p.cnt + 1));
            }

            if(p.p * 2 <= 100000 && !Visit[p.p * 2]) {
                q.add(new Point(p.p * 2, p.cnt));
            }

            if(p.p - 1 >= 0 && !Visit[p.p - 1]) {
                q.add(new Point(p.p - 1, p.cnt + 1));
            }
        }
    }

}
