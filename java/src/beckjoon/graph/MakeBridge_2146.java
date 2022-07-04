package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MakeBridge_2146 {

    static class Point {
        int x; // 행
        int y; // 열
        int dis; // 거리

        Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int N, Min = Integer.MAX_VALUE, Num = 2;
    static int[][] Island;
    static boolean[][] Visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Island = new int[N][N];
        Visit = new boolean[N][N];

        // 섬 지도 그리기
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                Island[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 섬 번호 매기기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(Visit[i][j]) continue;
                if(Island[i][j] == 1) {
                    Island[i][j] = Num;
                    numbering(i, j);
                }
            }
        }

        // 가장 최단거리 찾기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(Island[i][j] > 1) { // 육지라면 탐색 시작
                    Visit = new boolean[N][N]; // 방문 초기화
                    search(i, j, Island[i][j]);
                }
            }
        }
        System.out.println(Min);
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    // 섬의 번호 매기기 2 ~ ?
    public static void numbering(int x, int y){
        Visit[x][y] = true;

        Queue<Point> q = new LinkedList<>();
        Point p = new Point(x, y, 0);
        q.add(p);

        while (!q.isEmpty()){
            p = q.poll();

            for(int d=0; d<4; d++){ // 사방탐색으로 바다 찾기
                int newX = p.x + dx[d];
                int newY = p.y + dy[d];

                if(!checkWall(newX, newY) && !Visit[newX][newY] && Island[newX][newY] == 1){ // 같은 섬인경우
                    Visit[newX][newY] = true;
                    Island[newX][newY] = Num;
                    q.add(new Point(newX, newY, 0));
                }
            }
        }
        Num++;
    }
    // 최단 거리 찾기
    public static void search(int x, int y, int num){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, 0));
        Visit[x][y] = true;

        while (!q.isEmpty()){
            Point p = q.poll();
            if(p.dis >= Min) break;

            for(int d=0; d<4; d++){ // 사방탐색으로 바다 찾기
                int newX = p.x + dx[d];
                int newY = p.y + dy[d];

                if(!checkWall(newX, newY) && !Visit[newX][newY] && Island[newX][newY] != num){ // 바다인 경우 이동
                    Visit[newX][newY] = true;

                    if(Island[newX][newY] == 0){ // 바다인 경우
                        q.add(new Point(newX, newY, p.dis + 1));
                    } else { // 다른섬인 경우
                        Min = Math.min(p.dis, Min);
                        return;
                    }
                }
            }
        }

    }

    public static boolean checkWall(int newX, int newY){
        if(newX < 0 || newX >= N || newY < 0 || newY >= N) return true;
        return false;
    }
}
