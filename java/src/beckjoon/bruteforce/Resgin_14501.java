package beckjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Resgin_14501 {

    static class Counsel {
        int day;
        int profit;

        Counsel(int day, int profit){
            this.day = day;
            this.profit = profit;
        }
    }

    static int N, Profit = -1;;
    static Counsel[] schedule;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        schedule = new Counsel[N];
        DP = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            schedule[i] = new Counsel(a, b);
        }

        for(int i=0; i<N; i++){
            int nextDay = i + schedule[i].day;

            if(nextDay <= N){
                DP[i] += schedule[i].profit;

                for(int j=nextDay; j<N; j++){
                    DP[j] = Math.max(DP[i], DP[j]);
                }
            }

            if(DP[i] > Profit) Profit = DP[i];
        }

        System.out.println(Profit);
    }
}
