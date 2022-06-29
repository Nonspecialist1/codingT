package beckjoon.dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ShortCut_1446 {

    static int answer = 0;
    static int D;
    static int[] DP;
    static ArrayList<ShortCut> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = sc.nextInt();

        DP = new int[D+1];

        for(int i=0; i<N; i++){
            int st = sc.nextInt(); // 시작점
            int arr = sc.nextInt(); // 도착점
            int dis = sc.nextInt(); // 길이
            // 지름길이 아닌 경우 넘어감
            if(arr - st < dis) continue;
            // 지름길이 도착지점을 지나치는 경우 넘어감
            if(arr > D) continue;

            list.add(new ShortCut(st, arr, dis));
        }

        Collections.sort(list, new Comparator<ShortCut>() {
            @Override
            public int compare(ShortCut o1, ShortCut o2) {
                return o1.start - o2.start; // 시작 위치로 오름차순 정렬
            }
        });

        for(int i=1; i<D+1; i++){
            DP[i] = i; // 정석 길
        }


        int cur = 0;
        int dis = 0;

        for(ShortCut s : list){
            dis += s.start;
            dis += s.distance;
            cur = s.arrival;

            int minus = (s.arrival - s.start) - s.distance;

            DFS(s, cur, dis, minus);
            System.out.println(s);
        }

        System.out.println(DP[D]);
    }

    private static void DFS(ShortCut s, int cur, int dis, int minus) {

        dis += s.distance;
        cur = s.arrival;

        DP[cur] = Math.min(DP[cur], dis);
    }

}

class ShortCut {
    int start = -1;
    int arrival = -1;
    int distance = -1;

    ShortCut(int st, int arr, int dis){
        this.start = st;
        this.arrival = arr;
        this.distance = dis;
    }

    @Override
    public String toString() {
        return "ShortCut{" +
                "start=" + start +
                ", arrival=" + arrival +
                ", distance=" + distance +
                '}';
    }
}
