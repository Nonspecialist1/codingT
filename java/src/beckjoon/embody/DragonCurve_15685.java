package beckjoon.embody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DragonCurve_15685 {

    static boolean[][] Visited = new boolean[102][102];
    private static int Answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int t = 0; t < N; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            addDir(r, c, d, g);
        }

        checkVisited();
        System.out.println(Answer);
    }

    private static void addDir(int r, int c, int d, int g){
        ArrayList<Integer> dirList = new ArrayList<>();
        dirList.add(d);

        for(int i=1; i<=g; i++){
            for(int j= dirList.size()-1; j>=0; j--){
                dirList.add((dirList.get(j) + 1) % 4);
            }
        }

        drawLine(r, c, dirList);
    }

    public static int[] dR = {0, -1, 0, 1};
    public static int[] dC = {1, 0, -1, 0};

    private static void drawLine(int r, int c, ArrayList<Integer> dirList){
        Visited[r][c] = true;

        for(int dir : dirList){
            int nr = r + dR[dir];
            int nc = c + dC[dir];

            Visited[nr][nc] = true;

            r = nr;
            c = nc;
        }
    }

    private static void checkVisited() {
        for(int i = 0; i < 101; i++){
            for(int j = 0; j < 101; j++){
                if(Visited[i][j] && Visited[i+1][j] && Visited[i][j+1] && Visited[i+1][j+1]){
                    Answer++;
                }
            }
        }
    }

}


