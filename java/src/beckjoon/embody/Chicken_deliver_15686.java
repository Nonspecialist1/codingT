package beckjoon.embody;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Chicken_deliver_15686 {
    static int N; // 행, 열수
    static int M; // 오픈된 치킨집 수

    static ArrayList<Pos> chicken = new ArrayList<>(); // 치킨집 좌표
    static ArrayList<Pos> home = new ArrayList<>(); // 집 좌표

    static boolean[] Visit;

    static int result = Integer.MAX_VALUE;

    static class Pos {
        int row, col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) home.add(new Pos(i, j));
                else if (n == 2) chicken.add(new Pos(i, j));
            }
        }

        Visit = new boolean[chicken.size()];
        BackTracking(0, 0); // 최단거리 찾기

        System.out.print(result);
    }

    static void BackTracking(int idx, int cnt) {
        if(cnt == M){ // 치킨집 개수가 충족된 경우
            int city_dis = 0; // 도시의 치킨 거리

            for(int i=0; i< home.size(); i++){
                city_dis += getHomeDis(home.get(i));
                if(city_dis >= result) return; // 도시의 치킨 거리가 최솟값이 아니면 반환
            }
            result = city_dis;
            return;
        }

        for(int i=idx; i<chicken.size(); i++){
            if(!Visit[i]){
                Visit[i] = true;
                BackTracking(i+1, cnt+1);
                Visit[i] = false;
            }
        }
    }

    static int getHomeDis(Pos home){
        int home_dis = Integer.MAX_VALUE; // 집의 치킨 거리
        int dis;

        for(int j=0; j< chicken.size(); j++){ // 오픈된 치킨 집만 순회
            if(Visit[j]){
                dis = getDis(home, chicken.get(j));
                if(home_dis > dis) home_dis = dis;
            }
        }

        return home_dis;
    }

    static int getDis(Pos home, Pos chicken) {
        return Math.abs(home.row - chicken.row) + Math.abs(home.col - chicken.col);
    }

}