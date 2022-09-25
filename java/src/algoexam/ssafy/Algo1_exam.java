package algoexam.ssafy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo1_exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>(); // 데이터 담을 큐

        int T = sc.nextInt(); // 테스트 케이스
        for(int t=1; t<=T; t++){
            int N = sc.nextInt(); // 데이터 수
            for(int i=0; i<N; i++){
                q.add(sc.nextInt()); // 큐에 자료 담기
            }
            int cnt = 0; // 봉우리 개수

            // 봉우리검사
            int a = q.poll(); // 왼쪽 수
            int b = q.poll(); // 중간 수
            int c = q.peek(); // 오른쪽 수
            while(!q.isEmpty()){
                if(a < b && b >= c){ // 봉우리 일때
                    if(b == c){ // 같은 수가 연속일 때 오른쪽값 다음 순서로 변경
                        q.poll();
                        if(q.isEmpty()) break; // c가 마지막 값일 때 종료
                        c = q.peek();
                    }
                    else { // 봉우리일 때 카운트하고 다음 순서 검사
                        cnt++;

                        a = b;
                        b = c;
                        q.poll();
                        if(q.isEmpty()) break;
                        c = q.peek();
                    }
                }
                else { // 봉우리 없을 때 다음 순서 검사
                    a = b;
                    b = c;
                    q.poll();
                    if(q.isEmpty()) break;
                    c = q.peek();
                }
            }
            System.out.printf("#%d %d", t, cnt);
        }
    }
}
