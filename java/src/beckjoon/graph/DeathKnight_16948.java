package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DeathKnight_16948 {

    static class Point{
        int r, c, cnt;

        public Point(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int N, R, C;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Visit = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        BFS(sr, sc);
    }

    private static int[] dr = {-2, -2, 0, 0, 2, 2};
    private static int[] dc = {-1, 1, -2, 2, -1, 1};

    private static void BFS(int sr, int sc){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr, sc, 0));
        Visit[sr][sc] = true;

        while (!q.isEmpty()){
            Point p = q.poll();

            for(int d=0; d<6; d++){
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];

                if(!checkWall(nr, nc) && !Visit[nr][nc]){ // 이동이 가능하다면 이동
                    if(nr == R && nc == C){ // 도착한 경우
                        System.out.println(p.cnt + 1);
                        System.exit(0);
                    }

                    Visit[nr][nc] = true;
                    q.add(new Point(nr, nc, p.cnt + 1));
                }
            }
        }
        // 답이 없을 때
        System.out.println(-1);
    }

    private static boolean checkWall(int nr, int nc) {
        if(nr < 0 || nr >= N || nc < 0 || nc >= N) return true;
        return false;
    }
}
