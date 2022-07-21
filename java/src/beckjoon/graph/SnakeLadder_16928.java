package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SnakeLadder_16928 {

    static class Point {
        int v, cnt;

        public Point(int v, int cnt){
            this.v = v;
            this.cnt = cnt;
        }
    }

    static int[] Board = new int[101]; // [N][0] 값이 있으면 사다리 or 뱀
    static boolean[] Visit = new boolean[101]; // 방문한 위치, 재 방문도 가능은하지...?
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N+M; i++){ // 사다리의 수
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            Board[from] = to;
        }

        // 완성된 게임판 돌기
        BFS();
    }

    private static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(1, 0));
        Visit[1] = true;

        while (!q.isEmpty()){
            Point p = q.poll();

            for(int i=1; i<7; i++){ // 주사위 수 정하기
                int nv = p.v + i;

                if(nv > 100) break;
                if(Visit[nv]) continue;
                Visit[nv] = true;

                if(nv == 100){ // 도착했다면
                    System.out.println(p.cnt + 1);
                    return;
                }

                if(Board[nv] != 0){ // 도착한 칸에서 워프하는 경우
                    q.add(new Point(Board[nv], p.cnt + 1));
                }
                else {
                    q.add(new Point(nv, p.cnt + 1));
                }
            }
        }

    }

}
