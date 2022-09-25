package beckjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MeetingRoom_1931 {

    static class Meeting implements Comparable<Meeting> {
        int st, end;

        public Meeting(int st, int end){
            this.st = st;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end){ return this.st - o.st; }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Meeting[] meet = new Meeting[N];

        // 회의 시간 받기
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meet[i] = new Meeting(start, end);
        }

        Arrays.sort(meet);

        int max = 1;
        int pre_time = meet[0].end;

        for(int i=1; i<N; i++){
            Meeting m = meet[i];

            if(pre_time <= m.st){
                pre_time = m.end;
                max++;
            }
        }

        System.out.println(max);
    }



}
