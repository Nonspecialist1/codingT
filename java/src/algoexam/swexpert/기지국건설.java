package algoexam.swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class 기지국건설
{
    static class Cell {
        int h, w, v;

        Cell(int h, int w, int v){
            this.h = h;
            this.w = w;
            this.v = v;
        }
    }

    static int T, W, H, Max;
    static int[][] Cells;
    static boolean[][] Visit;

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            Max = Integer.MIN_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            Cells = new int[H][W];
            Visit = new boolean[H][W];

            for(int i=0; i<H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<W; j++){
                    Cells[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++){
                    findMax(new Cell(i, j, Cells[i][j]), Cells[i][j], 1);
                }
            }

            System.out.println("#" + t + " " + Max);;
        }
    }

    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    static void findMax(Cell c, int sum, int cnt){
        if(Visit[c.h][c.w]) return;
        Visit[c.h][c.w] = true;

        if(cnt == 4){ // 4번째 기지국이 완성되었을 때
            if(Max < sum) Max = sum;
            return;
        }

        for(int i=0; i<8; i++){
            int newX = c.h + dx[i];
            int newY = c.w + dy[i];

            if(!checkWall(newX, newY) && !Visit[newX][newY]){
                findMax(new Cell(newX, newY, Cells[newX][newY]), sum + Cells[newX][newY], cnt+1);
            }
        }
    }

    static boolean checkWall(int h, int w){
        if(h < 0 || h >= H || w < 0 || w >= W) return true;
        else return false;
    }

}