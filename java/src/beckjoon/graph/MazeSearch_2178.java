package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MazeSearch_2178 {

    static class Point {
        int y, x, cnt;

        Point(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int N, M;
    static char[][] Maze;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Maze = new char[N][M];
        Visit = new boolean[N][M];

        for(int i=0; i<N; i++){
            String ch = br.readLine();
            for(int j=0; j<M; j++){
                Maze[i][j] = ch.charAt(j);
            }
        }

        solve();
    }

    // 이동 방향
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void solve(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, 1));
        Visit[0][0] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.y == N-1 && p.x == M-1){ // 도착지점인 경우
                System.out.println(p.cnt);
                break;
            }

            for(int d=0; d<4; d++){
                int newY = p.y + dy[d];
                int newX = p.x + dx[d];
                if(!checkWall(newY, newX) && !Visit[newY][newX] && Maze[newY][newX] == '1'){
                    Visit[newY][newX] = true;
                    q.add(new Point(newY, newX, p.cnt + 1));
                }
            }
        }
    }

    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= M) return true;
        return false;
    }
}
