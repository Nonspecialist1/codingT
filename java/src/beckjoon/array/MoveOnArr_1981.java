package beckjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MoveOnArr_1981 {

    static class Point {
        int x, y;
        int min;
        int max;

        Point(int x, int y, int min, int max){
            this.x = x;
            this.y = y;
            this.min = min;
            this.max = max;
        }
    }


    static int N, Answer = 201;
    static int[][] Arr;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Visit = new boolean[N][N];
        Arr = new int[N][N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                Arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS();
        System.out.println(Answer);
    }

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static void BFS(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0, 0, Arr[0][0], Arr[0][0]));
        Visit[0][0] = true;

        while (!q.isEmpty()){
            Point p = q.poll();
            Visit[p.x][p.y] = true;

            // 도착했을 때
            if(p.x == N-1 && p.y == N-1){
                int ans = p.max - p.min;
                if(Answer > ans) Answer = ans;
            }

            for(int d=0; d<4; d++){
                int min = p.min;
                int max = p.max;

                int nx = p.x + dx[d];
                int ny = p.y + dy[d];

                if(!checkWall(nx, ny) && !Visit[nx][ny]){
                    if(min > Arr[nx][ny]){
                        min = Arr[nx][ny];
                    }

                    if(max < Arr[nx][ny]){
                        max = Arr[nx][ny];
                    }

                    q.add(new Point(nx, ny, min, max));
                }
            }
        }


    }

    static boolean checkWall(int ny, int nx){
        if(ny < 0 || nx < 0 || ny >= N || nx >=N) return true;
        return false;
    }
}
