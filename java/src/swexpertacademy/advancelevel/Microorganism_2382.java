package swexpertacademy.advancelevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Microorganism_2382 {
    static class Micro implements Comparable<Micro>{
        int row, col, cnt, dir;

        public Micro(int row, int col, int cnt, int dir) {
            this.row = row;
            this.col = col;
            this.cnt = cnt;
            this.dir = dir;
        }

        // 음수가 나오면 그대로, 1이상 양수가 나오면 교환
        @Override
        public int compareTo(Micro o) {
            return o.cnt - this.cnt; // 내림차순, 최대힙
        }
    }
    static int N, M, K;
    static Micro map[][];
    static int[] dr = {0, -1, 1, 0, 0}; // 0번째 무시하고 상-하-좌-우
    static int[] dc = {0, 0, 0, -1, 1};
    static PriorityQueue<Micro> priorityQ;

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T_case = Integer.valueOf(br.readLine());

        for(int T=1; T<=T_case; T++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());
            K = Integer.valueOf(st.nextToken());
            map = new Micro[N][N];
            priorityQ = new PriorityQueue<>();

            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                // 프라이어티 큐 타입 자료구조이므로 자동으로 최대힙이 된다
                priorityQ.add(new Micro(Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken()), Integer.valueOf(st.nextToken())));
            }
            System.out.println("#"+T+" "+move());
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static int move() { // 주어진 M 시간 동안 이동
        int time = M;
        int nextR, nextC, remainCnt = 0;

        while(time-->0){
            // 군집리스트 모두 이동 처리
            Micro m;
            while(!priorityQ.isEmpty()){
                m = priorityQ.poll();

                nextR = m.row + dr[m.dir];
                nextC = m.col + dc[m.dir];
                // 가장자리 약품을 만날 시
                if(nextR == 0 || nextR == N-1 || nextC == 0 || nextC == N-1){
                    if( (m.cnt = m.cnt/2) == 0 ) continue; // 크기가 0이 되면 소멸
                    // 소멸 아닐시 반대로 리턴
                    if(m.dir % 2 == 1) m.dir++;
                    else m.dir--;
                }
                // 가장자리가 아니고 이동하려는 칸이 빈 경우
                if(map[nextR][nextC] == null){
                    m.row = nextR;
                    m.col = nextC;
                    map[nextR][nextC] = m;
                } else { // 이동하려는 자리가 이미 채워져 있는 경우
                    map[nextR][nextC].cnt += m.cnt;
                }
            }
            // 1시간 처리
            remainCnt = reset();
        }
        return remainCnt;
    }

    private static int reset() { // 매시간 마다 정리
        int total = 0;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j] != null){
                    priorityQ.offer(map[i][j]);
                    total += map[i][j].cnt; // 살아있는 미생물 군집의 크기 누적
                    map[i][j] = null;
                }
            }
        }
        return total;
    }

}
