package swexpertacademy.advancelevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class LunchTime_2383 {

    static class Person implements Comparable<Person> {
        int r, c, downCnt, status, time; // 행, 열, 내려가고있는 계단수, 현재 상태, 입구까지 도착시간

        public Person(int r, int c) {
            super();
            this.r = r;
            this.c = c;
        }
        public void init() {
            time = downCnt = 0;
            status = M;
        }

        @Override
        public int compareTo(Person o) {
            return this.time - o.time; // 계단 입구까지 소요되는 시간이 빠른 순서로
        }
    }
    static final int M=1, W=2, D=3, C=4; // move, wait, down, complete
    static int N, min, cnt; // 한 변의 길이, 모두 계단을 내려가는 최소시간, 사람수
    static boolean[] selected; // 부분집합 구현에서 사용할 선택배열(선택되면 계단 1, 안되면 계단 2)
    static ArrayList<Person> pList; // 사람 리스트
    static int[][] sList; // 계단 리스트

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T_case = Integer.valueOf(br.readLine());

        for(int T=1; T<=T_case; T++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = null;

            pList = new ArrayList<Person>();
            sList = new int[2][];
            min = Integer.MAX_VALUE;

            for(int i=0, k=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    int c = Integer.parseInt(st.nextToken());
                    if(c==1) pList.add(new Person(i,j)); // 사람일 때
                    else if(c>1) sList[k++] = new int[] {i,j,c}; // 계단이면
                }
            }
            cnt = pList.size(); // 사람 수
            selected = new boolean[cnt];

            divide(0); // 계단 배정하기
            System.out.println("#"+T+" "+min);
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    private static void divide(int idx) { // 부분집합을 이용해서 계단 배정, idx : 처리할 사람의 인덱스
        if(idx == cnt) {
            makeList();
            return;
        }
        // 부분집합에 포함 : 계단 1 배정
        selected[idx] = true;
        divide(idx+1);
        // 부분집합 미포함 : 계단 2 배정
        selected[idx] = false;
        divide(idx+1);
    }

    private static void makeList() { // selected 상태에 따라 두계단을 이용하는 각각의 리스트 생성
        ArrayList<Person> aList = new ArrayList<>();
        ArrayList<Person> bList = new ArrayList<>();

        for(int i=0; i<cnt; i++){
            Person p = pList.get(i);
            p.init(); // 도착 시간, downCnt, 현재 상태 초기화
            if(selected[i]){
                p.time = Math.abs(p.r - sList[0][0]) + Math.abs(p.c - sList[0][1]);
                aList.add(p);
            }
            else {
                p.time = Math.abs(p.r - sList[1][0]) + Math.abs(p.c - sList[1][1]);
                bList.add(p);
            }
        }

        int res = go(aList, bList); // 2 계단 리스트의 사람들이 모두 내려가는데 소요되는 시간
        if(min > res) min = res;
    }

    private static int go(ArrayList<Person> aList, ArrayList<Person> bList) {
        int timeA = 0, timeB = 0;
        if(aList.size() > 0) timeA = goDown(aList, sList[0][2]);
        if(bList.size() > 0) timeB = goDown(bList, sList[1][2]);
        return timeA > timeB ? timeA : timeB;
    }

    private static int goDown(ArrayList<Person> list, int height) {
        Collections.sort(list); // 계단 입구까지 도착하는데 소요되는 시간이 빠른 순으로 정렬

        int time = list.get(0).time; // 흘러가는 시간, 첫번째 사람의 계답 입구 도착시간부터 처리
        int size = list.size();
        int ingCnt = 0, cCnt = 0; // 내려가고있는 사람 수, 다 내려간 사람 수

        while(true) { // 이 부분 DP로 짤 수 있음, A형 시험은 꼭 DP가 필요한 문제는 나오지 않음
            // 매 시간마다 사람들을 하나씩 꺼내어 상태 처리
            for(int i=0; i<size; i++){
                Person p = list.get(i);
                if(p.status == C) continue;

                if(p.time == time) { // 현재 시간이 사람의 계단입구 도착시간과 같으면
                    p.status = W;
                }
                else if(p.status == W && ingCnt < 3){ // 기다리는 사람 + 내려가는 중인 사람 3명 이하일 때
                    p.status = D;
                    p.downCnt = 1; // 계단수 1부터 출발
                    ++ingCnt; // 내려가는 사람 수 증가
                }
                else if(p.status == D){ // 내려가는 중인 사람
                    if(p.downCnt < height){ // 다 내려가지 못한 사람
                        p.downCnt++;
                    } else { // 다 내려간 사람
                        p.status = C;
                        ++cCnt;
                        --ingCnt;
                    }
                }
            }
            if(cCnt == size) break;

            ++time;
        }
        return time;
    }


}
