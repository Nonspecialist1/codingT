package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class KnightMove_7562 {

    static class Point {
        int y, x, cnt;

        Point(int y, int x, int cnt){
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
    }

    static int N, T, stCol, stRow, goalCol, goalRow;
    static boolean[][] Visit;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){
            N = Integer.parseInt(br.readLine());
            Visit = new boolean[N][N];

            st = new StringTokenizer(br.readLine());
            stCol = Integer.parseInt(st.nextToken());
            stRow = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goalCol = Integer.parseInt(st.nextToken());
            goalRow = Integer.parseInt(st.nextToken());

            // 나이트의 이동횟수 찾기
            moveCnt();
        }
    }

    // 나이트의 이동 방향 방향
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

    private static void moveCnt() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(stCol, stRow, 0));
        Visit[stCol][stRow] = true;

        while(!queue.isEmpty()){
            Point p = queue.poll();

            if(p.y == goalCol && p.x == goalRow){
                System.out.println(p.cnt); break;
            }

            for(int i=0; i<8; i++){
                int newY = p.y + dy[i];
                int newX = p.x + dx[i];
                // 체스판 안인 경우 이동
                if(!checkWall(newY, newX) && !Visit[newY][newX]){
                    Visit[newY][newX] = true;
                    queue.add(new Point(newY, newX, p.cnt + 1));
                }
            }
        }
    }

    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= N) return true;
        return false;
    }

}
