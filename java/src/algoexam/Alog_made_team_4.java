package algoexam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alog_made_team_4 {

    static int N;
    static int[] dx = { -1, -1, 1, 1 };
    static int[] dy = { 1, -1, -1, 1 };
    static Planet[] pArr;
    static int[] distList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            pArr = new Planet[M];
            int sunX = N / 2;
            int sunY = N / 2;
            distList = new int[M];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int dist = Math.abs(sunX - x) + Math.abs(sunY - y);
                distList[i] = dist * 4;
                int dir = getDir(x, y);
                pArr[i] = new Planet(x, y, dist, dir);
            }
            // 각 공전 주기 최소공배수 구하기
            int min = getLCM();
            int time = 0;
            while (true) {
                // 각 주기의 최소공배수 넘을 때까지 평행 못하면 -1 리턴
                if (time >= min) {
                    time = -1;
                    break;
                }
                time++;
                for (int i = 0; i < pArr.length; i++) {
                    pArr[i].x += dx[pArr[i].dir];
                    pArr[i].y += dy[pArr[i].dir];
                    pArr[i].dir = getDir(pArr[i].x, pArr[i].y);
                }
                if (check(pArr)) {
                    break;
                }
            }
            sb.append("#"+tc+" "+time+"\n");

        }

        System.out.println(sb.toString());
    }
    private static int getDir(int x, int y) {
        // 4사분면
        if (x > N / 2 && y >= N / 2) {
            return 0;
            // 1사분면
        } else if (x <= N / 2 && y > N / 2) {
            return 1;
            // 2사분면
        } else if (x < N / 2 && y <= N / 2) {
            return 2;
            // 3사분면
        } else {
            return 3;
        }
    }
    public static int getLCM() {
        if (distList.length == 1) {
            return distList[0];
        }
        int gcd = getGCD(distList[0], distList[1]);
        int lcm = (distList[0] * distList[1]) / gcd;
        for (int i = 2; i < distList.length; i++) {
            gcd = getGCD(lcm, distList[i]);
            lcm = (lcm * distList[i]) / gcd;
        }
        return lcm;
    }
    public static int getGCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        return getGCD(num2, num1 % num2);
    }
    private static boolean check(Planet[] arr) {
        // 가로 평행인지
        boolean rowCheck = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].x != N / 2) {
                rowCheck = false;
                break;
            }
        }
        // 세로 평행인지
        boolean colCheck = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].y != N / 2) {
                colCheck = false;
                break;
            }
        }
        boolean crossCheck = false;
        // 대각선 평행인지
        if ((arr[0].y - N / 2) != 0) {
            crossCheck = true;
            double flag = (arr[0].x - N / 2) / (double) (arr[0].y - N / 2);
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i].y - N / 2) == 0) {
                    crossCheck = false;
                    break;
                }
                if ((arr[i].x - N / 2) / (double) (arr[i].y - N / 2) != flag) {
                    crossCheck = false;
                    break;
                }
            }
        }
        return rowCheck || colCheck || crossCheck;
    }
}

class Planet {
    int x = -1;
    int y = -1;
    int dist = 0;
    int dir = -1;
    public Planet(int x, int y, int dist, int dir) {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.dir = dir;
    }
}