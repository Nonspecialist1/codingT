package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSort_1715 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        PriorityQueue<Long> PQ = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            PQ.add(Long.parseLong(br.readLine()));
        }

        long total = 0;

        while(PQ.size() > 1){ // 1개 남을 때 까지
            long fir = PQ.poll();
            long sec = PQ.poll();

            total += fir + sec;
            PQ.add(fir + sec);
        }

        System.out.println(total);
    }


}
