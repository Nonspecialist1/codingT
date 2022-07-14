package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class AlgoSpot_1261 {

    static class Point implements Comparable<Point> {
        int x, y, wall;

        Point(int x, int y, int wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }

        @Override
        public int compareTo(Point o) {
            return this.wall - o.wall;
        }
    }

    static int N, M;
    static char[][] Maze;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Maze = new char[N][M];
        Visit = new boolean[N][M];


        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                Maze[i][j] = str.charAt(j);
            }
        }

        BFS();
    }

    // 이동 방향
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void BFS(){
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(0, 0, 0));
        Visit[0][0] = true;

        while (!q.isEmpty()){
            Point p = q.poll();

            // 목적지에 도착한 경우
            if(p.x == N-1 && p.y == M-1){
                System.out.println(p.wall);
                return;
            }

            for(int d=0; d<4; d++){
                int newX = p.x + dx[d];
                int newY = p.y + dy[d];

                if(!checkWall(newX, newY) && !Visit[newX][newY]){ // 배열 안 인경우 이동
                    if(Maze[newX][newY] == '0'){ // 빈방인 경우
                        q.offer(new Point(newX, newY, p.wall));
                    } else {  // 벽인 경우
                        q.offer(new Point(newX, newY, p.wall + 1));
                    }
                    Visit[newX][newY] = true;
                }
            }
        }
    }

    private static boolean checkWall(int newX, int newY) {
        if(newX < 0 || newX >= N || newY < 0 || newY >= M) return true;
        return false;
    }

}
