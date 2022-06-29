package algoexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Alog_made_team_sec {
    // 시계 방향
    // 0, 1, 2, 3, 4 분면
    static int[] dy = { 0, -1, 1, 1, -1 };
    static int[] dx = { 0, 1, 1, -1, -1 };
    static int N;
    static int M;
    static int[][] map; // 행성계 지도
    static int[][] pos; // 행성들의 좌표

    static void move() {
        for (int i = 0; i < M; i++) {
            int x = pos[i][0];
            int y = pos[i][1];
            int idx = -1;
            // 태양을 기준으로 몇 사분면에 위치하는지 찾는다.
            // 1사분면
            if (x < N / 2 && y <= N / 2) {
                idx = 1;
            } else if (x >= N / 2 && y < N / 2) {
                idx = 2;
            } else if (x > N / 2 && y >= N / 2) {
                idx = 3;
            } else if (x <= N / 2 && y > N / 2) {
                idx = 4;
            }
            // 기존 위치 제거
            map[y][x] = 0;
            // 좌표 이동
            x += dx[idx];
            y += dy[idx];
            // 좌표 반영
            map[y][x] = i + 1;
            pos[i][0] = x;
            pos[i][1] = y;
        }
    }
    static void print() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/test.txt"));
        Scanner sc = new Scanner(System.in);
//		int T;
//		T = sc.nextInt();
//
//		for (int test_case = 1; test_case <= T; test_case++) {
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][N];
        pos = new int[M][2];
        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            pos[i][0] = x;
            pos[i][1] = y;
            map[y][x] = i + 1;
        }
        System.out.println("초기 위치");
        print();

        for (int i = 0; i < 7; i++) {
            System.out.println(i + "번 이동");
            move();
            print();
        }
        System.out.println(N + " " + M);
        for (int i = 0; i < M; i++) {
            System.out.println(pos[i][0] + " " + pos[i][1]);
        }
    }

}