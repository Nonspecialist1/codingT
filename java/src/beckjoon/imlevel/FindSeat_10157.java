package beckjoon.imlevel;

import java.util.Scanner;

public class FindSeat_10157 {
    static int x;
    static int y;
    static int full;
    static int ans;
    static int[][] seat;
    static int cnt;
    static int ansY;
    static int ansX;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        full = x*y;
        ans = sc.nextInt();
        if(ans == 1){ System.out.println(1 + " " + 1); return; }
        if(ans > full){ System.out.println(0); return; }

        seat = new int[x][y];
        seat[0][0] = 1;
        cnt = 2;
        FindSeat();

        System.out.printf("%d %d", ansX, ansY);
    }

    static int[] dx = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] dy = {1, 0, -1, 0};
    static int d = 0;
    static int sx = 0;
    static int sy = 0;

    static void FindSeat(){
        while(true){
            d %= 4;
            int newX = sx + dx[d];
            int newY = sy + dy[d];
            if(!checkWall(newX, newY)){
                seat[newX][newY] = cnt;
                if(cnt == ans){
                    ansY = newY + 1;
                    ansX = newX + 1;
                    break;
                }
                sx = newX;
                sy = newY;
                cnt++;
            }
            else d++;
        }
    }

    static boolean checkWall(int nx, int ny){
        if(ny < 0 || nx < 0 || ny >= y || nx >= x || seat[nx][ny] != 0) return true;
        return false;
    }


}
