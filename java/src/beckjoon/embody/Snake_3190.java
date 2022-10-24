package beckjoon.embody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Snake_3190 {

    private static class Point {
        int x, y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int N, Idx = 0, Sec = 0;
    // 오른쪽 - 아래 - 왼쪽 - 위쪽
    // D는 +1, L은 -1
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static int[][] Board;
    static char[] Dir = new char[10001];
    static ArrayList<Point> Snake = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        Board = new int[N+1][N+1];

        int k = Integer.parseInt(br.readLine());
        for(int i=0; i<k; i++){ // 사과 자리
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Board[x][y] = 1;
        }

        int L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String c = st.nextToken();

            Dir[x] = c.charAt(0);
        }

        Snake.add(new Point(1, 1));
        System.out.println(solve());
    }

    private static int solve(){
        int x = 1;
        int y = 1;

        while(true){
            Sec++;
            int newX = x + dx[Idx];
            int newY = y + dy[Idx];
            // 벽에 박거나 몸에 부딪힐 때까지 이동
            if(isWall(newX, newY) || isSnakeBody(newX, newY)){
                return Sec;
            }
            else if(Board[newX][newY] == 1) { // 사과가 있는 경우
                Board[newX][newY] = 0;
                Snake.add(new Point(newX, newY));
            }
            else { // 사과가 없는 경우
                Snake.add(new Point(newX, newY));
                Snake.remove(0);
            }

            // 방향 이동이 필요한 경우
            if(Dir[Sec] == 'L'){
                Idx--;
                if(Idx == -1) Idx = 3;
            }
            else if(Dir[Sec] == 'D') {
                Idx++;
                if (Idx == 4) Idx = 0;
            }
            // 이전 위치 기억
            x = newX; y = newY;
        }
    }

    private static boolean isWall(int nx, int ny){
        if(nx < 1 || nx > N || ny < 1 || ny > N) return true;
        else return false;
    }

    private static boolean isSnakeBody(int nx, int ny){
        for(Point p : Snake){
            if(p.x == nx && p.y == ny) return true;
        }
        return false;
    }
}
