package swexpertacademy.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maze_1226 {
    static int[][] maze;
    static int sx, sy;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        for(int T=1; T<=10; T++) {
            sc.nextInt();
            maze = new int[16][16];
            for(int i=0; i<16; i++){
                String s = sc.next();
                for(int j=0; j<16; j++){
                    String c = String.valueOf(s.charAt(j));
                    maze[i][j] = Integer.parseInt(c);
                    if(maze[i][j] == 2){ sx = i; sy = j;}
                }
            }
            System.out.print("#"+T+" ");
            solve();
        }
    }
    // 하 - 우 - 상 - 좌
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static void solve(){
        Queue<Integer> q = new LinkedList<>();
        q.add(sx); // 행
        q.add(sy); // 열
        while(!q.isEmpty()){
            int x = q.poll(); // 행
            int y = q.poll(); // 열
            for(int i=0; i<4; i++){ // 사방 검색
                int newX = x + dx[i];
                int newY = y + dy[i];
                if(maze[newX][newY] != 1) // 길이 있을 때
                {
                    if(maze[newX][newY] == 3){ System.out.println(1); return; }
                    maze[newX][newY] = 1; // 지나온 길 지우기
                    q.add(newX);
                    q.add(newY);
                }
            }
        }
        System.out.println(0);
    }

}
