package kakao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class 여름인턴_2022_2번 {
    // 시간초과 -> 배열 원소 수 많고 값도 10^9 까지로 큼

    public static void main(String[] args) {
        int[] q1 = {1, 1};
        int[] q2 = {1, 5};

        System.out.println(solution(q1, q2));
    }


    static long sum = -1L;
    static long total = 0L;

    static int solution(int[] q1, int[] q2) {
        Queue<Long> que1 = new LinkedList<>();
        Queue<Long> que2 = new LinkedList<>();
        int answer = 0;
        // 값 넣어주기
        total = 0L;
        for(int i=0; i<q1.length; i++){
            que1.add(Long.valueOf(q1[i]));
            que2.add(Long.valueOf(q2[i]));
            total += q1[i] + q2[i];
        }
        // 한 큐에 들어가야할 합
        sum = (total/2);
        // 값 구하기
        if(checkSum(que1) == sum){
            return 0;
        }
        int repeat = que1.size() + que2.size() + 1;
        while (true){
            if(checkSum(que1) > checkSum(que2)){
                long one = que1.poll();
                if(one > sum){
                    return -1;
                }
                que2.add(one);
                answer++;
            } else {
                long two = que2.poll();
                if(two > sum){
                    return -1;
                }
                que1.add(two);
                answer++;
            }

            if(checkSum(que1) == sum){
                break;
            }
            if(answer > repeat){
                return -1;
            }
        }
        return answer == 0 ? -1 : answer;
    }

    private static long checkSum(Queue<Long> que) {
        long sums = 0L;

        Iterator iter = que.iterator();
        while(iter.hasNext()) {
            sums += (long) iter.next();
        }
        return sums;
    }

}
