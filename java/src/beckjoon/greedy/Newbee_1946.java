package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Newbee_1946 {

    static int T, N;
    static int[] Rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.valueOf(br.readLine());

        while(T-->0){ // T번 반복
            N = Integer.valueOf(br.readLine());
            Rank = new int[N+1];
            StringTokenizer st;

            for(int i=0; i<N; i++){ // 지원자의 등수 매기기
                st = new StringTokenizer(br.readLine());
                int fir = Integer.parseInt(st.nextToken());
                int sec = Integer.parseInt(st.nextToken());

                Rank[fir] = sec;
            }

            System.out.println(getMax());
        }
    }

    private static int getMax(){
        int max = 1;
        int sec = Rank[1];

        for(int i=2; i<=N; i++){
            if(Rank[i] < sec){
                sec = Rank[i];
                max++;
            }
        }

        return max;
    }

}
