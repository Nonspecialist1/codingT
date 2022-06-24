package beckjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Tomato_7576 {

    static class Point {
        int y, x;

        Point(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    static int M, N, Day = 0;
    static int[][] Box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Box = new int[N][M];

        Queue<Point> q = new LinkedList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                Box[i][j] = Integer.parseInt(st.nextToken());
                if(Box[i][j] == 1) q.add(new Point(i, j)); // 익은 토마토 위치 저장
            }
        }
        // 익은 토마토 주변 모두 익히기
        if(!q.isEmpty()) solve(q);
        // 안 익은 토마토 검사
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(Box[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(Day);
    }

    // 이동 방향
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    private static void solve(Queue<Point> qu) {
        Queue<Point> queue = new LinkedList<>();

        while (!qu.isEmpty()) { // 처음 익은 토마토들의 수 만큼
            Point p = qu.poll();

            for (int d = 0; d < 4; d++) { // 4방 탐색
                int newY = p.y + dy[d];
                int newX = p.x + dx[d];
                // 박스 안에서 안 익은 토마토일 때
                if (!checkWall(newY, newX) && Box[newY][newX] == 0) {
                    Box[newY][newX] = 1;
                    queue.add(new Point(newY, newX));
                }
            }
        }

        if(!queue.isEmpty()) {
            Day++;
            solve(queue);
        }
    }

    private static boolean checkWall(int newY, int newX) {
        if(newY < 0 || newY >= N || newX < 0 || newX >= M) return true;
        return false;
    }
}
