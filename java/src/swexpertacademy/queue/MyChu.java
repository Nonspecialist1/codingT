package swexpertacademy.queue;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MyChu {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int amount = 20;
        int[][] arr = new int[10][1];
        int i = 1;
        int idx = 0;
        while(amount > 0){
            q.add(i);
            for(int j=0; j<q.size(); j++){
                idx = q.poll();
                arr[idx][0]++; // 사람 번호 , 받은 사탕 수
                amount--;
                if(amount == 0){ i = idx; break; }
                q.add(idx);
            }
            i++;
            sc.next();
            System.out.println("큐에 있는 사람 수 : " + q.size());
            System.out.println("현재 일번이 받은 사탕 수 : " + arr[1][0]);
            System.out.println("현재까지 나눠준 사탕 수 : " + (20 - amount));
            System.out.println("마지막 사탕을 받은사람 : " + i);
        }
    }
}
