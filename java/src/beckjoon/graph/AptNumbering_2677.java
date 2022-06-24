package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AptNumbering_2677 {

    static class Point {
        int y, x;

        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int N;
    static char[][] Maze;
    static boolean[][] Visit;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Maze = new char[N][N];
        Visit = new boolean[N][N];

        for(int i=0; i<N; i++){
            String ch = br.readLine();
            for(int j=0; j<N; j++){
                Maze[i][j] = ch.charAt(j);
            }
        }
        // 첫번째 단지 부터 시작
        int total = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(Maze[i][j] == '1' && !Visit[i][j]){
                    Visit[i][j] = true;
                    solve(new Point(i, j));
                    total++;
                }
            }
        }
        Collections.sort(list);
        System.out.println(total);
        for(int i : list){
            System.out.println(i);
        }
    }

    // 이동 방향
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void solve(Point st){
        Queue<Point> q = new LinkedList<>();
        q.add(st);
        int cnt = 1;

        while(!q.isEmpty()){
            Point p = q.poll();

            for(int d=0; d<4; d++){
                int newY = p.y + dy[d];
                int newX = p.x + dx[d];
                if(!checkWall(newY, newX) && !Visit[newY][newX] && Maze[newY][newX] == '1'){
                    Visit[newY][newX] = true;
                    q.add(new Point(newY, newX));
                    cnt++;
                }
            }
        }

        list.add(cnt);
    }

    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= N) return true;
        return false;
    }
}
