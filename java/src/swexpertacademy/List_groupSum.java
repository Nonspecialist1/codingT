package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class List_groupSum {
    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
           st = new StringTokenizer(br.readLine());
           int N = Integer.parseInt(st.nextToken());
           int M = Integer.parseInt(st.nextToken());
           st = new StringTokenizer(br.readLine());
           int[] arr = new int[N];
           for(int j=0; j<N; j++){
               arr[j] = Integer.parseInt(st.nextToken());
           }
           int total = 0;
           int max = 0;
           int min = 0;
           for(int j=0; j<N; j++){
               if(j < M){
                   total += arr[j];
                   min = total; // 첫번째 집합값
                   max = total; // 첫번째 집합값
               }
               else {
                   total += arr[j]; // 앞으로 진행
                   int curTotal = total - arr[j-M]; // 현재값
                   if(curTotal > max){
                       max = curTotal;
                   }
                   if(curTotal < min){
                       min = curTotal;
                   }
                   total = curTotal;
               }
           }
           int answer = max - min;
           System.out.printf("#%d %d\n", i+1, answer);
        }
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
